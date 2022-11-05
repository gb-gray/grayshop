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
        model.addAttribute("memberForm", new MemberForm());

        return "join";
    }

    @PostMapping("/join/new")
    public String create(MemberForm form, BindingResult result){
        Member member = new Member();
        member.setUser_id(form.getUser_id());
        member.setUser_name(form.getUser_name());

        memberService.join(member);

        return "redirect:/";
    }

    @PostMapping("/join/check")
    public String findUser(MemberForm memberForm, Model model){
        String userCheck = "";
        userCheck = memberForm.getUser_id();

        String text = memberService.userCheck(userCheck);

        System.out.println(text);

        model.addAttribute("msg", text);

        return "join";
    }
}
