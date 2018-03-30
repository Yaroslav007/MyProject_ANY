package com.alwaysnearyou.controller;


import com.alwaysnearyou.dao.RoomDao;
import com.alwaysnearyou.dao.UserDAO;
import com.alwaysnearyou.entity.Message;
import com.alwaysnearyou.entity.Room;
import com.alwaysnearyou.entity.User;
import com.alwaysnearyou.service.MessageService;
import com.alwaysnearyou.service.UserService;
import com.alwaysnearyou.service.impl.MailServiceImpl;
import com.alwaysnearyou.service.impl.RoomServiceImpl;
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

import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoomServiceImpl roomService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private MailServiceImpl mailService;

    @RequestMapping(value= "/", method = RequestMethod.GET)
    public String signIn(ModelMap model, HttpSession session) {
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
        System.out.println("sadsdasdas");
        user.setBirthday(birthday);
        user.setPassword(password);
        user.setGender(gender);
        user.setCountry(country);
        user.setAddress(address);
        user.setEmail(email);
        user.setPhone(phone);
        user.setAvatar("\\userAvatar\\" + avatar.getOriginalFilename());
        user.setCode(code);
        System.out.println(user);


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

    private void modelMethod(HttpSession session, ModelMap model){
        Integer userId = (Integer) session.getAttribute("user");
        User userWithFriends = userService.getUserWithFriends(userId);
        List<User> allFriends = userWithFriends.getFriends();
        List<User> friendOf = userWithFriends.getFriendOf();
        friendOf.removeAll(allFriends);
        model.addAttribute("user", userWithFriends);
        model.addAttribute("friends", allFriends);
        model.addAttribute("friendof", friendOf);
    }


    @RequestMapping(value= "/mainPage", method = RequestMethod.GET)
    public String mainPage(ModelMap model, HttpSession session) {

        //TODO: redirect to login page
        modelMethod(session,model);
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

    private void sendRequest(Integer id, Model model, HttpSession session){
        Integer userId = (Integer) session.getAttribute("user");
        User userWithFriends = userService.getUserWithFriends(userId);
        userWithFriends.getFriends().add(userDAO.findUserById(id));
        userService.save(userWithFriends);
        session.setAttribute("user",userWithFriends.getId());
        model.addAttribute("user", userWithFriends);
    }

    @RequestMapping(value= "/sendRequestToFriend", method = RequestMethod.GET)
    public String sendArequestToAFriend(@RequestParam("fu-id") Integer id,Model model,HttpSession session) {
        sendRequest(id, model, session);
        return "redirect:/mainPage";
    }

    @RequestMapping(value="/friendRequest",params="addToFriend",method=RequestMethod.GET)
    public String addToFriend(@RequestParam("friendof-id") Integer id,Model model,HttpSession session) {
        sendRequest(id, model, session);
        Integer userId = (Integer) session.getAttribute("user");
        String user1 = userService.findUserById(userId).getEmail();
        String user2 = userDAO.findUserById(userId).getEmail();
        String roomName = user1+user2;
        Date date = new Date();
        Room room = new Room(roomName,date);
        roomService.save(room);
        return "redirect:/mainPage";
    }

    @RequestMapping(value="/friendRequest",params="deleteRequest",method=RequestMethod.GET)
    public String deleteRequest(@RequestParam("friendof-id") Integer id,Model model,HttpSession session) {
        User requestUserWithFriends = userService.getUserWithFriends(id);
        Integer userId = (Integer) session.getAttribute("user");
        User userWithFriends = userService.getUserWithFriends(userId);
        requestUserWithFriends.getFriends().remove(userWithFriends);
        userService.save(requestUserWithFriends);
        session.setAttribute("user",userWithFriends.getId());
        model.addAttribute("user", userWithFriends);
        return "redirect:/mainPage";
    }

    @RequestMapping(value="/user-{id}",method=RequestMethod.GET)
    public String room(@PathVariable int id, ModelMap model,HttpSession session) {
        Integer userId = (Integer) session.getAttribute("user");
        User currentUser = userService.getUserWithFriends(userId);
        User user = userService.findUserById(id);
        String str1 = currentUser.getEmail();
        String str2 = user.getEmail();
        Room room = roomService.findRoom(str1);
        if (room==null){
            room = roomService.findRoom(str2);
        }
        modelMethod(session,model);
        model.addAttribute("room",room);
        return "mainPage";
    }

//    @RequestMapping(value="/sendMessage",method=RequestMethod.POST)
//    public String sendMessage(@RequestParam("room-id") Integer id,@RequestParam String textMessage, ModelMap model,HttpSession session) {
//        Integer userId = (Integer) session.getAttribute("user");
//        Room room = roomService.findRoomById(id);
////        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date=new Date();
//        Message message = new Message(textMessage,date,userId,room);
//        messageService.save(message);
//        modelMethod(session,model);
//        model.addAttribute("room",room);
//        return "mainPage";
//    }

}