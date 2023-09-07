package com.sist.web.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
Columns:
no int
NAME text
CATEGORY text
INFO json
PRICE int
DISCOUNT_PRICE int
DELIVERY text
STAR_SUM int
STAR_CNT int
POSTER text
 */
@Entity
@Table(name = "goods")
@Getter
@Setter
public class GoodsEntity {
    @Id
    private int no;
    private String name,category,delivery,poster;
    private int price, discount_price, star_sum,star_cnt;

}
