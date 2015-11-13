package com.trello.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.trello.model.AccountForm;

@Controller

public class AccountController extends AbstractController{
	
	private static final Logger log = LoggerFactory.getLogger(AccountController.class);
	
	@RequestMapping(value = "/users", method=RequestMethod.GET)
	public ModelAndView getRegistrationForm(Model model){
		model.addAttribute("account", new AccountForm());
		
		return new ModelAndView("registrationForm");
	}
	
	@RequestMapping(value = "/viewTables", method = RequestMethod.POST)
	public String postRegistrationForm(AccountForm form){
		log.info("Create registration: {}", form);
		return "redirect:/viewTables";
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}
