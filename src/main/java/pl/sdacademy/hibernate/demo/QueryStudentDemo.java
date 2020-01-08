package pl.sdacademy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.sdacademy.demo.entity.Student;

import java.util.List;


public class QueryStudentDemo {

    public static void main(String[] args) {
        //tworzenie fabryki
        // dodanie konfiguracji, dodanie klasy student do śledzenia
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();
        //tworzenie sesji na potrzeby naszej pracy
        Session session = factory.getCurrentSession();

        try {

            //rozpocznij transakcję żeby zapisać
            session.beginTransaction();

            //pobierz listę studentów
            List<Student> students = session.createQuery("from Student s").getResultList();

            for(Student s : students){
                System.out.println(s);
            }
            List<Student> kowalscy = session.createQuery("from Student s where s.lastName = 'Kowalska'").getResultList();

            for(Student s : kowalscy){
                System.out.println(s);
            }




            //zakomituj transakcję
            session.getTransaction().commit();


        } finally {
            //posprzątaj po otwartej sesji
            factory.close();
        }
    }
}
