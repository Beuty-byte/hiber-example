package hibernate_many_to_many;

import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure()
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();


            Section section1 = new Section("Dance");
            Child child1 = new Child("Vasia",15);
            Child child2 = new Child("Petya",5);
            Child child3 = new Child("Jenya",35);
            Child child4 = new Child("Katiya",115);


            section1.addChild(child1);
            section1.addChild(child2);
            section1.addChild(child3);
            section1.addChild(child4);

            session.save(section1);



            session.getTransaction().commit();
        }finally {
            factory.close();
            if(session != null){
                session.close();
            }
        }
    }
}
