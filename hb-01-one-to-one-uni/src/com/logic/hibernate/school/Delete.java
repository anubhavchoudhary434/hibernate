package com.logic.hibernate.school;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.logic.hibernate.school.entity.Instructor;
import com.logic.hibernate.school.entity.InstructorDetail;
import com.logic.hibernate.school.entity.Student;

public class Delete {

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
			
			// get instructor by primary key/id
			int theId = 1;
			Instructor theInstructor=session.get(Instructor.class, theId);
			
			// delete the instructors and cascade delete automatically instructor detail
			if(theInstructor!=null)
			{
				session.delete(theInstructor);
			}
			
			// commit transaction
			session.getTransaction().commit();
		}
		finally
		{
			factory.close();
		}

	}

}
