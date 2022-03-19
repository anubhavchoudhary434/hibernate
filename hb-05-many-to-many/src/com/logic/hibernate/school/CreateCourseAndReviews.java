package com.logic.hibernate.school;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.logic.hibernate.school.entity.Course;
import com.logic.hibernate.school.entity.Instructor;
import com.logic.hibernate.school.entity.InstructorDetail;
import com.logic.hibernate.school.entity.Review;
import com.logic.hibernate.school.entity.Student;

public class CreateCourseAndReviews {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)   //added for course
									.addAnnotatedClass(Review.class)   //added for Review
									.buildSessionFactory();
		
		//cretae session
		Session session = factory.getCurrentSession();
		
		try
	
		{
			
			// start a transaction
			session.beginTransaction();
			
			// create a course
			Course tempCourse = new Course("Bhakti SHastri");
			
			// add some reviews
			tempCourse.addReview(new Review("Great course"));
			tempCourse.addReview(new Review("Awesome course"));
			tempCourse.addReview(new Review("Super course"));
			
			// save the course ... and leverage the cascade all :-
			session.save(tempCourse); 
			
			// commit transaction
			session.getTransaction().commit();
		}
		finally
		{
			factory.close();
		}

	}

}
