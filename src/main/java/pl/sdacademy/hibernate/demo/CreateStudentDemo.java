package pl.sdacademy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.sdacademy.demo.entity.Student;


public class CreateStudentDemo {

    public static void main(String[] args) {
        //tworzenie fabryki
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();
        //tworzenie sesji
        Session session = factory.getCurrentSession();

        try {
            //stwórz obiekt student i zapisz
            System.out.println("Tworzę obiekt student");
            Student student = new Student("Adam", "Testowy", "adam.testowy@sdacademy.pl");

            session.beginTransaction();

            System.out.println("Zapisywanie studenta");
            session.save(student);

            session.getTransaction().commit();

            System.out.println("Zapisano studenta" + student.toString());

        } finally {
            factory.close();
        }
    }
}
