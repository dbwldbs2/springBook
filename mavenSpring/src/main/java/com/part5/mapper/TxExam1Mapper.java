package com.part5.mapper;

import org.apache.ibatis.annotations.Insert;

public interface TxExam1Mapper {
	
	@Insert("INSERT INTO TBL_TX_SAMPLE1 (COL1) VALUES (#{data})")
	public int insertCol1(String data);
}
