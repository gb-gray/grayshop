package com.gray.grayshop.itemVO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemForm {
    private String item; //상품이름
    private int price;  //상품가격
    private int count; //재고

}
