package com.example.demo.dao;

import com.example.demo.entity.Inquiry;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository // 让DI容器知道这是一个操作数据库的类
public class InquiryDaolmpl implements InquiryDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public InquiryDaolmpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insertInquiry(Inquiry inquiry) {
		jdbcTemplate.update("INSERT INTO inquiry(name,email,contents,created)VALUES(?,?,?,?)", inquiry.getName(),
				inquiry.getEmail(), inquiry.getContents(), inquiry.getCreated());
	}

	@Override
	public List<Inquiry> getAll() {

		String sql = "SELECT id,name,email,contents,created FROM inquiry";
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		List<Inquiry> list = new ArrayList<>();
		for (Map<String, Object> result : resultList) {
			Inquiry inquiry = new Inquiry();

			inquiry.setId((int) result.get("id"));
			inquiry.setName((String) result.get("name"));
			inquiry.setEmail((String) result.get("email"));
			inquiry.setContents((String) result.get("contents"));
			inquiry.setCreated((LocalDateTime) result.get("created"));
			list.add(inquiry);
		}
		return list;
	}

}