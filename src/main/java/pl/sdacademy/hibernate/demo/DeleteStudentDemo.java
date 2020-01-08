package pl.sdacademy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.sdacademy.demo.entity.Student;


public class DeleteStudentDemo {

    public static void main(String[] args) {
        //tworzenie fabryki
        // dodanie konfiguracji, dodanie klasy student do śledzenia
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();
        //tworzenie sesji na potrzeby naszej pracy
        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();
            int studentId = 1;
            Student student = session.get(Student.class, studentId);
            session.delete(student);
            //zakomituj transakcję
            session.getTransaction().commit();

//            Session currentSession = factory.getCurrentSession();
//            currentSession.beginTransaction();
//            currentSession.createQuery("delete Student s where s.firstName ='Kasia' ").executeUpdate();
//            currentSession.getTransaction().commit();


        } finally {
            //posprzątaj po otwartej sesji
            factory.close();
        }
    }
}
