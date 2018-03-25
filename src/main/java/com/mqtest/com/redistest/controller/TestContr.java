package com.mqtest.com.redistest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mqtest.com.redistest.service.Dayservice;


@RestController
@RequestMapping("/days")
public class TestContr {
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private Dayservice dayservice;
	@RequestMapping("")
	public String weekdaysOrweekend(){
		String date = request.getParameter("days");
		String res = dayservice.getStr(date);
		return "0".equals(res)?"工作日":"休息日";
	}
}
