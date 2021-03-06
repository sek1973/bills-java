package bills.java.repository;

import bills.java.model.Bill;
import bills.java.model.Payment;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface BillsRepository extends JpaRepository<Bill, Long> {

}
