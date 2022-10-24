package com.gray.grayshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @GetMapping("/index")
    public String index(Model model){

        return "index";
    }

    @GetMapping("/join")
    public String join(Model model){


        return "join";
    }
}
