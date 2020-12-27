package com.part5.mapper;

import org.apache.ibatis.annotations.Insert;

public interface TxExam2Mapper {
	
	@Insert("INSERT INTO TBL_TX_SAMPLE2 (COL2) VALUES (#{data})")
	public int insertCol2(String data);
}
