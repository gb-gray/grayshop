package com.gray.grayshop.controller;

import com.gray.grayshop.memberVo.Member;
import com.gray.grayshop.memberVo.MemberForm;
import com.gray.grayshop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

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
        member.setPassword(form.getPassword());
        member.setPhone(form.getPhone());
        member.setAddress(form.getAddress());
        member.setEmail(form.getEmail());

        memberService.join(member);

        return "redirect:/";
    }

    @RequestMapping("/join/check")
    @ResponseBody
    public String findUser(@RequestParam("data") String data){
        String userCheck = data;
        System.out.println(userCheck);
        String text = memberService.userCheck(userCheck);

        System.out.println(text);

        //model.addAttribute("msg", text);

        return text;
    }

    //로그인
    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("member", new Member());
        return "login";
    }

    //로그인프로
    @PostMapping("/loginPro")
    public String loginPro(Member member,Model model){
        System.out.println(member.getUser_id() +" / " + member.getPassword());
        System.out.println(member.getUser_name());
        Long result = memberService.count(member);
        //System.out.println("다 갔다옴"+result);

        model.addAttribute("loginCh",result);
        model.addAttribute("user_id", member.getUser_id());
        model.addAttribute("user_name", member.getUser_name());
        return "login";
    }

    //로그인 성공
    @GetMapping("/login/index")
    public String loginSuccess(@RequestParam("user_id") String user_id, @RequestParam("user_name") String user_name,
    Model model){

        System.out.println(user_id);
        System.out.println(user_name);

        model.addAttribute("user_id", user_id);
        model.addAttribute("user_name", user_name);
        return "loginIndex";
    }


}
