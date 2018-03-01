package com.alwaysnearyou.controller;


import com.alwaysnearyou.dao.UserDAO;
import com.alwaysnearyou.entity.User;
import com.alwaysnearyou.service.UserService;
import com.alwaysnearyou.service.impl.MailServiceImpl;
import com.alwaysnearyou.utils.RandomCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private MailServiceImpl mailService;

    @RequestMapping(value= "/", method = RequestMethod.GET)
    public String signIn(ModelMap model) {
        return "login";
    }

    @RequestMapping(value= "/new", method = RequestMethod.GET)
    public String getCreateAccountPage() {
        return "createNewAccount";
    }

    @RequestMapping(value= "/save", method = RequestMethod.POST)
    public String save(@RequestParam String name, @RequestParam String surname,
                       @RequestParam String birthday, @RequestParam String password,
                       @RequestParam String gender, @RequestParam String country,
                       @RequestParam String address, @RequestParam String email,
                       @RequestParam int phone, @RequestParam MultipartFile avatar, HttpSession session,ModelMap model){

        String path = System.getProperty("user.home")+ File.separator +"Avatars\\";
        try {
            avatar.transferTo(new File(path+avatar.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        RandomCode randomCode = new RandomCode();
        int code = randomCode.randomNumber();

        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setBirthday(birthday);
        user.setPassword(password);
        user.setGender(gender);
        user.setCountry(country);
        user.setAddress(address);
        user.setEmail(email);
        user.setPhone(phone);
        user.setAvatar("\\userAvatar\\" + avatar.getOriginalFilename());
        user.setCode(code);


        userService.save(user);
        mailService.send(email, code);
        session.setAttribute("user",user.getId());
//        model.addAttribute("user",user);
        return "confirmPage";
    }

    @RequestMapping(value= "/confirm", method = RequestMethod.POST)
    public String confirm(@RequestParam int confirm, HttpSession session,ModelMap model){
        Integer id = (Integer) session.getAttribute("user");
        User user = userDAO.findUserById(id);
        int userCode = user.getCode();
        if (confirm == userCode){
            user.setActive(true);
            userService.save(user);
            session.setAttribute("user",user.getId());
            model.addAttribute("user", user);
            return "redirect:/mainPage";
        } else {
            System.out.println("ERRRRROOOOOORR");
            return null;
        }
    }

    @RequestMapping(value= "/logIn", method = RequestMethod.POST)
    public String logIn( @RequestParam("signinEmail") String email,
                         @RequestParam("signinPassword") String password, HttpSession session,ModelMap model){
        User user = userService.findUserByEmailAndPassword(email, password);
        if(!(user == null)) {
//            session.setAttribute("user", user);
            session.setAttribute("user", user.getId());
//            model.addAttribute("user", userDAO.findUserById(user.getId()));
            return "redirect:/mainPage";
        }else{
            return "errorSingnIn";
        }
    }

    @RequestMapping(value= "/mainPage", method = RequestMethod.GET)
    public String mainPage(ModelMap model, HttpSession session) {

        //TODO: redirect to login page
        Integer userId = (Integer) session.getAttribute("user");
        User userWithFriends = userService.getUserWithFriends(userId);
        List<User> allFriends = userWithFriends.getFriends();
        List<User> friendOf = userWithFriends.getFriendOf();
        model.addAttribute("user", userWithFriends);
        model.addAttribute("friends", allFriends);
        model.addAttribute("friendof", friendOf);
        return "mainPage";
    }

    @RequestMapping(value= "/search", method = RequestMethod.GET)
    public String search(@RequestParam String search,HttpSession session, ModelMap model){
        String[] parts = search.split(" ");
        if(parts.length >=2){
            String str1 = parts[0];
            String str2 = parts[1];
            List<User> foundUser = userService.findUserByNameAndSurname(str1, str2);
            System.out.println(foundUser.size());

            Integer userId = (Integer) session.getAttribute("user");
            User userWithFriends = userService.getUserWithFriends(userId);
            List<User> friends = userWithFriends.getFriends();
            foundUser.removeAll(friends);

//            Iterator i = foundUser.iterator();
//            while(i.hasNext()){
//                System.out.println("0000000000");
//                User user1 = (User) i.next();
//                Iterator j = friends.iterator();
//                System.out.println("1111");
//                while(j.hasNext()){
//                    System.out.println("22222");
//                    User us2 = (User) j.next();
//                    System.out.println("3");
//                    if (user1.getId().equals(us2.getId())){
//                        System.out.println("not delete");
//                        foundUser.remove(user1);
//                        System.out.println("remove");
//                    }
//                }
//            }
//            for (User u :foundUser) {
//                System.out.println("1");
//                for (User u2:friends) {
//                    System.out.println(2);
//                    if (!u.getId().equals(u2.getId())){
//                        newFoundUser.add(u2);
//                        System.out.println("add!!!!!!!!!!!!!!!!!!");
//                    }
//                }
//            }

            if (foundUser.size()==0){
                return "errorSingnIn";
            }else {
                model.addAttribute("user", userWithFriends);
                model.addAttribute("foundUsers", foundUser);
                return "searchPage";
            }
        }else{
        return "redirect:/mainPage";
        }
    }


    @RequestMapping(value= "/sendArequestToAFriend", method = RequestMethod.GET)
    public String sendArequestToAFriend(@RequestParam("fu-id") Integer id,Model model,HttpSession session) {
        Integer userId = (Integer) session.getAttribute("user");
        User userWithFriends = userService.getUserWithFriends(userId);
        userWithFriends.getFriends().add(userDAO.findUserById(id));
        userService.save(userWithFriends);
        session.setAttribute("user",userWithFriends.getId());
        model.addAttribute("user", userWithFriends);
        return "redirect:/mainPage";
    }
}