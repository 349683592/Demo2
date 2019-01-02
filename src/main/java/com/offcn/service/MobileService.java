package com.offcn.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.offcn.pojo.Mobile;


public interface MobileService {
	public void saveMobile(List<Mobile> list);
	
	
	public Mobile findMobile(String mobilenumber);
}
