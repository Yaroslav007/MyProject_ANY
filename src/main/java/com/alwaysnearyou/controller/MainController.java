package com.alwaysnearyou.controller;


import com.alwaysnearyou.entity.User;
import com.alwaysnearyou.service.MailService;
import com.alwaysnearyou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
//        model.addAttribute("greeting", "Hello World from Spring 4 MVC");
        return "createNewAccount";
//        return "createNewAccount";
    }

    @RequestMapping(value= "/save", method = RequestMethod.POST)
    public String save(@RequestParam String name, @RequestParam String surname,
                       @RequestParam String birthday, @RequestParam String password,
                       @RequestParam String gender, @RequestParam String country,
                       @RequestParam String address, @RequestParam String email,
                       @RequestParam int phone, @RequestParam MultipartFile avatar){

        String path = System.getProperty("user.home")+ File.separator +"Avatars\\";
        try {
            avatar.transferTo(new File(path+avatar.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }

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

        userService.save(user);
        mailService.send(user);
        return "redirect:/";
    }

}