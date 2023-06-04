package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "late_payment_rate")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="late_payment_rate_seq",sequenceName="late_payment_rate_seq",allocationSize=1, initialValue = 1)
public class LatePaymentRateHistory extends HistBusinessObject  {


    public LatePaymentRateHistory() {
    super();
    }

    public LatePaymentRateHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="late_payment_rate_seq")
    public Long getId() {
    return id;
    }
}

