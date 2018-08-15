package models;

import javax.persistence.*;

@Entity
@Table(name = "mentors")
public class Mentor {

    private int id;
    private String name;
    private Student student;

    public Mentor(String name, Student student){
        this.name = name;
        this.student = student;
    }

    public Mentor(){

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

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
