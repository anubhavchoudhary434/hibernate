package com.logic.hibernate.school;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.logic.hibernate.school.entity.Student;

public class DeleteStudent {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//cretae session
		Session session = factory.getCurrentSession();
		
		try
	
		{
			
			int studentId = 1;
			
			// find out the students id: pk
			System.out.println(studentId);
			
			// now get a new session and start tnx
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: pk
			Student thStudent = session.get(Student.class, studentId);
			
			// delete the object
			session.delete(thStudent);
			
			// commit the tnx No need to call session.update for update
			session.getTransaction().commit();
			
			// NEW CODE
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// delete from students where firstName = 'Raja'
			session.createQuery("delete from Student s where s.firstName='Raja'").executeUpdate();
			
			
			session.getTransaction().commit();
			
		}
		finally
		{
			factory.close();
		}

	}

}
