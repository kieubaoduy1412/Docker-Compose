package duy.nissho.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import duy.nissho.model.Demo;

@Controller
public class HelloWorldController {
	@Value("${spring.datasource.url}") private String url;
	
	@RequestMapping("/hello")
	public String hello(Model model) throws SQLException {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		
		
		
		dataSource.setDriver(new com.mysql.jdbc.Driver());
		dataSource.setUrl(url);
		dataSource.setUsername("root");
		dataSource.setPassword("root");

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		String sqlSelect = "SELECT * FROM hello";
		
		List<Demo> listContact = jdbcTemplate.query(sqlSelect, new RowMapper<Demo>() {

			@Override
			public Demo mapRow(ResultSet rs, int rowNum) throws SQLException {
				Demo demo = new Demo();
				demo.setID(rs.getInt("ID"));
				demo.setHello(rs.getString("text"));
				return demo;
			}
		
		});
	
		model.addAttribute("greeting", listContact.get(0).getHello());

	return "helloworld";

	}
	
	@RequestMapping("/hello1")
	public String hello1(Model model) throws SQLException {
		model.addAttribute("greeting2", url);
		return "helloworld1";

	}
}
