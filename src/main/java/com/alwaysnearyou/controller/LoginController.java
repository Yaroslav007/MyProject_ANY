package com.alwaysnearyou.controller;

import com.alwaysnearyou.dao.UserDAO;
import com.alwaysnearyou.entity.User;
import com.alwaysnearyou.service.UserService;
import com.alwaysnearyou.service.impl.MailServiceImpl;
import com.alwaysnearyou.utils.RandomCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private MailServiceImpl mailService;

    @RequestMapping(value= "/new", method = RequestMethod.GET)
    public String getCreateAccountPage() {
        return "createNewAccount";
    }

    @RequestMapping(value= "/save", method = RequestMethod.POST) // TODO: use /login/save instead
    public String save(@RequestParam String name, @RequestParam String surname,
                       @RequestParam String birthday, @RequestParam String password,
                       @RequestParam String gender, @RequestParam String country,
                       @RequestParam String address, @RequestParam String email,
                       @RequestParam int phone, @RequestParam MultipartFile avatar, HttpSession session,ModelMap model){

        String path = System.getProperty("user.home") + File.separator + "Avatars\\";
        try {
            avatar.transferTo(new File(path + avatar.getOriginalFilename()));
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
        System.out.println(user);

        userService.save(user);
        mailService.send(email, code);
        session.setAttribute("user",user.getId());
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
            return "errorConfirm";
        }
    }

    @RequestMapping(value= "/logIn", method = RequestMethod.POST)
    public String logIn( @RequestParam("signinEmail") String email,
                         @RequestParam("signinPassword") String password, HttpSession session,ModelMap model){
        User user = userService.findUserByEmailAndPassword(email, password);
        if(user != null) {
            session.setAttribute("user", user.getId());
            return "redirect:/mainPage";
        }else{
            return "errorSingnIn";
        }
    }

    @RequestMapping(value= "/logIn", method = RequestMethod.GET)
    public String logIn(){
        return "login";
    }

    @RequestMapping(value= "/signOut", method = RequestMethod.GET)
    public String signOut( HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }
}