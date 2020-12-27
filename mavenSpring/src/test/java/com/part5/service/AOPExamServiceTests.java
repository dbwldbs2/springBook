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
public class AOPExamServiceTests {
	
	@Setter(onMethod_ = @Autowired)
	private AOPExamService service;
	
	@Test
	public void testClass() {
		log.info("===========testClass===========");
		log.info(service.toString());
		log.info(service.getClass().getName());
	}
	
	@Test
	public void testAdd() throws Exception {
		log.info("===========testAdd===========");
		log.info(service.doAdd("123", "456").toString());
	}
	
	@Test
	public void testAddError() throws Exception {
		log.info("===========testAddError===========");
		log.info(service.doAdd("123", "ABC").toString());
	}
}
