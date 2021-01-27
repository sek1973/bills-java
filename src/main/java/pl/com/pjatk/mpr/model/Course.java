package pl.com.pjatk.mpr.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    @JoinColumn(name ="student_id")
    @ManyToOne
    @JsonIgnore
    private Student student;
    public Course() {
    }
    public Course(String courseName) {
        this.courseName = courseName;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
