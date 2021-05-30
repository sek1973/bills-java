package bills.java.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Currency;
import java.util.Date;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private Currency sum;
    public String remarks;
    public Long billId;

    @ManyToOne
    @JsonIgnore
    private Bill bill;

    public Schedule() { }

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
}
