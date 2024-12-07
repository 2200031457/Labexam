package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        // Configure Hibernate
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Department.class);

        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            Transaction transaction = session.beginTransaction();

            // Insert a record
            Department dept1 = new Department();
            dept1.setName("Computer Science");
            dept1.setLocation("Building A");
            dept1.setHodName("Dr. Smith");

            session.save(dept1);

            Department dept2 = new Department();
            dept2.setName("Mechanical Engineering");
            dept2.setLocation("Building B");
            dept2.setHodName("Dr. Johnson");

            session.save(dept2);

            transaction.commit();
            System.out.println("Records inserted successfully!");

            // Delete a record using positional parameters
            transaction = session.beginTransaction();

            int departmentIdToDelete = 1; // Example ID to delete
            String hql = "DELETE FROM Department WHERE departmentId = ?1";
            int result = session.createQuery(hql)
                    .setParameter(1, departmentIdToDelete)
                    .executeUpdate();

            transaction.commit();

            if (result > 0) {
                System.out.println("Record with Department ID " + departmentIdToDelete + " deleted successfully!");
            } else {
                System.out.println("No record found with Department ID " + departmentIdToDelete);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
