package bills.java.service;

import bills.java.model.Bill;
import bills.java.model.Schedule;
import bills.java.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class PaymentService {

    StudentRepository studentRepository;
    BillService billService;

    public PaymentService(StudentRepository studentRepository, BillService billService) {
        this.studentRepository = studentRepository;
        this.billService = billService;
    }

    public List<Schedule> findAll(){
        return studentRepository.findAll();
    }

    public Optional<Schedule> findById(Long id){
        return studentRepository.findById(id);
    }

    public Optional<Schedule> findByStudentId(String studentId){
        return studentRepository.findByStudentId(studentId);
    }

    @Transactional
    public ResponseEntity<Object> addStudent(Schedule schedule) {
        Schedule newSchedule = new Schedule();
        newSchedule.setStudentId(schedule.getStudentId());
        newSchedule.setFirstName(schedule.getFirstName());
        newSchedule.setSecondName(schedule.getSecondName());
        Optional<Bill> course = billService.findByCourseName(schedule.getCourseName());
        if (course.isPresent()) {
            newSchedule.setCourse(course.get());
        }
        Schedule savedSchedule = studentRepository.save(newSchedule);

        if (studentRepository.findById(savedSchedule.getId()).isPresent()) {
            return ResponseEntity.accepted().body("Successfully created student and course");
        } else
            return ResponseEntity.unprocessableEntity().body("Failed to create specified student");
    }

    public Optional<Schedule> findStudentByCourse(String courseName){
        return studentRepository.getStudentByCourseName(courseName);
    }


}
