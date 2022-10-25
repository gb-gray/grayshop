package com.gray.grayshop.controller;

import com.gray.grayshop.memberVo.Member;
import com.gray.grayshop.memberVo.MemberForm;
import com.gray.grayshop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/index")
    public String index(Model model){

        return "index";
    }

    @GetMapping("/join")
    public String join(Model model){
        System.out.println("1");
        model.addAttribute("memberForm", new MemberForm());

        return "join";
    }

    @PostMapping("/join/new")
    public String create(MemberForm form, BindingResult result){
        System.out.println("2");
        System.out.println(form.getUsername());

        Member member = new Member();

        member.setUsername(form.getUsername());

        memberService.join(member);

        return "redirect:/";
    }
}
