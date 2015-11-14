package com.trello.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.trello.model.AccountForm;

@Controller

public class AccountController extends AbstractController{
	
	/*private static final Logger log = LoggerFactory.getLogger(AccountController.class);
	
	
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
	
	*/
	private static final String VN_REG_FORM = "registrationForm";
	private static final String VN_REG_OK = "redirect:/registration_ok.html";
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setAllowedFields(new String[] { 
			"username", "password", "confirmPassword",
			"firstName", "lastName", "email", "marketingOk", "acceptTerms"
		});
		
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	@RequestMapping(value = "/users", method=RequestMethod.GET)
	public ModelAndView getRegistrationForm(Model model){
		model.addAttribute("account", new AccountForm());
		
		return new ModelAndView(VN_REG_FORM);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String postRegistrationForm(
			@ModelAttribute("account") @Valid AccountForm form,
			BindingResult result) {
		
		convertPasswordError(result);
		return (result.hasErrors() ? VN_REG_FORM : VN_REG_OK);
	}
	
	private static void convertPasswordError(BindingResult result) {
		for (ObjectError error : result.getGlobalErrors()) {
			String msg = error.getDefaultMessage();
			if ("account.password.mismatch.message".equals(msg)) {
				if (!result.hasFieldErrors("password")) {
					result.rejectValue("password", "error.mismatch");
				}
			}
		}
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}
