package com.logic.hibernate.school;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.logic.hibernate.school.entity.Instructor;
import com.logic.hibernate.school.entity.InstructorDetail;
import com.logic.hibernate.school.entity.Student;

public class GetInstructorDetail {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		//cretae session
		Session session = factory.getCurrentSession();
		
		try
	
		{
			
			// start a transaction
			session.beginTransaction();
			
			// get the instructor detail object
			int theId = 2;
			InstructorDetail theInstructorDetail = session.get(InstructorDetail.class, theId);
			
			// print the instructor detail
			System.out.println("theInstructorDetail: " + theInstructorDetail);
			
			// print the associated instructor
			System.out.println("the associated instructor: " + theInstructorDetail.getInstructor());
			
			// commit transaction
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			// handle connection leak issue
			session.close();
			factory.close();
		}

	}

}
