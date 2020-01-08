package pl.sdacademy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.sdacademy.demo.entity.Student;


public class CreateStudentDemo {

    public static void main(String[] args) {
        //tworzenie fabryki
        // dodanie konfiguracji, dodanie klasy student do śledzenia
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();
        //tworzenie sesji na potrzeby naszej pracy
        Session session = factory.getCurrentSession();

        try {
            //stwórz obiekt student i zapisz
            System.out.println("Tworzę obiekt student");
            Student student = new Student("Adam", "Testowy", "adam.testowy@sdacademy.pl");

            //rozpocznij transakcję żeby zapisać
            session.beginTransaction();

            //zapisz studenta
            System.out.println("Zapisywanie studenta");
            session.save(student);

            //zakomituj transakcję
            session.getTransaction().commit();

            System.out.println("Zapisano studenta" + student.toString());

        } finally {
            //posprzątaj po otwartej sesji
            factory.close();
        }
    }
}
