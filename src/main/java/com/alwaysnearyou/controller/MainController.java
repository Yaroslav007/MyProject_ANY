package com.alwaysnearyou.controller;

import com.alwaysnearyou.dao.UserDAO;
import com.alwaysnearyou.entity.User;
import com.alwaysnearyou.service.MessageService;
import com.alwaysnearyou.service.UserService;
import com.alwaysnearyou.service.impl.MailServiceImpl;
import com.alwaysnearyou.service.impl.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
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
        modelMethod(session, model);
        return "mainPage";
    }
}