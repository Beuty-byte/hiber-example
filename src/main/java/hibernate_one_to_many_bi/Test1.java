package hibernate_one_to_many_bi;


import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
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

//            Department department = new Department("IT",300,1200);
//            Employee employee = new Employee("andrey","andrey",400);
//            Employee employee2 = new Employee("lena","lena",1200);
//
//            department.addEmployeeToDepartment(employee);
//            department.addEmployeeToDepartment(employee2);
//
//            session.save(department);

            //---------------------------------------------------------------------
//            Department department = session.get(Department.class, 1L);
//
//            System.out.println(department);
//            System.out.println(department.getEmployeeList());

            Employee employee = session.get(Employee.class,1L);
            System.out.println(employee);
            System.out.println(employee.getDepartment());

            session.getTransaction().commit();

        }finally {
            sessionFactory.close();
            session.close();
        }
    }
}
