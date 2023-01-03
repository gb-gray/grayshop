package com.gray.grayshop.controller;

import com.gray.grayshop.itemVO.ItemForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {

    @GetMapping("/itemCreate")
    public String ItemCreate(Model model){
        model.addAttribute("itemForm", new ItemForm());

        return "item";
    }
}
