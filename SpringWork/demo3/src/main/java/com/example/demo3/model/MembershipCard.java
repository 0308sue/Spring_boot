package com.example.demo3.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class MembershipCard {
	@Id
	private String CardNumber;
	@OneToOne
	@JoinColumn(name = "user_email")
	private User owner;
	private Date expiryDate;
	private boolean enabled;
}
