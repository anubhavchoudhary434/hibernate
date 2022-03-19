package com.logic.hibernate.school;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.logic.hibernate.school.entity.Course;
import com.logic.hibernate.school.entity.Instructor;
import com.logic.hibernate.school.entity.InstructorDetail;
import com.logic.hibernate.school.entity.Student;

public class CreateInstructor {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)   //added for course
									.buildSessionFactory();
		
		//cretae session
		Session session = factory.getCurrentSession();
		
		try
	
		{
			// create the objects
			Instructor theInstructor = new Instructor("Krsna", "Kanha", "krsna@kanha.com");
			
			// associate the objects
			theInstructor.setInstructorDetail(new InstructorDetail("KrsnaKatha", "Shravanam"));
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			//
			// Note: this will also save the detail object
			// because of CascadeType.ALL
			session.save(theInstructor);
			
			// commit transaction
			session.getTransaction().commit();
		}
		finally
		{
			factory.close();
		}

	}

}
