package bills.java.repository;

import bills.java.model.Bill;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface BillsRepository extends JpaRepository<Bill, Long> {
    @Query("SELECT b from Bills b where b.id= :id")
    Optional<Bill> findBillById(Long id);
}
