package com.gray.grayshop.memberRepository;

import com.gray.grayshop.memberVo.Member;
import com.gray.grayshop.memberVo.MemberForm;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    EntityManager em;

    public void save(Member member){

        em.persist(member);

    }

    public MemberForm find(Long id){

        return em.find(MemberForm.class, id);
    }


}
