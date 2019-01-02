package com.offcn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.offcn.pojo.Mobile;
import com.offcn.service.MobileService;

@Controller
@RequestMapping("/mobile")
public class MobileController {
	
	@Autowired
	MobileService mobileServce;
	
	@RequestMapping(value="/findMobile",produces="text/html;charset=utf-8")
	@ResponseBody
	public String findMobile(String mobilenumber){
		String substring = mobilenumber.substring(0,7);
		Mobile mobile = mobileServce.findMobile(substring);
		if(mobile!=null){
			String areacode = mobile.getMobilearea();
			return "号码归属地: "+areacode+" 通信商:"+mobile.getMobiletype();
		}
		return "该号段不存在";
	}
}
