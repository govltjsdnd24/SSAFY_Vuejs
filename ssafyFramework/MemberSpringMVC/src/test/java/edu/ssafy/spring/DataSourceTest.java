package edu.ssafy.spring;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/servlet-context.xml"})
public class DataSourceTest {
	
	@Autowired
	DataSource ds;
	
	@Test
	public void testDataSource() throws SQLException {
		System.out.println(ds.getConnection());
		System.out.println(ds.toString());
		assertNotNull(ds);
	}
	
	@Test
	public void testDataSource2() throws SQLException {
		Connection conn=ds.getConnection();
		String sql= "SELECT * FROM members ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+",");
		}
	}
	
}
