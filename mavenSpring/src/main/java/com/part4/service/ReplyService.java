package com.part4.service;

import java.util.List;

import com.part3.domain.Criteria;
import com.part4.domain.ReplyPageDTO;
import com.part4.domain.ReplyVO;

public interface ReplyService {
public int register(ReplyVO vo);
	
	public ReplyVO get(Long rno);
	
	public int modify(ReplyVO vo);
	
	public int remove(Long rno);
	
	public List<ReplyVO> getList(Criteria cri, Long bno);
	
	public ReplyPageDTO getListPage(Criteria cri, Long bno);
}
