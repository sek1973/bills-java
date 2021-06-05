package bills.java.repository;

import bills.java.model.Payment;
import bills.java.model.Schedule;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query(value = "select s from schedule s where s.billId = :billId", nativeQuery = true)
    List<Schedule> findByBillId(Long billId);
}
