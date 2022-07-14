package com.spring.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.entity.Student;

public class ReadStudent {

	public static void main(String[] args) {

//		create session factory 
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
//		create session
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			System.out.println("Reading a new student object");
			Student st = session.get(Student.class, 1);

			System.out.println(st.toString());
			
			session.getTransaction().commit();
			System.out.println("Done!!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
		
		

	}

}
