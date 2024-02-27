package com.ebit.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.ebit.project.controller.model.Parent;
import com.ebit.project.controller.serviceinterface.ServiceInterface;

@RestController
public class HomeController {
	
	@Autowired
	private ServiceInterface service;
	
	//get
	@GetMapping("/parent")
	public List<Parent> getData(){
		return service.getData();
	}
	
	
	//get by id
	@GetMapping("/parent/{id}")
	public Parent getDataById(@PathVariable int id){
		return service.getDataById(id);
	}
	
	
	//post
	@PostMapping("/parent")
	public Parent addTheData(@RequestBody Parent parent) {
		return service.addData(parent);
	}
	
	
	//put
	@PutMapping("/parent/{id}")
	public String updateData(@PathVariable int id, @RequestBody Parent parent) {
		service.updateData(id,parent);
		return "data updated";
	}
	
	//delete
	@DeleteMapping("/parent")
	public String deleteData() {
		service.deletedData();
		return "data deleted";
	}
	
	//delete by id
	@DeleteMapping("/parent/{id}")
	public String deleteDataId(@PathVariable int id) {
		service.deleteDataId(id);
		return "data deleted on id: " + id;
	}

	
}
