package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import test.entity.Employee;

public class Test5 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Employee.class).buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();


//            Employee employee = session.get(Employee.class,3L);
//            session.delete(employee);

            session.createQuery("delete Employee where name = 'serg'").executeUpdate();


            session.getTransaction().commit();

            System.out.println("DONE");
        }finally {
            sessionFactory.close();
        }
    }
}
