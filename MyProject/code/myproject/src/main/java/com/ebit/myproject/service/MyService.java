package com.ebit.myproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebit.myproject.model.Student;
import com.ebit.myproject.repo.MyRepo;
import com.ebit.myproject.servieInterface.ServiceInterface;

@Service
public class MyService implements ServiceInterface{

	@Autowired
	private MyRepo myRepo;

	@Override
	public List<Student> getData() {
		return myRepo.findAll();
	}
	

	@Override
	public Student enterdata(Student stu) {
		return myRepo.save(stu);
	}

	@Override
	public Student addstudent(int id) {
		return myRepo.findStudentById(id);
	}

	@Override
	public Student updateData(int id, Student stu) {
		Student data = myRepo.findStudentById(id);
		
				if (data != null) {
					data.setName(stu.getName());
					data.setAddress(stu.getAddress());
				}
				return myRepo.save(data);
		
	}

	@Override
	public String deleteData(int id) {
		myRepo.deleteById(id);
		return "data deleted";
		
	}

	@Override
	public String deleteAllData() {
		myRepo.deleteAll();
		return "data deleted";
		
	}
}
