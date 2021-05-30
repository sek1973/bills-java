package bills.java.controller;

import bills.java.model.Payment;
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

    @GetMapping("/payment/details/{id}")
    public Payment getPayment(@PathVariable Long id) {
        if(paymentService.findById(id).isPresent()) {
            return paymentService.findById(id).get();
        } else {
            return null;
        }
    }

    @GetMapping("/payment/all")
    public List<Payment> getPayments() {
        return paymentService.findAll();
    }

    @GetMapping("/payment/bill/{id}")
    public List<Payment> getPaymentsForBill(@PathVariable Long id) {
        return paymentService.findByBillId(id);
    }

    @PostMapping("/payment/create")
    public ResponseEntity<Object> createStudent(@RequestBody Payment payment) {
        return  paymentService.addPayment(payment);
    }

}
