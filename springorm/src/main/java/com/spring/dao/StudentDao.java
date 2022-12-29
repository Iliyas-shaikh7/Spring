package com.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.entity.Student;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;
	
	/*Insert data into database*/
	
	@Transactional
	public int insert(Student student){
		
		Integer i =(Integer)this.hibernateTemplate.save(student);
		return i;
	}
	
	/*get data from database*/
	public Student getStudent(int id){
		Student student = this.hibernateTemplate.get(Student.class, id);
		return student;
	}
	
	/*Get all data from Database*/
	public List<Student> getAllStudents(){
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
	}
	
	/*Delete data from Database*/
	@Transactional
	public void deleteStudent(int id){
		Student student = this.hibernateTemplate.get(Student.class, id);
		this.hibernateTemplate.delete(student);
	}
	
	/*Update data into Database*/
	@Transactional
	public void updateStudent(Student student){
		this.hibernateTemplate.update(student);
	}
	
	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
