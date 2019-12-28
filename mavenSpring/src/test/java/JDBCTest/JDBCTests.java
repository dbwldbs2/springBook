package JDBCTest;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JDBCTests {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch	(Exception e) {
			log.info(e.toString());
		}
	}
	
	@Test
	public void testConnection() {
		try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl"
														 , "book_ex"
														 , "book_ex")) {
			log.info(con.toString());
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}
}
