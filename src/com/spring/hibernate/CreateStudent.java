package com.spring.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.entity.Student;

public class CreateStudent {

	public static void main(String[] args) {

//		create session factory 
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
//		create session
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating a new student object");
			Student st = new Student("Moha", "Eld", "eldeib@gmail.com");
			
			session.beginTransaction();
			
			System.out.println("Savding the Student");
			session.save(st);
			
			session.getTransaction().commit();
			System.out.println("Done!!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
		

	}

}
