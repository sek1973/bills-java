package bills.java.service;

import bills.java.model.Payment;
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

    public List<Payment> findAll(){
        return paymentRepository.findAll();
    }

    public Optional<Payment> findById(Long id){
        return paymentRepository.findById(id);
    }

    public List<Payment> findByBillId(Long id){
        return paymentRepository.findByBillId(id);
    }

    @Transactional
    public ResponseEntity<Object> addPayment(Payment payment) {
        Payment savedPayment = paymentRepository.save(payment);
        if (paymentRepository.findById(savedPayment.getId()).isPresent()) {
            return ResponseEntity.accepted().body("Successfully created new payment");
        } else
            return ResponseEntity.unprocessableEntity().body("Failed to create specified payment");
    }

}
