package com.example.demo3.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class User {
	@Id
	private String email;
	private String name;
	private Date createdDate;
	@OneToOne(mappedBy = "owner")
	private MembershipCard card;

}
