package bills.java.service;

import bills.java.model.Bill;
import bills.java.model.Schedule;
import bills.java.repository.PaymentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class PaymentService {

    PaymentRepository paymentRepository;
    BillService billService;

    public PaymentService(PaymentRepository paymentRepository, BillService billService) {
        this.paymentRepository = paymentRepository;
        this.billService = billService;
    }

    public List<Schedule> findAll(){
        return paymentRepository.findAll();
    }

    public Optional<Schedule> findById(Long id){
        return paymentRepository.findById(id);
    }

    public Optional<Schedule> findByStudentId(String studentId){
        return paymentRepository.findByStudentId(studentId);
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
        Schedule savedSchedule = paymentRepository.save(newSchedule);

        if (paymentRepository.findById(savedSchedule.getId()).isPresent()) {
            return ResponseEntity.accepted().body("Successfully created student and course");
        } else
            return ResponseEntity.unprocessableEntity().body("Failed to create specified student");
    }

    public Optional<Schedule> findStudentByCourse(String courseName){
        return paymentRepository.getStudentByCourseName(courseName);
    }


}
