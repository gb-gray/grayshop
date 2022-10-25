package com.gray.grayshop.service;

import com.gray.grayshop.memberRepository.MemberRepository;
import com.gray.grayshop.memberVo.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

}
