package pl.com.pjatk.mpr.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import pl.com.pjatk.mpr.model.*;

import java.util.*;
@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
//    @Query("SELECT s from  Student s where s.id = :gradeA")
//    Student getStudentGradeA(Long id);

//    @Query("SELECT s from  Student s where s.id = :gradeB")
//    Student getStudentGradeB(Long id);
}
