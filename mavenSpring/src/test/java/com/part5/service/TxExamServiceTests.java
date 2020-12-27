package com.part5.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TxExamServiceTests {
	
	@Setter(onMethod_ = {@Autowired})
	private TxExamService service;
	
	@Test
	public void testLong() {
		String str= "starry\r\n" 
					+ "starry night\r\n" 
					+ "Paint your palette blue and grey\r\n"
					+ "Look out on a summer's day";
		
		log.info(Integer.toString(str.getBytes().toString().length()));
		
		service.addData(str);
	}
}
