package com.gray.grayshop.controller;
import com.gray.grayshop.memberVo.Member;
import com.gray.grayshop.memberVo.MemberForm;
import com.gray.grayshop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


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

    @ResponseBody
    @RequestMapping("/join/check")
    public String findUser(@RequestParam("data") String data, Model model){
        String userCheck = data;
        System.out.println(userCheck);
        String text = memberService.userCheck(userCheck);

        System.out.println(text);

        //model.addAttribute("msg", text);

        return text;
    }

    //로그인
    @GetMapping("/login")
    public String login(Model model){ //
        model.addAttribute("member", new Member());
        return "login";
    }

    //로그인프로
//    @PostMapping("/loginPro")
//    public ModelAndView loginPro(Member member){
//        System.out.println(member.getUser_id() + member.getUser_name());
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("/index");
//        mv.addObject("asd","dd");
//        return mv;
//    }





}
