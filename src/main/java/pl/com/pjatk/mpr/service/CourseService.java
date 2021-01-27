package pl.com.pjatk.mpr.service;

import org.springframework.stereotype.*;
import pl.com.pjatk.mpr.model.*;
import pl.com.pjatk.mpr.repository.*;

import java.util.*;
import java.util.regex.*;

@Service
public class CourseService {

    CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> findAll(){
        return courseRepository.findAll();
    }


    public Course saveCourse(Course course){
        courseRepository.save(course);
        return course;
    }

    public Optional<Course> findByCourseName(String courseName){
        return courseRepository.findCourseByCourseName(courseName);
    }

    public static Student assignCourse(Student student) {
        String pattern1 = "^group+[1].*";
        String pattern2 = "^group+[2].*";

        if (student.getStudentId().matches(pattern1)) {
            student.setCourseName("course1");
        } else if (student.getStudentId().matches(pattern2)) {
            student.setCourseName("course2");
        } else {

            student.setCourseName("000");
        }
        return student;
    }

}
