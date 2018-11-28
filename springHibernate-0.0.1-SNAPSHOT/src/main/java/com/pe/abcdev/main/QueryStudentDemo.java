package com.pe.abcdev.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pe.abcdev.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//begin a transaction
			session.beginTransaction();
			
			//query students
			List<Student> theStudents = session.createQuery("from Student").list();
			System.out.println("[*****ALL the Students*****]");
			displayStudents(theStudents);
			System.out.println();
			
			//query students: where lastName_='Doe'
			theStudents = session.createQuery("from Student S where S.lastName='Messi'").list();

			System.out.println("[*****Students who lastName=Messi*****]");
			displayStudents(theStudents);
			System.out.println();
			
			//QUERY students who lastName=Messi OR firstName=Daffy
			theStudents = session.createQuery("from Student S where S.lastName='Messi' or S.firstName='Daffy'").list();

			System.out.println("[*****Students who lastName=Messi OR firstName=Daffy*****]");
			displayStudents(theStudents);
			System.out.println();
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done...!!!");
			
			
		} catch (Exception e) {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		//display the students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
