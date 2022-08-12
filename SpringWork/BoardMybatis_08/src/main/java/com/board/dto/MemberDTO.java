package com.board.dto;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MemberDTO {
 private String id;
 private String name;
 private String pass;
 private String addr;
 private Date regdate;
}
