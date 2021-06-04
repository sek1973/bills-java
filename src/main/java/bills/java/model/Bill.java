package bills.java.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private Long lp;
    private String name;
    private String description;
    private Boolean active;
    private String url;
    private String login;
    private String password;
    private Currency sum;
    private Float share;
    private Date deadline;
    private Integer repeat;
    private Integer unit;
    private Date reminder;

    @OneToMany(mappedBy = "bill")
    private List<Payment> payments = new ArrayList<Payment>();

    @OneToMany(mappedBy = "bill")
    private List<Schedule> schedules = new ArrayList<Schedule>();

    public Bill() { }

    public Long getId() {
        return id;
    }
    public void setId(Long val) {
        this.id = val;
    }

    public Long getLp() {
        return lp;
    }
    public void setLp(Long val) {
        this.lp = val;
    }

    public String getName() { return name; }
    public void setName(String val) {
        this.name = val;
    }

    public String getDescription() { return description; }
    public void setDescription(String val) {
        this.description = val;
    }

    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean val) {
        this.active = val;
    }

    public String getUrl() { return url; }
    public void setUrl(String val) {
        this.url = val;
    }

    public String getLogin() { return login; }
    public void setLogin(String val) {
        this.login = val;
    }

    public String getPassword() { return password; }
    public void setPassword(String val) { this.password = val; }

    public Currency getSum() { return sum; }
    public void setSum(Currency val) { this.sum = val; }

    public Float getShare() { return share; }
    public void setShare(Float val) { this.share = val; }

    public Date getDeadline() { return deadline; }
    public void setDeadline(Date val) { this.deadline = val; }

    public Integer getRepeat() { return repeat; }
    public void setRepeat(Integer val) { this.repeat = val; }

    public Integer getUnit() { return unit; }
    public void setUnit(Integer val) { this.unit = val; }

    public Date getReminder() { return reminder; }
    public void setReminder(Date val) { this.reminder = val; }

    public List<Payment> getPayments() { return payments;  }
    public void setPayments(List<Payment> val) { this.payments = val; }

    public List<Schedule> getSchedules() { return schedules;  }
    public void setSchedules(List<Schedule> val) { this.schedules = val; }

}
