package hibernate_one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            Employee employee = new Employee("Valentin","Deadka","IT", 500);
//            Detail detail = new Detail("Mogivel","+374(29)241-06-92","email.co");
//
//            employee.setEmpDetail(detail);
//
//            session.save(employee);

            Employee employee = session.get(Employee.class,1L);
            System.out.println(employee.getEmpDetail());

            session.getTransaction().commit();

        }finally {
            sessionFactory.close();
        }
    }
}
