package com.gray.grayshop.memberRepository;

import com.gray.grayshop.memberVo.Member;
import com.gray.grayshop.memberVo.MemberForm;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    EntityManager em;

    public void save(Member member){

        em.persist(member);

    }

    public List<Member> userCheck(String user_id){
        System.out.println("repository");

        return em.createQuery("select m from Member m where m.user_id = :user_id", Member.class)
                .setParameter("user_id", user_id)
                .getResultList();

    }


    public Long count(String user_id, String user_name){
       // System.out.println("여기까지오는게맞나요?");
         Long result = em.createQuery("select count(m) from Member m where m.user_id = :user_id and m.user_name = :user_name", Long.class)
                 .setParameter("user_id", user_id)
                 .setParameter("user_name", user_name)
                 .getSingleResult();

        return result;
    }

}
