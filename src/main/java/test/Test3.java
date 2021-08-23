package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import test.entity.Employee;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Employee.class).buildSessionFactory();

        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            List<Employee> employees = session.createQuery("from Employee")
//                    .getResultList();
            List<Employee> employees = session.createQuery("from Employee where name = 'Serg'" +
                    " AND salary >= 1333")
                    .getResultList();

            employees.forEach(System.out::println);

            session.getTransaction().commit();

            System.out.println("DONE");
        }finally {
            sessionFactory.close();
        }
    }
}
