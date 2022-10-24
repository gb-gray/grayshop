package com.gray.grayshop.memberVo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 20)
    private String username;

    @Column(nullable = false, length = 20)
    private String password;

    @Column(nullable = false, length = 255)
    private String address;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 3)
    private int phone1;

    @Column(nullable = false, length = 4)
    private int phone2;

    @Column(nullable = false, length = 4)
    private int phone3;

    @CreationTimestamp
    private Timestamp crateDate;
}
