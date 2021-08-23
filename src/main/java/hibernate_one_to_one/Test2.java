package hibernate_one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            Employee employee = new Employee("misha", "maha","HR", 800);
//            Detail detail = new Detail("London", "33333","sakaka");
//
//            employee.setEmpDetail(detail);
//            detail.setEmployee(employee);
//            session.save(detail);

            //------------------------------------------
            Detail detail = session.get(Detail.class, 2L);
            detail.getEmployee().setEmpDetail(null);
            session.delete(detail);

            session.getTransaction().commit();

        }finally {
            sessionFactory.close();
        }
    }
}
