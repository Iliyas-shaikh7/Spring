package com.spring.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.dao.StudentDao;
import com.spring.entity.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
		/*
		 * Student student = new Student(2324,"Iliyas Shaikh","Indore"); int i =
		 * studentDao.insert(student);
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean flag=true;
		
		while (flag) {
			System.out.println("Press 1 for add new Student");
			System.out.println("Press 2 for display all Students");
			System.out.println("Press 3 for get details of single studet");
			System.out.println("Press 4 for delete of single student");
			System.out.println("Press 5 for update Student");
			System.out.println("Press 6 for exit");

			try {
				int input = Integer.parseInt(br.readLine());

				switch (input) {

				case 1: {
					// add student
					System.out.println("Enter student Id : ");
					int id = Integer.parseInt(br.readLine());
					System.out.println("Enter student name : ");
					String name = br.readLine();
					System.out.println("Enter student city : ");
					String city = br.readLine();
					Student student = new Student(id,name,city);
					int i = studentDao.insert(student);
					System.out.println("Data Inserted Successfully !!");
					System.out.println("**************************************");
					break;
				}
				case 2: {
					// display all student			
					List<Student> allStudent = studentDao.getAllStudents();
					System.out.println("**************************************");
					for(Student s : allStudent){	
						System.out.println("Id : "+s.getId());
						System.out.println("Name : "+s.getName());
						System.out.println("City : "+s.getCity());
						System.out.println("__________________________________");
					}
					System.out.println("**************************************");
					break;
				}
				case 3: {
					// display single student
					System.out.println("Enter Student Id : ");
					int id = Integer.parseInt(br.readLine());
					Student s = studentDao.getStudent(id);
					System.out.println("**************************************");
					System.out.println("Id : "+s.getId());
					System.out.println("Name : "+s.getName());
					System.out.println("City : "+s.getCity());
					System.out.println("**************************************");
					break;
				}
				case 4: {
					// delete student
					System.out.println("Enter Student Id : ");
					int id = Integer.parseInt(br.readLine());
					studentDao.deleteStudent(id);
					System.out.println("Data Delete Successfully !!");
					break;
				}
				case 5: {
					// update student
					System.out.println("Enter student Id : ");
					int id = Integer.parseInt(br.readLine());
					System.out.println("Enter student name : ");
					String name = br.readLine();
					System.out.println("Enter student city : ");
					String city = br.readLine();
					Student student = new Student(id,name,city);
					studentDao.updateStudent(student);
					System.out.println("Data Updated Successfully !!");
					break;
				}
				case 6:{
					//exit
					flag=false;
					System.out.println("You are successfully exit !!");
					break;
				}
				}

			} catch (Exception e) {
				System.out.println("Invalid Input try with another one !!");
				System.out.println(e.getMessage());
			}
			System.out.println("Thank you for using this application");
			System.out.println("See you soon !!");

		}
	}
}
