package bills.java.controller;

import bills.java.model.Schedule;
import bills.java.service.PaymentService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/student/details/{id}")
    public Schedule getStudent(@PathVariable Long id) {
        if(paymentService.findById(id).isPresent()) {
            return paymentService.findById(id).get();
        } else {
            return null;
        }
    }

    @GetMapping("/student/all")
    public List<Schedule> getStudents() {
        return paymentService.findAll();
    }

    @PostMapping("/student/create")
    public ResponseEntity<Object> createStudent(@RequestBody Schedule schedule) {
        return  paymentService.addStudent(schedule);
    }

}
