package com.alwaysnearyou.controller;

import com.alwaysnearyou.dao.UserDAO;
import com.alwaysnearyou.entity.Room;
import com.alwaysnearyou.entity.User;
import com.alwaysnearyou.service.UserService;
import com.alwaysnearyou.service.impl.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class FriendsController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoomServiceImpl roomService;

    @RequestMapping(value= "/search", method = RequestMethod.GET)
    public String search(@RequestParam String search, HttpSession session, ModelMap model){
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
    public String addToFriend(@RequestParam("friendof-id") Integer id, Model model, HttpSession session) {
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
}