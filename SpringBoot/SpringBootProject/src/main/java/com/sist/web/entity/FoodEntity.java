package com.sist.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

@Entity
@Table(name="food_location")
public class FoodEntity {
	// 자동증가 번호 == @id
	@Id
	private int fno;
	private int hit;
	private String name,address,tel,type,price,time,parking,menu,poster;
	private double score;
}
