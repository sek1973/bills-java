package bills.java.controller;

import bills.java.model.Payment;
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

    @PostMapping("/payment/create")
    public Payment create(@RequestBody Payment payment) {
        return paymentService.add(payment);
    }

    @DeleteMapping("/schedule/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        if (paymentService.delete(id)) {
            return ResponseEntity.ok(id);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/payment/all")
    public List<Payment> getAll() {
        return paymentService.findAll();
    }

    @GetMapping("/payment/bill/{id}")
    public List<Payment> getAllForBill(@PathVariable Long id) {
        return paymentService.findByBillId(id);
    }

}
