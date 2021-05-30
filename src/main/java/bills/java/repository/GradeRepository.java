package bills.java.repository;

import bills.java.model.Payment;
import bills.java.model.Schedule;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface GradeRepository extends JpaRepository<Payment, Long> {
    @Query("SELECT s from  Student s where s.id = :gradeA")
    Schedule getStudentGradeA(Double gradeA);

    @Query("SELECT s from  Student s where s.id = :gradeB")
    Schedule getStudentGradeB(Double gradeB);
}
