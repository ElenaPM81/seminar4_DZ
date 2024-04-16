package lesson4.models;

import javax.persistence.*;
import java.util.Random;
@Entity
@Table(name = "courses")
public class Course {
    private static final Random random = new Random();
    private static final  String[] titles = new String[]{"Разработчик", "Тестировщик", "Аналитик", "Графический дизайнер", "Менеджер", "Маркетолог"};
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int duration;


    public Course() {
    }


    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Course( String title, int duration) {
        this.title = title;
        this.duration = duration;
    }
        public Course(int id, String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public void updateDuration(){
        duration = random.nextInt(20, 26);
    }

    public void updateTitle(){
        title = titles[random.nextInt(titles.length)];
    }




    public static Course create() {
        return  new Course( titles[random.nextInt(titles.length)], random.nextInt(12, 24));
    }

    @Override
    public String toString() {
        return "Course{" +
                " id = " + id +
                ", title = '" + title + '\'' +
                ", duration = " + duration + " мес." +
                '}';
    }
}
