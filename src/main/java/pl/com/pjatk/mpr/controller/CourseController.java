//package pl.com.pjatk.mpr.controller;
//
//import org.springframework.http.*;
//import org.springframework.web.bind.annotation.*;
//import pl.com.pjatk.mpr.model.*;
//import pl.com.pjatk.mpr.service.*;
//
//import java.util.*;
//
//@RestController
//@RequestMapping("/course")
//public class CourseController {
//    private CourseService courseService;
//
//    public CourseController(CourseService courseService) {
//        this.courseService = courseService;
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Course>> findAll() {
//        return ResponseEntity.ok(courseService.findAll());
//    }
//
//    @PostMapping
//    public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
//        return ResponseEntity.ok(courseService.saveCourse(course));
//    }
//
//    @GetMapping("/{courseName}")
//    public ResponseEntity<Course> findByCourseId(@PathVariable String courseName) {
//        Optional<Course> byCourseId = courseService.findByCourseName(courseName);
//        if (byCourseId.isPresent()) {
//            return ResponseEntity.ok(byCourseId.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}
