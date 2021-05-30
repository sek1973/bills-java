package bills.java.controller;

import bills.java.model.Bill;
import bills.java.service.BillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class BillController {
    private BillService billService;
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping("/bill/create")
    public ResponseEntity<Object> createRole(@RequestBody Bill bill) {
        return billService.add(bill);
    }

    @DeleteMapping("/bill/delete/{id}")
    public ResponseEntity<Object> deleteRole(@PathVariable Long id) {
        return billService.delete(id);
    }

    @GetMapping("/bill/all")
    public ResponseEntity<List<Bill>> findAll() {
        return ResponseEntity.ok(billService.findAll());
    }

    @GetMapping("/bill/{id}")
    public ResponseEntity<Bill> findByBillId(@PathVariable Long id) {
        Optional<Bill> byCourseId = billService.findById(id);
        if (byCourseId.isPresent()) {
            return ResponseEntity.ok(byCourseId.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
