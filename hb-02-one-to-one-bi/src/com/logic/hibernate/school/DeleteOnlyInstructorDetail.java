package com.logic.hibernate.school;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.logic.hibernate.school.entity.InstrDtlEntForDelOnlyInstrDtl;
import com.logic.hibernate.school.entity.InstrEntForDelOnlyInstrDtl;
import com.logic.hibernate.school.entity.Instructor;
import com.logic.hibernate.school.entity.InstructorDetail;
import com.logic.hibernate.school.entity.Student;

public class DeleteOnlyInstructorDetail {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(InstrEntForDelOnlyInstrDtl.class)
									.addAnnotatedClass(InstrDtlEntForDelOnlyInstrDtl.class)
									.buildSessionFactory();
		
		//cretae session
		Session session = factory.getCurrentSession();
		
		try
	
		{
			
			// start a transaction
			session.beginTransaction();
			
			// get the instructor detail object
			int theId = 3;
			InstrDtlEntForDelOnlyInstrDtl theInstructorDetail = session.get(InstrDtlEntForDelOnlyInstrDtl.class, theId);
			
			// print the instructor detail
			System.out.println("theInstructorDetail: " + theInstructorDetail);
			
			// print the associated instructor
			System.out.println("the associated instructor: " + theInstructorDetail.getInstructor());
			
			// *remove the association
			theInstructorDetail.getInstructor().setInstructorDetail(null);
			
			// now lets delete the instructor detail
			// also do cascade delete on instructor
			session.delete(theInstructorDetail);
			
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
