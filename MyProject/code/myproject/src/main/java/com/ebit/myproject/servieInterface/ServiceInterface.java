package com.ebit.myproject.servieInterface;

import java.util.List;

import com.ebit.myproject.model.Student;

public interface ServiceInterface {

	List<Student> getData();

	Student addstudent(int id);


	Student updateData(int id, Student stu);

	String deleteData(int id);

	String deleteAllData();

	Student enterdata(Student stu);
	

}
