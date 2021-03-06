package bills.java.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Currency;
import java.util.Date;

@Entity
@Table
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private Date date;
    private Currency sum;
    private String remarks;
    @Column(insertable = false,updatable = false)
    private Long billId;
    @ManyToOne()
    @JoinColumn(name = "billId")
    private Bill bill;

    public Schedule(Long billId) { }

    public Long getId() {
        return id;
    }
    public void setId(Long val) { this.id = val; }

    public Date getDate() {
        return date;
    }
    public void setDate(Date val) { this.date = val; }

    public Currency getSum() {
        return sum;
    }
    public void setSum(Currency val) { this.sum = val; }

    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String val) { this.remarks = val; }

    public Long getBillId() {
        return billId;
    }
    public void setBillId(Long val) { this.billId = val; }

    public Bill getBill() {
        return bill;
    }
    public void setBill(Bill val) { this.bill = val; }

}
