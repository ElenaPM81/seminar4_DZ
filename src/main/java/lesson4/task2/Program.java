package lesson4.task2;

import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.SessionFactory;
import org.hibernate.cfg.Configuration;
import lesson4.models.Course;



public class Program {
    public static void main(String[] args) {
// Создание фабрики сессий
        SessionFactory sessionFactory = (SessionFactory) new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();


        // Создание сессии
        try (Session session = sessionFactory.getCurrentSession()){


            // Начало транзакции
            session.beginTransaction();

            // Создание объекта
            Course student = Course.create();

            // Сохранение объекта в базе данных
            session.save(course);
            System.out.println("Object student save successfully");


            // Чтение объекта из базы данных
            Course retrievedCourse = session.get(Course.class, course.getId());
            System.out.println("Object course retrieved successfully");
            System.out.println("Retrieved course object: " + retrievedCourse);

            // Обновление объекта
            retrievedCourse.updateTitle();
            retrievedCourse.updateDuration();
            session.update(retrievedCourse);
            System.out.println("Object course update successfully");


            Course retrievedCourse2 = session.get(Course.class, 23);
            // Удаление объекта
            session.delete(retrievedCourse2);
            System.out.println("Object course delete successfully");

            // Коммит транзакции
            session.getTransaction().commit();
            System.out.println("Transaction commit successfully");
        }
    }
