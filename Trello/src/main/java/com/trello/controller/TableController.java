package com.trello.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.trello.model.Table;
import com.trello.service.TableService;
import com.trello.service.TableServiceImpl;

@Controller
public class TableController extends AbstractController{
	@Autowired
	private TableServiceImpl tableService;
	
	@RequestMapping(value="/viewTables")
	public ModelAndView viewTables(Model model) {
		Map<String, Object> map = 
				new HashMap();
		map.put("tables", (List<Table>)tableService.getTables());
		return new ModelAndView("tableList", map);
	}
	
	@RequestMapping(value="/addTable")
	public String addTable(Model model) {
		tableService.addTable(new Table("tablica"));
		return "redirect:/viewTables";
	}
	
	@RequestMapping(value="/editTable/{id}", method = RequestMethod.GET)
	public String addTable(@PathVariable("id") int id) {
		tableService.editTable(id, "edytowana tablica");
		return "redirect:/viewTables";
	}
	
	@RequestMapping(value="/deleteTable/{id}", method = RequestMethod.GET)
	public String deleteTable(@PathVariable("id") int id) {
		tableService.deleteTable(id);
		return "redirect:/viewTables";
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
		HttpServletResponse response) throws Exception {

		ModelAndView model = new ModelAndView("index");
		model.addObject("msg", "hello world");
		
		return model;
	}
}

