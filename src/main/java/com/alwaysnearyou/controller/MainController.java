package com.alwaysnearyou.controller;


import com.alwaysnearyou.entity.User;
import com.alwaysnearyou.service.UserService;
import com.alwaysnearyou.service.impl.MailServiceImpl;
import com.alwaysnearyou.utils.RandomCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;


@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private MailServiceImpl mailService;

    @RequestMapping(value= "/", method = RequestMethod.GET)
    public String signIn(ModelMap model) {
        return "login";
    }

    @RequestMapping(value= "/new", method = RequestMethod.GET)
    public String getCreateAccountPage(ModelMap model) {
        return "createNewAccount";
    }

    @RequestMapping(value= "/save", method = RequestMethod.POST)
    public String save(@RequestParam String name, @RequestParam String surname,
                       @RequestParam String birthday, @RequestParam String password,
                       @RequestParam String gender, @RequestParam String country,
                       @RequestParam String address, @RequestParam String email,
                       @RequestParam int phone, @RequestParam MultipartFile avatar, HttpSession session){

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
        session.setAttribute("user",user);
        return "confirmPage";
    }

    @RequestMapping(value= "/confirm", method = RequestMethod.POST)
    public String confirm(@RequestParam int confirm, HttpSession session){
        User user = (User) session.getAttribute("user");
        int userCode = user.getCode();
        if (confirm == userCode){
            user.setActive(true);
            userService.save(user);
            return "mainPage";
        } else {
            System.out.println("ERRRRROOOOOORR");
            return null;
        }
    }

    @RequestMapping(value= "/logIn", method = RequestMethod.POST)
    public String logIn( @RequestParam("signinEmail") String email,
                         @RequestParam("signinPassword") String password, HttpSession session){
        User user = userService.findUserByEmailAndPassword(email, password);
        if(!(user == null)) {
            session.setAttribute("user", user);
            return "mainPage";
        }else{
            return "errorSingnIn";
        }
    }

}