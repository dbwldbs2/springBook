package com.part5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.part5.mapper.TxExam1Mapper;
import com.part5.mapper.TxExam2Mapper;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TxExamServiceImpl implements TxExamService{
	
	@Setter(onMethod_= {@Autowired})
	private TxExam1Mapper mapper1;
	
	@Setter(onMethod_= {@Autowired})
	private TxExam2Mapper mapper2;
	
	@Transactional
	@Override
	public void addData(String value) {
		log.info("mapper1.......");
		mapper1.insertCol1(value);
		
		log.info("mapper2.......");
		mapper2.insertCol2(value);
		
		log.info("end.....................");
	}
}
