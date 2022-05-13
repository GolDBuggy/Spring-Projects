package com.ibrahim.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HomeController {
	
	@RequestMapping("/")
	public String showPage() {
		return "main-menu";
	}
	
	@RequestMapping("/form-page")
	public String formPage() {
		return "form-page";
	}
	
	
	@RequestMapping("/processAction")
	public String processAction() {
		return "form-Action";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String letShoutDude(@RequestParam("studentName") String theName,Model model) {
		
		theName=theName.toUpperCase();
		String result="Yo! "+theName;
		
		model.addAttribute("message",result);
		return "form-Action";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(HttpServletRequest request ,Model model) {
		String theName=request.getParameter("studentName");
		theName=theName.toUpperCase();
		String result="Yo! "+theName;
		
		model.addAttribute("message",result);
		return "form-Action";
	}

}
