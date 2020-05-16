package com.part3.domain;

import java.util.Date;

import lombok.Data;

@Data //getter(), setter(), toString()생성
public class BoardVO {
	private Long bno; //키값
	private String title; //제목
	private String content; //내용
	private String writer; //작성자
	private Date regdate; //등록일자
	private Date updateDate; //수정일자
}
