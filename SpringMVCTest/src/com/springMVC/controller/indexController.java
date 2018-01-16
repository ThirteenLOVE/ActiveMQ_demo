package com.springMVC.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.activeMQ.sendService.sendService;

@Controller
public class indexController{
	@Autowired
	private sendService sendServices;
	
	@RequestMapping( value="/index")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response,Model model)
			throws Exception {
		model.addAttribute("demoStr", "HelloActiveMQ");
		return new ModelAndView("index");
	}
	@ResponseBody
	@RequestMapping( value="/sendInfo",method = {RequestMethod.GET, RequestMethod.POST})
	public String sendInfo(HttpServletRequest request, HttpServletResponse response,Model model)
			throws Exception {
		String sendinfo=request.getParameter("sendInfo");
		sendServices.sendMessage("MailQueue", sendinfo);
		return "success";
	}
}
