package models;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="lessons")
public class Lesson {

    private int id;
    private String title;
    private int classroomNumber;
    private Course course;
    private Instructor instructor;
    private List<Student> students;


    public Lesson(){
    }

    public Lesson(String title, int classroomNumber, Course course, Instructor instructor){
        this.title = title;
        this.classroomNumber = classroomNumber;
        this.course = course;
        this.instructor = instructor;
        this.students = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name="classroom_number")
    public int getClassroomNumber() {
        return classroomNumber;
    }

    public void setClassroomNumber(int classroomNumber) {
        this.classroomNumber = classroomNumber;
    }

    @ManyToOne
    @JoinColumn(name="course_id", nullable=false)
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    // give jt a name
    @JoinTable(
            name = "lessons_students",
            joinColumns = {
                    @JoinColumn(name="lesson_id", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "student_id", nullable = false, updatable = false)
            })
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudentToLesson(Student student){
        this.students.add(student);
    }

    @ManyToOne
    @JoinColumn(name="instructor_id", nullable=false)
    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
