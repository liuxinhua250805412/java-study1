package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.InquiryDao;
import com.example.demo.entity.Inquiry;

@Service // 在DI容器中自动实例化的单例
public class InquiryServiceImpl implements InquiryService {
	private final InquiryDao dao;

	
	@Autowired InquiryServiceImpl(InquiryDao dao) {
		this.dao = dao;
	};

	@Override
	public void save(Inquiry inquiry) {
		dao.insertInquiry(inquiry);

	}

	@Override
	public List<Inquiry> geAll() {

		return dao.getAll();
	}

}
