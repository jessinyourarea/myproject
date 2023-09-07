package com.sist.web.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="food_house")
@Getter
@Setter
public class FoodEntity {
	@Id // 자동증가번호 // Entity는 자동으로 sql 문장을 생성해줌(그래서 vo의 변수명와 sql의 컬럼명이 같아야 함)
	private int fno;
	private int cno, good, soso, bad, hit;
	private String name, address, phone, type, price, parking, time, menu, poster, reserve_day;
	private double score;
}
