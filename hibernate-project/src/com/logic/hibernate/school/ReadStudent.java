package com.logic.hibernate.school;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.logic.hibernate.school.entity.Student;

public class ReadStudent {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//cretae session
		Session session = factory.getCurrentSession();
		
		try
	
		{
			// create a student object
			Student tempStudent = new Student("Radha", "RadhikaRaman", "radhikaraman@logic.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			// MY NEW CODE FOR RETRIEVE
			
			// find out the students id: pk
			System.out.println(tempStudent.getId());
			
			// now get a new session and start tnx
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: pk
			Student thStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println(thStudent);
			// commit the tnx
			session.getTransaction().commit();
		}
		finally
		{
			factory.close();
		}

	}

}
