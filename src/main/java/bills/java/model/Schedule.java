package bills.java.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentId;
    private String firstName;
    private String secondName;

    @ManyToOne
    @JsonIgnore
    private Bill bill;

    @OneToOne
    @JoinColumn(name = "grades_id", referencedColumnName = "id")
    private Payment payment;

    public Schedule() {
    }

    public Schedule(String studentId, String firstName, String secondName, Payment payment) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.payment = payment;
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

    public Bill getCourse() {
        return this.bill;
    }

    public void setCourse(Bill bill) {
        this.bill = bill;
    }

    @Transient
    private String courseName;
    public String getCourseName() {
        return this.courseName == null ? getCourse().getCourseName() : this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

}
