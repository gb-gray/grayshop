package com.gray.grayshop.memberVo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter @Setter
public class MemberForm {

    private String user_id;
    private String user_name;
    private String password;
    private String zipCode;
    private String address;
    private String addressDtl;
    private String email;
    private String emailOption;
    private String phone;
}
