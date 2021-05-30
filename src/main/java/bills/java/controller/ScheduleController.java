package bills.java.controller;

import bills.java.model.Schedule;
import bills.java.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import bills.java.model.Bill;
import bills.java.service.BillService;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ScheduledExecutorService;

@RestController
public class ScheduleController {
    private ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/schedule/create")
    public Schedule create(@RequestBody Schedule schedule) {
        return this.scheduleService.add(schedule);
    }

    @DeleteMapping("/schedule/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        if (this.scheduleService.delete(id)) {
            return ResponseEntity.ok(id);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/schedule/all")
    public List<Schedule> findAll() {
        return scheduleService.findAll();
    }

}
