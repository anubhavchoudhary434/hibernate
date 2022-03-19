package com.logic.hibernate.school;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.logic.hibernate.school.entity.Student;

public class QueryStudent {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//cretae session
		Session session = factory.getCurrentSession();
		
		try
	
		{
			// start a transaction
			session.beginTransaction();
			
			// query students
			//List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// query students: lastname='Choudhary'
			//List<Student> theStudents = session.createQuery("from Student s where s.lastName='Choudhary'").getResultList();
			
			// query students: lastname='Choudhary' OR firstName='Radhe'
			//List<Student> theStudents = session.createQuery("from Student s where s.lastName='Choudhary' OR s.firstName='Radhe'").getResultList();
			
			// query students: email LIKE '%logic.com'
			List<Student> theStudents = session.createQuery("from Student s where s.email LIKE '%logic.com'").getResultList();
			
			// display the students
			displayStudents(theStudents);
						
			// commit transaction
			session.getTransaction().commit();
		}
		finally
		{
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student student:theStudents)
		{
			System.out.println(student);
		}
	}

}
