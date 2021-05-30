package bills.java.repository;

import bills.java.model.Schedule;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;
@Repository
public interface StudentRepository extends JpaRepository<Schedule, Long> {
    Optional<Schedule> findByStudentId(String studentId);

    @Query("SELECT s from  Student s where s.id= :courseName")
    Optional<Schedule> getStudentByCourseName(String courseName);

}
