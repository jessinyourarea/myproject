package com.sist.web.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/*
RNO int
IMAGE text
CAR_NAME text
CAR_TYPE text
MAKER text
INWON int
FUEL text
CAR_OPTION text
PRICE int
 */
@Entity
@Table(name="rent2")
@Getter
@Setter
public class RentEntity {
    @Id
    private int rno;
    @Column(name = "car_name")
    private String carName;
    @Column(name = "car_type")
    private String carType;
    @Column(name = "car_option")
    private String carOption;
    private String image,maker,fuel;
    private int inwon,price;
}
