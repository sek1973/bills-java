package bills.java.repository;

import bills.java.model.Payment;
import bills.java.model.Schedule;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query(value = "select p from payment p where p.billId = :billId", nativeQuery = true)
    List<Payment> findByBillId(Long billId);
}
