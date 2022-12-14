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


    public Long count(String user_id, String password){
       // System.out.println("여기까지오는게맞나요?");
         Long result = em.createQuery("select count(m) from Member m where m.user_id = :user_id and m.password = :password", Long.class)
                 .setParameter("user_id", user_id)
                 .setParameter("password", password)
                 .getSingleResult();

        return result;
    }

    //유저 정보가져오기
    public Member findByMemberInfo(String user_id){
        return em.createQuery("select m from Member m where m.user_id = :user_id", Member.class)
                .setParameter("user_id", user_id)
                .getSingleResult();
    }

}
