package com.pe.abcdev.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pe.abcdev.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		try {	
			//create session
			Session session = factory.getCurrentSession();
			
			//create a student object
			System.out.println("Creating new student object...!!!");
			Student student = new Student("Daffy", "Duck", "daffyduck@gmail.com");
			
			//begin a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student...");
			System.out.println("theStudent: " + student);
			session.save(student);
			
			//commit transaction
			session.getTransaction().commit();
			
			//
			//My new code
			//Find out the student id: primary key
			System.out.println("Saved Student. Generated id: " + student.getId());
			
			//Create a new session
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve the student based on id: primary key
			System.out.println("Retrieve Student with id: " + student.getId());
			Student retrieveStudent = session.get(Student.class, student.getId());
			
			System.out.println("Get complete: " + retrieveStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done...!!!");
			
		} catch (Exception e) {
			factory.close();
		}

	}

}
