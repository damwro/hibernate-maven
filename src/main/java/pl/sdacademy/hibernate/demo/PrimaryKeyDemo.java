package pl.sdacademy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.sdacademy.demo.entity.Student;

public class PrimaryKeyDemo {

    public static void main(String[] args) {
        //tworzenie fabryki
        // dodanie konfiguracji, dodanie klasy student do śledzenia
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();
        //tworzenie sesji na potrzeby naszej pracy
        Session session = factory.getCurrentSession();

        try {
            //stwórz obiekt student i zapisz
            System.out.println("Tworzę 2 studentów");
            Student student1 = new Student("Jerzy", "Żmudziński", "jan.brzechwa@sdacademy.pl");
            Student student2 = new Student("Teresa", "Maj", "anna.kowalska@sdacademy.pl");

            //rozpocznij transakcję żeby zapisać
            session.beginTransaction();

            //zapisz studenta
            System.out.println("Zapisywanie studentów");
            session.save(student1);
            session.save(student2);

            //zakomituj transakcję
            session.getTransaction().commit();

        } finally {
            //posprzątaj po otwartej sesji
            factory.close();
        }
    }

}
