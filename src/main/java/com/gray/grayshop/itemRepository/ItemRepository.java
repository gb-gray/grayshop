package com.gray.grayshop.itemRepository;

import com.gray.grayshop.itemVO.Item;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ItemRepository {

    @PersistenceContext
    EntityManager em;

    public void save(Item item){

        em.persist(item);
    }
}
