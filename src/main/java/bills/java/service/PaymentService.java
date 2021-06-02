package bills.java.service;

import bills.java.model.Payment;
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

    public List<Payment> findAll(){
        return paymentRepository.findAll();
    }

    public Optional<Payment> findById(Long id){
        return paymentRepository.findById(id);
    }

    public List<Payment> findByBillId(Long id){
        return paymentRepository.findByBillId(id);
    }

    public Boolean delete (Long id) {
        Optional<Payment> result = paymentRepository.findById(id);
        if (result.isPresent()) {
            paymentRepository.delete(result.get());
            return true;
        }
        return false;
    }

    public Payment add(Payment payment) { return paymentRepository.save(payment); }

}
