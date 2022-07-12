package com.logic.hibernate.school;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.logic.hibernate.school.entity.Course;
import com.logic.hibernate.school.entity.Instructor;
import com.logic.hibernate.school.entity.InstructorDetail;
import com.logic.hibernate.school.entity.Review;
import com.logic.hibernate.school.entity.Student;

public class GetCourseOrStudent {

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
					
					int courseId=11;
					
					Course theCourse = session.get(Course.class, courseId);
					List<Student> theStudents = theCourse.getStudents();
					System.out.println("The result is::::" + theStudents);
										
					// commit transaction
					session.getTransaction().commit();
				}
				finally
				{
					factory.close();
				}

			}

	}

