package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import test.entity.Employee;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Employee.class).buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();

            Employee employee = new Employee("john", "conorS", "IT", 10_000);

            session.beginTransaction();

            session.save(employee);
            session.getTransaction().commit();

            System.out.println("DONE");
            System.out.println(employee);
        }finally {
            sessionFactory.close();
        }
    }
}
