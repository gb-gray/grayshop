package com.gray.grayshop.service;

import com.gray.grayshop.memberRepository.MemberRepository;
import com.gray.grayshop.memberVo.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member){
        memberRepository.save(member);

        return member.getId();
    }

    public String userCheck(String user_id){
        String text = "";
        System.out.println("service");
        List<Member> member = memberRepository.userCheck(user_id);

        if(!member.isEmpty()){
            text = "이미 존재하는 회원입니다.";
        }else{
            text = "사용할 수 있는 아이디입니다.";
        }

        return text;
//        if(user_id.equals(member.get(0).getUser_id())){
//             text = "이미 존재하는 아이디입니다.";
//
//        }else{
//            text = "사용할 수 있는 아이디입니다.";
//        }
    }

    //로그인
    public long count (Member member) {
       // System.out.println(member.getUser_id() + " "+ member.getUser_name());
        return memberRepository.count(member.getUser_id(), member.getPassword());
    }



}
