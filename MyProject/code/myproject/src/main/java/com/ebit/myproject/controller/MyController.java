package com.ebit.myproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebit.myproject.model.Student;
import com.ebit.myproject.servieInterface.ServiceInterface;

@RestController
public class MyController {
	
	@Autowired
	private ServiceInterface serviceInterface;
	
	@GetMapping("/student")
	public List<Student> getData(){
		return serviceInterface.getData();
	}
	
	@GetMapping("/student/{id}")
	public Student addstudent(@PathVariable int id) {
		return serviceInterface.addstudent(id);
	}
	
	@PostMapping("/student")
	public ResponseEntity<Student> enterdata(@RequestBody Student stu) {
		return ResponseEntity.ok(serviceInterface.enterdata(stu));
	}
	
	@PutMapping("/student/{id}")
	public String updatedata(@PathVariable int id, @RequestBody Student stu) {
		serviceInterface.updateData(id,stu);
		return "data updated";
	}
	
	
	@DeleteMapping("/student/{id}")
	public String deleteData(@PathVariable int id) {
		serviceInterface.deleteData(id);
		return "data deleted " + id;
	}
	
	@DeleteMapping("/student")
	public String deleteData() {
		serviceInterface.deleteAllData();
		return "data deleted";
	}
}
