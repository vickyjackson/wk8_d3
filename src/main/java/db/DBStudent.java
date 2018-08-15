package db;

import models.Lesson;
import models.Student;

public class DBStudent {

    public static void addStudentToLesson(Student student, Lesson lesson){
        student.addLessonToStudent(lesson);
        lesson.addStudentToLesson(student);
        DBHelper.update(student);
        DBHelper.update(lesson);
    }
}
