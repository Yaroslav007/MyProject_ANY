package com.alwaysnearyou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class BaseController {

    @RequestMapping(value= "/", method = RequestMethod.GET)
    public String signIn(ModelMap model, HttpSession session) {
        return "redirect:/mainPage";
    }

}