package bills.java.repository;

import bills.java.model.Bill;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface CourseRepository extends JpaRepository<Bill, Long> {
    @Query("SELECT c from Course c where c.courseName= :courseName")
    Optional<Bill> findCourseByCourseName(String courseName);
}
