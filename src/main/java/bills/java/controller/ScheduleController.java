package bills.java.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import bills.java.model.Bill;
import bills.java.service.BillService;

import java.util.List;
import java.util.Optional;

@RestController
public class ScheduleController {
    private BillService courseService;
    public ScheduleController(BillService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/course/create")
    public ResponseEntity<Object> createRole(@RequestBody Bill bill) {
        return  courseService.addCourse(bill);
    }

    @DeleteMapping("/course/delete/{id}")
    public ResponseEntity<Object> deleteRole(@PathVariable Long id) {
        return courseService.deleteCourse(id);
    }

    @GetMapping("/course/all")
    public ResponseEntity<List<Bill>> findAllCourses() {
        return ResponseEntity.ok(courseService.findAll());
    }

    @GetMapping("/course/{courseName}")
    public ResponseEntity<Bill> findByCourseId(@PathVariable String courseName) {
        Optional<Bill> byCourseId = courseService.findByCourseName(courseName);
        if (byCourseId.isPresent()) {
            return ResponseEntity.ok(byCourseId.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
