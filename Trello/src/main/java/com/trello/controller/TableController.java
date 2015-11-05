package com.trello.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.trello.model.AccountForm;
import com.trello.model.Table;
import com.trello.model.Table.TableVisibility;
import com.trello.model.TableList;
import com.trello.service.TableServiceImpl;

@Controller
public class TableController extends AbstractController{
	//===========
	
	private static final Logger log = LoggerFactory.getLogger(TableController.class);
	
	@RequestMapping(value = "/viewTables", method = RequestMethod.POST)
	public String postRegistrationForm(AccountForm form){
		log.info("Create registration: {}", form);
		return "redirect:/viewTables";
	}
	
	@RequestMapping(value = "/users", method=RequestMethod.GET)
	public ModelAndView getRegistrationForm(Model model){
		model.addAttribute("account", new AccountForm());
		
		return new ModelAndView("registrationForm");
	}
	
	//===========
	@Autowired
	private TableServiceImpl tableService;
	
	@RequestMapping(value="/viewTables")
	public ModelAndView viewTables(Model model) {
		Map<String, Object> map = new HashMap();
		map.put("tables", (List<Table>)tableService.getTables());
		return new ModelAndView("tableList", map);
	}
	
	@RequestMapping(value="/addTable/{tableName}")
	public String addTable(@PathVariable("tableName") String tableName) {
		tableService.addTable(new Table(tableName + " " + tableService.getTables().size(), TableVisibility.PRIVATE));
		return "redirect:/viewTables";
	}
	
	@RequestMapping(value="/editTable/{index}", method = RequestMethod.GET)
	public String addTable(@PathVariable("index") int index) {
		tableService.editTable(index, "edytowana tablica");
		return "redirect:/viewTables";
	}
	
	@RequestMapping(value="/deleteTable/{index}", method = RequestMethod.GET)
	public String deleteTable(@PathVariable("index") int index) {
		tableService.deleteTable(index);
		return "redirect:/viewTables";
	}
	
	 @RequestMapping(value="/tablePage/{tableIndex}/{tableName}")
     public ModelAndView tablePage(Model model, @PathVariable("tableIndex") int tableIndex, @PathVariable("tableName") String tableName) {
             Map<String, Object> map = new HashMap();
             map.put("lists", (List<TableList>)tableService.getTables().get(tableIndex).getLists());
             model.addAttribute("tableIndex", tableIndex);
             model.addAttribute("tableName", tableName);
             return new ModelAndView("tablePage", map);
     }
    
     @RequestMapping(value="/addList/{tableIndex}/{tableName}/{tableListName}", method = RequestMethod.GET)
     public String addList(@PathVariable("tableIndex") int tableIndex, @PathVariable("tableName") String tableName, @PathVariable("tableListName") String tableListName) {
             tableService.addListToTable(tableIndex, new TableList(tableListName + " " + tableService.getTables().get(tableIndex).getLists().size()));
             return "redirect:/tablePage/" + tableIndex + "/" + tableName;
     }
	
	@RequestMapping(value="/editList/{tableIndex}/{listIndex}/{newName}", method = RequestMethod.GET)
	public String editList(@PathVariable("tableIndex") int tableIndex,
							@PathVariable("listIndex") int listIndex,
							@PathVariable("newName") String newListName) {
		tableService.editList(tableIndex, listIndex, newListName);
		return "redirect:/tablePage/" + tableIndex;
	}
	
	@RequestMapping(value="/deleteList/{tableIndex}/{tableName}/{listIndex}", method = RequestMethod.GET)
	public String deleteList(@PathVariable("tableIndex") int tableIndex, @PathVariable("tableName") String tableName, @PathVariable("listIndex") int listIndex) {
		tableService.deleteList(tableIndex, listIndex);
		return "redirect:/tablePage/" + tableIndex + "/" + tableName;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
		HttpServletResponse response) throws Exception {

		ModelAndView model = new ModelAndView("index");
		model.addObject("msg", "hello world");
		
		return model;
	}
}

