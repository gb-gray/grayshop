package com.gray.grayshop.orderVO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;


}
