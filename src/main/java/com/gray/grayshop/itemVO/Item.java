package com.gray.grayshop.itemVO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    @Column(name = "item")
    private String item_name;

    @Column(name = "price")
    private int price;

    @Column(name = "count")
    private int count;
}
