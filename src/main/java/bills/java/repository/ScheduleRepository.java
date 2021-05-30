package bills.java.repository;

import bills.java.model.Payment;
import bills.java.model.Schedule;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface ScheduleRepository extends JpaRepository<Payment, Long> {
    @Query("SELECT s from Schedule s where s.billId = :billId")
    Schedule getPaymentsByBillId(Long billId);
}
