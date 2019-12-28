package JDBCTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

@Slf4j
public class timeMapperTests {
	@Autowired
	private TimeMapper timeMapper;

	
	@Test
	public void testGetTime() {
		log.info("getClass :: " + timeMapper.getClass().getName().toString());
		log.info("getTime :: " + timeMapper.getTime().toString());
		log.info("getTime2 :: " + timeMapper.getTime2().toString());
	}
}
