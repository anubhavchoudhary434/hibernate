package com.logic.hibernate.school;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.logic.hibernate.school.entity.Student;

public class PrimaryKey {

	public static void main(String[] args) {
		// create session factory
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
				
				//cretae session
				Session session = factory.getCurrentSession();
				
				try
			
				{
					// create 3 student objects
					Student tempStudent1 = new Student("Radhe", "Shyam", "radhe@logic.com");
					Student tempStudent2 = new Student("Sita", "Ram", "sita@logic.com");
					Student tempStudent3 = new Student("Krsna", "Kanhaiya", "krsna@logic.com");
					
					// start a transaction
					session.beginTransaction();
					
					// save the student object
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					
					// commit transaction
					session.getTransaction().commit();
				}
				finally
				{
					factory.close();
				}


	}

}
