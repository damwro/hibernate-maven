package pl.sdacademy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.sdacademy.demo.entity.Student;

public class ReadStudentDemo {

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
            Student student = new Student("Karol", "Krawczyk", "karol.krawczyk@sdacademy.pl");
            //rozpocznij transakcję żeby zapisać
            session.beginTransaction();
            //zapisz studenta
            System.out.println("Zapisywanie studenta");
            session.save(student);
            //zakomituj transakcję
            session.getTransaction().commit();
            System.out.println("Zapisano studenta: " + student.toString());

            //Pobieranie studenta z bazy danych

            System.out.println("Id studenta: " + student.getId());

            Session currentSession = factory.getCurrentSession();
            currentSession.beginTransaction();
            currentSession.get(Student.class, student.getId());

            System.out.println("Pobrałeś studenta: " + student.toString());



        } finally {
            //posprzątaj po otwartej sesji
            factory.close();
        }
    }

}
