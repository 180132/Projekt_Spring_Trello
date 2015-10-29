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
import com.trello.model.Table.TableVisibility;
import com.trello.model.TableList;
import com.trello.service.TableServiceImpl;

@Controller
public class TableController extends AbstractController{
	@Autowired
	private TableServiceImpl tableService;
	
	@RequestMapping(value="/viewTables")
	public ModelAndView viewTables(Model model) {
		Map<String, Object> map = new HashMap();
		map.put("tables", (List<Table>)tableService.getTables());
		return new ModelAndView("tableList", map);
	}
	
	@RequestMapping(value="/addTable")
	public String addTable(Model model) {
		tableService.addTable(new Table(tableService.getTables().size(),"tablica", TableVisibility.PRIVATE));
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
	
	 @RequestMapping(value="/tablePage/{tableId}")
     public ModelAndView tablePage(Model model, @PathVariable("tableId") int tableId) {
             Map<String, Object> map =
                             new HashMap();
             map.put("lists", (List<TableList>)tableService.getTables().get(tableId).getLists());
             model.addAttribute("tableId", tableId);
             return new ModelAndView("tablePage", map);
     }
    
     @RequestMapping(value="/addList/{tableId}/{tableListName}", method = RequestMethod.GET)
     public String addList(@PathVariable("tableId") int tableId, @PathVariable("tableListName") String tableListName) {
             tableService.addListToTable(tableId, new TableList(tableListName, tableService.getTables().get(tableId).getLists().size()));
             return "redirect:/tablePage/" + tableId;
     }
	
	@RequestMapping(value="/editList/{tableId}/{listId}/{newName}", method = RequestMethod.GET)
	public String editList(@PathVariable("tableId") int tableId,
							@PathVariable("listId") int listId,
							@PathVariable("newName") String newListName) {
		tableService.editList(tableId, listId, newListName);
		return "redirect:/tablePage/" + tableId;
	}
	
	@RequestMapping(value="/deleteList/{tableId, listId}", method = RequestMethod.GET)
	public String deleteList(@PathVariable("tableId") int tableId, @PathVariable("listId") int listId) {
		tableService.deleteList(tableId, listId);
		return "redirect:/tablePage/" + tableId;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
		HttpServletResponse response) throws Exception {

		ModelAndView model = new ModelAndView("index");
		model.addObject("msg", "hello world");
		
		return model;
	}
}

