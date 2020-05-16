package com.part3.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.part3.domain.BoardVO;
import com.part3.domain.Criteria;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Slf4j
public class BoardMapperTests {
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info("{}", board));
	}
	
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		mapper.insertSelectKey(board);
		
		//log.info("{}", board);
	}
	
	@Test
	public void testRead() {
		BoardVO board = mapper.read(9L);
		 
		//log.info("9번째 정보 :: {}", board);
	}
	
	@Test
	public void testDelete() {
		log.info("DELETE COUNT :: {}", mapper.delete(9L));
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(24L);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("user00");
		
		int count = mapper.update(board);
		//log.info("UPDATE COUNT :: {}", count);
	}
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		cri.setPageNum(3);
		cri.setAmount(10);
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(board -> log.info("board :: {}", board.getBno()));
	}
	
	@Test
	public void testSearch() {
		Criteria cri = new Criteria();
		cri.setKeyword("테스트");
		cri.setType("TC");
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(board -> log.info("search :: {}", board));
	}
}
