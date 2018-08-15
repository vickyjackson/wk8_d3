import db.DBCourse;
import db.DBHelper;
import models.Course;
import models.Lesson;
import models.Mentor;
import models.Student;

import java.util.List;

public class Runner {

    public static void main(String[] args){
        Course course1 = new Course("Space", 2);
        DBHelper.save(course1);

        Course course2 = new Course("Cartoons", 4);
        DBHelper.save(course2);

        Lesson lesson1 = new Lesson("Planets", 3, course1);
        DBHelper.save(lesson1);

        Lesson lesson2 = new Lesson("Aliens", 3, course1);
        DBHelper.save(lesson2);

        Lesson lesson3 = new Lesson("Spongebob Squarepants", 3, course2);
        DBHelper.save(lesson3);

        Student student1 = new Student("Pat", 30, 1, course1);
        DBHelper.save(student1);

        Student student2 = new Student("Mike", 32, 2, course1);
        DBHelper.save(student2);

        Student student3 = new Student("Vicky", 29, 3, course2);
        DBHelper.save(student3);

        Student student4 = new Student("Garry", 35, 4, course2);
        DBHelper.save(student4);

        Mentor mentor1 = new Mentor("Pawel", student1);
        DBHelper.save(mentor1);

        Mentor mentor2 = new Mentor("Colin", student2);
        DBHelper.save(mentor2);

        Mentor mentor3 = new Mentor("Alex", student3);
        DBHelper.save(mentor3);

        Mentor mentor4 = new Mentor("Emil", student4);
        DBHelper.save(mentor4);


        List<Student> studentsOnCourse = DBCourse.getAllStudentsOnCourse(course1);

        List<Lesson> lessonsOnCourse = DBCourse.getAllLessonsOnCourse(course1);
    }
}
