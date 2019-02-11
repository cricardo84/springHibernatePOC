package com.pe.abcdev.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pe.abcdev.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//create a student object
			System.out.println("Creating new student object...!!!");
			Student student = new Student("Cesar", "Varillas", "cricardo@gmail.com");
			
			//begin a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student...");
			session.save(student);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done...!!!");
			
		} catch (Exception e) {
			factory.close();
		}

	}

}
