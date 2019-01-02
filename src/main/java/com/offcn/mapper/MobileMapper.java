package com.offcn.mapper;

import java.util.List;

import com.offcn.pojo.Mobile;

public interface MobileMapper {
	public void saveMobile(List<Mobile> list);
	
	public Mobile findMobile(String mobilenumber);
	
	//公司新人
	public void all();
	
}
