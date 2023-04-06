package com.employee.springboot.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.springboot.service.EmployeeService;
import com.employee.springboot.service.ToDoListService;
import com.employee.springboot.model.EmpStatusEnum;
import com.employee.springboot.model.Employee;
import com.employee.springboot.model.ToDoList;

@Controller
public class ToDoListController {
	
	@Autowired
	private ToDoListService TDLService;
	@Autowired
	private EmployeeService EmpService;
	
	@GetMapping("/tdl")
	public String indexPage(Model model) {
		List <ToDoList> TDL =TDLService.getAllTDL();
		ArrayList<String> names = new ArrayList<String>();
		TDL.forEach((tdl) -> names.add(TDLService.getEIC(tdl.getTid())));
		model.addAttribute("TDL", TDL);
		model.addAttribute("names", names);
		return "index_tdl";
	}
	
	@GetMapping("/createTDL")
	public String createPage(Model model) {
		List<Employee> Emp = EmpService.getAllEmp();
		for(int i = 0; i<Emp.size(); i++ ) {
			if(Emp.get(i).getStatus().equals(EmpStatusEnum.Resigned)) {
				Emp.remove(i);
			}
		}
		model.addAttribute("TDL", new ToDoList());
		model.addAttribute("Emp", Emp);
		return "create_tdl";
	}
	
	@GetMapping("/updateTDL/{tid}")
	public String updatePage(@PathVariable(value = "tid")long tid, Model model) {
		List<Employee> Emp = EmpService.getAllEmp();
		for(int i = 0; i<Emp.size(); i++ ) {
			if(Emp.get(i).getStatus().equals(EmpStatusEnum.Resigned)) {
				Emp.remove(i);
			}
		}
		model.addAttribute("TDL", TDLService.getTDL(tid));
		model.addAttribute("Emp", Emp);
		return "update_tdl";
	}
	
	@PostMapping("/saveTDL")
	public String saveAndIndex(@ModelAttribute("TDL")ToDoList TDL) {
		TDLService.saveTDL(TDL);
		return "redirect:/tdl";
	}
	
	@GetMapping("/deleteTDL/{tid}")
	public String deleteAndIndex(@PathVariable(value = "tid")long tid) {
		TDLService.deleteTDL(tid);
		return "redirect:/tdl";
	}
}
