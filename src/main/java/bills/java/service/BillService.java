package bills.java.service;

import bills.java.model.Bill;
import bills.java.model.Schedule;
import bills.java.repository.BillsRepository;
import bills.java.repository.PaymentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class BillService {

    BillsRepository billsRepository;
    PaymentRepository paymentRepository;

    public BillService(BillsRepository billsRepository, PaymentRepository paymentRepository) {
        this.billsRepository = billsRepository;
        this.paymentRepository = paymentRepository;
    }

    public List<Bill> findAll(){
        return billsRepository.findAll();
    }

    public Bill save(Bill bill){
        return billsRepository.save(bill);
    }

    public ResponseEntity<Object> add(Bill bill) {
        Bill newBill = new Bill();
        newBill.setName(bill.getName());
        newBill.setSchedules(bill.getSchedules());
        Bill savedBill = billsRepository.save(newBill);

        if (billsRepository.findById(savedBill.getId()).isPresent()) {
            return ResponseEntity.accepted().body("Successfully Created Course and Students");
        } else
            return ResponseEntity.unprocessableEntity().body("Failed to Create specified Course");
    }

    public Boolean delete(Long id) {
        Optional<Bill> result = billsRepository.findById(id);
        if (result.isPresent()) {
            billsRepository.delete(result.get());
            return true;
        }
        return false;
    }

    public Optional<Bill> findById(Long id) {
        return billsRepository.findById(id);
    }

}
