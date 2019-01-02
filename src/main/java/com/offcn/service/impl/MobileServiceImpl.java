package com.offcn.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.mapper.MobileMapper;
import com.offcn.pojo.Mobile;
import com.offcn.service.MobileService;


@Service
public class MobileServiceImpl implements MobileService {

	@Autowired
	MobileMapper mobileMapper;
	@Override
	public void saveMobile(List<Mobile> list) {
		// TODO Auto-generated method stub
		mobileMapper.saveMobile(list);
	}
	@Override
	public Mobile findMobile(String mobilenumber) {
		// TODO Auto-generated method stub
		return mobileMapper.findMobile(mobilenumber);
	}

}
