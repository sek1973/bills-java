package bills.java.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Currency;
import java.util.Date;

@Entity
@Table
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date deadline;
    private Currency sum;
    private Currency share;
    private Date paidDate;
    public String remarks;
    public Long billId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "billId", insertable = false, updatable = false)
    @JsonIgnore
    private Bill bill;

    public Payment() { }

    public Long getId() {
        return id;
    }
    public void setId(Long val) { this.id = val; }

    public Date getDeadline() {
        return deadline;
    }
    public void setDeadline(Date val) { this.deadline = val; }

    public Currency getSum() {
        return sum;
    }
    public void setSum(Currency val) { this.sum = val; }

    public Currency getShare() {
        return share;
    }
    public void setShare(Currency val) { this.share = val; }

    public Date getPaidDate() {
        return paidDate;
    }
    public void setPaidDate(Date val) { this.paidDate = val; }

    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String val) { this.remarks = val; }

    public Long getBillId() {
        return billId;
    }
    public void setBillId(Long val) { this.billId = val; }

}

