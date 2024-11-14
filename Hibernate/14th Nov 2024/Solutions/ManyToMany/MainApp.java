package com.coforge.handson.manytomany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp {

    public static void main(String[] args) {
        // Setup Hibernate session
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        // Create courses
        Course course1 = new Course("Mathematics");
        Course course2 = new Course("Physics");
        Course course3 = new Course("Chemistry");

        // Create students
        Student student1 = new Student("Lakshmi");
        Student student2 = new Student("Nitin");
        Student student3 = new Student("Supriya");

        // Enroll students in courses
        student1.addCourse(course1);
        student1.addCourse(course2);
        student2.addCourse(course2);
        student2.addCourse(course3);
        student3.addCourse(course1);
        student3.addCourse(course3);

        // Save entities
        session.persist(student1);
        session.persist(student2);
        session.persist(student3);

        // Commit transaction
        tx.commit();

        // Retrieve and display data
        displayStudentCourses(session);
        displayCourseStudents(session);

        // Cleanup
        session.close();
        sessionFactory.close();
    }

    // Display all courses for each student
    private static void displayStudentCourses(Session session) {
        System.out.println("\nCourses for each student:");
        for (Student student : session.createQuery("FROM Student", Student.class).list()) {
            System.out.println(student.getName() + " is enrolled in:");
            for (Course course : student.getCourses()) {
                System.out.println(" - " + course.getTitle());
            }
        }
    }

    // Display all students for each course
    private static void displayCourseStudents(Session session) {
        System.out.println("\nStudents registered for each course:");
        for (Course course : session.createQuery("FROM Course", Course.class).list()) {
            System.out.println(course.getTitle() + " has students:");
            for (Student student : course.getStudents()) {
                System.out.println(" - " + student.getName());
            }
        }
    }
}
