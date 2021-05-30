package bills.java.repository;

import bills.java.model.Payment;
import bills.java.model.Schedule;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query("SELECT s from Schedule s where s.billId = :billId")
    List<Schedule> findByBillId(Long billId);
}
