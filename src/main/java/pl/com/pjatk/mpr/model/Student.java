package pl.com.pjatk.mpr.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentId;
    private String firstName;
    private String secondName;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @JsonIgnore
    private Course course;

    @OneToOne
    @JoinColumn(name = "grades_id", referencedColumnName = "id")
    private Grade grade;


    public Student() {
    }

    public Student(String studentId, String firstName, String secondName, Grade grade) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }






}
