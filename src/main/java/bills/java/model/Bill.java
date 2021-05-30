package bills.java.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;

    @OneToMany(targetEntity = Schedule.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Schedule> schedules;

    public Bill() {
    }

    public Bill(String courseName) {
        this.courseName = courseName;
    }

    public Bill(String courseName, List<Schedule> schedules) {
        this.courseName = courseName;
        this.schedules = schedules;
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

    public List<Schedule> getStudents() {
        return schedules;
    }

    public void setStudents(List<Schedule> schedules) {
        this.schedules = schedules;
    }
}
