package com.logic.hibernate.school;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.logic.hibernate.school.entity.Course;
import com.logic.hibernate.school.entity.Instructor;
import com.logic.hibernate.school.entity.InstructorDetail;
import com.logic.hibernate.school.entity.Review;
import com.logic.hibernate.school.entity.Student;

public class CreateCourseAndStudents {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)   //added for course
									.addAnnotatedClass(Review.class)   //added for Review
									.addAnnotatedClass(Student.class)   //added for student
									.buildSessionFactory();
		
		//cretae session
		Session session = factory.getCurrentSession();
		
		try
	
		{
			
			// start a transaction
			session.beginTransaction();
			
			// create a course
			Course tempCourse = new Course("Java and Spring");
			
			
			// save the course
			session.save(tempCourse); 
			
			//create the students
			Student tempStudent1 = new Student("jaggu", "patil", "jaggu@patil.com");
			Student tempStudent2 = new Student("anu", "choudhary", "anu@choudhary.com");
			
			
			// add students to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			// save the students
			session.save(tempStudent1);
			session.save(tempStudent2);
			
			// commit transaction
			session.getTransaction().commit();
		}
		finally
		{
			factory.close();
		}

	}

}
