package com.pe.abcdev.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pe.abcdev.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//create 3 student objects
			System.out.println("Creating 3 student objects...!!!");
			Student student1 = new Student("Cesar", "Varillas", "cricardo@gmail.com");
			Student student2 = new Student("Cristiano", "Ronaldo", "cronaldo@gmail.com");
			Student student3 = new Student("Lionel", "Messi", "liomessi@gmail.com");
			
			//begin a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student...");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done...!!!");
			
		} catch (Exception e) {
			factory.close();
		}

	}

}
