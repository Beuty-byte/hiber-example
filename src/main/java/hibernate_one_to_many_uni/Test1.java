package hibernate_one_to_many_uni;

import hibernate_one_to_many_uni.entity.Department;
import hibernate_one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Department department = new Department("HR",500,1500);
            Employee employee = new Employee("oleg","andredy",400);
            Employee employee2 = new Employee("lenda","lenda",1200);

            department.addEmployeeToDepartment(employee);
            department.addEmployeeToDepartment(employee2);

            session.save(department);

            session.getTransaction().commit();

        }finally {
            sessionFactory.close();
            if (session != null) {
                session.close();
            }
        }
    }
}
