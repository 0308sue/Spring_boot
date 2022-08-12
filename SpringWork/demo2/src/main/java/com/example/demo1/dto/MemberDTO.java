package com.example.demo1.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MemberDTO {
	private String userid;
	private String userpw;
	private String username;
	private String regDate;
	private String updateDate;
	private boolean enabled;
	private List<AuthDTO> authList;

}
