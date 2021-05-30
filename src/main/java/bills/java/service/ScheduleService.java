package bills.java.service;

import bills.java.model.Payment;
import bills.java.model.Schedule;
import bills.java.repository.PaymentRepository;
import bills.java.repository.ScheduleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    ScheduleRepository scheduleRepository;
    BillService billService;

    public ScheduleService(ScheduleRepository scheduleRepository, BillService billService) {
        this.scheduleRepository = scheduleRepository;
        this.billService = billService;
    }

    public List<Schedule> findAll(){
        return scheduleRepository.findAll();
    }

    public Optional<Schedule> findById(Long id){
        return scheduleRepository.findById(id);
    }

    public List<Schedule> findByBillId(Long id){
        return scheduleRepository.findByBillId(id);
    }

    public Boolean delete (Long id) {
        Optional<Schedule> result = scheduleRepository.findById(id);
        if (result.isPresent()) {
            scheduleRepository.delete(result.get());
            return true;
        }
        return false;
    }

    public Schedule add (Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Transactional
    public ResponseEntity<Object> addSchedule(Schedule schedule) {
        Schedule savedSchedule = scheduleRepository.save(schedule);
        if (scheduleRepository.findById(savedSchedule.getId()).isPresent()) {
            return ResponseEntity.accepted().body("Successfully created new schedule");
        } else
            return ResponseEntity.unprocessableEntity().body("Failed to create specified schedule");
    }
}
