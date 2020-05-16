package com.part3.mapper;

import java.util.List;

import com.part3.domain.BoardVO;
import com.part3.domain.Criteria;

public interface BoardMapper {
	//@Select("SELECT * FROM TBL_BOARD WHERE BNO > 0")
	public List<BoardVO> getList();
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
	
	public BoardVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVO board);
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	public int getTotalCount(Criteria cri);
}
