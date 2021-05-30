package bills.java.repository;

import bills.java.model.Payment;
import bills.java.model.Schedule;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query("SELECT p from Payment p where p.billId= :billId")
    Optional<Schedule> getPaymentsByBillId(Long billId);
}
