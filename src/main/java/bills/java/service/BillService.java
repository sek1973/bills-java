package bills.java.service;

import bills.java.model.Bill;
import bills.java.repository.CourseRepository;
import bills.java.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class BillService {

    CourseRepository courseRepository;
    StudentRepository studentRepository;

    public BillService(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public List<Bill> findAll(){
        return courseRepository.findAll();
    }

    public Bill save(Bill bill){
        courseRepository.save(bill);
        return bill;
    }

    @Transactional
    public ResponseEntity<Object> add(Bill bill) {
        Bill newBill = new Bill();
        newBill.setName(bill.getName());
        newBill.setSchedules(bill.getSchedules());
        Bill savedBill = courseRepository.save(newBill);

        if (courseRepository.findById(savedBill.getId()).isPresent()) {
            return ResponseEntity.accepted().body("Successfully Created Course and Students");
        } else
            return ResponseEntity.unprocessableEntity().body("Failed to Create specified Course");
    }

    public ResponseEntity<Object> delete(Long id) {
        if (courseRepository.findById(id).isPresent()) {
            courseRepository.deleteById(id);
            if (courseRepository.findById(id).isPresent()) {
                return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
            } else return ResponseEntity.ok().body("Successfully deleted specified record");
        } else
            return ResponseEntity.unprocessableEntity().body("No records found");
    }

}
