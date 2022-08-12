package com.example.parkingtest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
public class Car {
	@Id
	private String carNum; //차량번호
	private String carName; //차량이름
	private String carType; //차량타입(소형,대형)

	private int parkingId; // 주차장
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "intime")
	private Date intime;
	
	private Date outtime;
	
	private String parkingType;
	
	private int fee;

}
