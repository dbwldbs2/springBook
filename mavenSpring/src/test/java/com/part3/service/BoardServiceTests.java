package com.part3.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.part3.domain.BoardVO;
import com.part3.domain.Criteria;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Slf4j
public class BoardServiceTests {
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	@Test
	public void testExist() {
		log.info(" :: {}", service);
		assertNotNull(service);
	}
	
	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		service.register(board);
		
		log.info("새로 생성된 게시물의 번호 :: {}", board.getBno());
	}
	

	@Test
	public void testGetList() {
		//service.getList().forEach(board -> log.info("{}", board));
		service.getList(new Criteria(2 ,10)).forEach(board -> log.info("{}", board));
	}
	
	
	
	@Test
	public void testGet() {
		log.info("{}", service.get(24L));
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = service.get(24L);
		
		if(board == null) {
			return;
		}
		
		board.setTitle("제목 수정합니다.");
		log.info("MODIFY RESULT :: {}" +service.modify(board));
	}
	
	@Test
	public void testDelete() {
		log.info("REMOVE RESULT :: {}" , service.remove(93L));
	}
}
