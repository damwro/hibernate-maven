package pl.sdacademy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.sdacademy.demo.entity.Student;


public class UpdateStudentDemo {

    public static void main(String[] args) {
        //tworzenie fabryki
        // dodanie konfiguracji, dodanie klasy student do śledzenia
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();
        //tworzenie sesji na potrzeby naszej pracy
        Session session = factory.getCurrentSession();

        try {

//            session.beginTransaction();
//            int studentId = 1;
//            Student student = session.get(Student.class, studentId);
//            student.setEmail("stary@sda.pl");
//            //zakomituj transakcję
//            session.getTransaction().commit();

            Session currentSession = factory.getCurrentSession();
            currentSession.beginTransaction();
            currentSession.createQuery("update Student s set s.firstName = 'Kasia' where s.firstName ='Marta' ").executeUpdate();
            currentSession.getTransaction().commit();


        } finally {
            //posprzątaj po otwartej sesji
            factory.close();
        }
    }
}
