package com.ebit.myproject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ebit.myproject.model.Student;
import com.ebit.myproject.repo.MyRepo;
import com.ebit.myproject.service.MyService;

@SpringBootTest
class MyprojectApplicationTests {

	@Mock
	private MyRepo repo;
	
	@InjectMocks
	private MyService service;
	
	private Student student;
	
	@BeforeEach
	public void setup() {
		student = new Student();
		student.setId(1);
		student.setName("Anshul");
		student.setAddress("Jaipur");
		
	}
	
	//post - enterdata
	@Test
	public void saveStudentTest() {
		
		when(repo.save(student)).thenReturn(student);

        Student savedStudent = service.enterdata(student);

        System.out.println(savedStudent);
               assertThat(savedStudent).isNotNull();
	}
	
	//get - getData
	@Test
	public void getStudent() {
		
		Student student1 = new Student();
		student1.setId(2);
		student1.setName("Ashu");
		student1.setAddress("Ajmer");
		
		when(repo.findAll()).thenReturn(List.of(student, student1));
		
		List<Student> studentList = service.getData();
		
		assertThat(studentList).isNotNull();
		assertThat(studentList.size()).isEqualTo(2);
		
	}
	
	//get by id - addstudent
	@Test
	public void getStudentById() {
		when(repo.findById(student.getId())).thenReturn(Optional.of(student));
		
		Student savedStudent = service.addstudent(student.getId());
		assertThat(savedStudent).isNull();
	}
	
	//put - updateData
	@Test
	public void updateStudent() {
		when(repo.findStudentById(student.getId())).thenReturn(student);
		 when(repo.save(student)).thenReturn(student);
		 
		Student updatedStudent = new Student();
	    updatedStudent.setId(student.getId());
	    updatedStudent.setName("Pareek");
	    updatedStudent.setAddress("Pune");
	    System.out.println(updatedStudent);
	    
	   
		Student updateStudent = service.updateData(student.getId(), updatedStudent);
		System.out.println(updateStudent);
		assertThat(updatedStudent).isNotNull();
		assertThat(updateStudent.getName()).isEqualTo("Pareek");
		assertThat(updateStudent.getAddress()).isEqualTo("Pune");
	}
	
	//delete - 
	@Test
	public void deleteStudent() {
		int stuID = 1;
		
		when(repo.findById(student.getId())).thenReturn(Optional.of(student));

        service.deleteData(student.getId());

        verify(repo, times(1)).deleteById(student.getId());
    }
	}
	

