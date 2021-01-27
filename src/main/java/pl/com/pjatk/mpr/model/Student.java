package pl.com.pjatk.mpr.model;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String studentId;
    private String firstName;
    private String secondName;
    private String courseName;

    public Student() {
    }

    public Student(String studentId, String firstName, String secondName, String courseName) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.courseName = courseName;
    }

    public Student(String studentId, String firstName, String secondName) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.secondName = secondName;
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
