package bills.java.service;

import bills.java.model.Bill;
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
        billsRepository.save(bill);
        return bill;
    }

    @Transactional
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

    public ResponseEntity<Object> delete(Long id) {
        if (billsRepository.findById(id).isPresent()) {
            billsRepository.deleteById(id);
            if (billsRepository.findById(id).isPresent()) {
                return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
            } else return ResponseEntity.ok().body("Successfully deleted specified record");
        } else
            return ResponseEntity.unprocessableEntity().body("No records found");
    }

    public Optional<Bill> findById(Long id) {
        return billsRepository.findById(id);
    }

}
