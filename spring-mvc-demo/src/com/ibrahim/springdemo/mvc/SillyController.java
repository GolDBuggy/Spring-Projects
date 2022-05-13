package com.ibrahim.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SillyController {

	@RequestMapping("/form-page")
	public String displayTheForm() {
		return "silly";
	}
}
