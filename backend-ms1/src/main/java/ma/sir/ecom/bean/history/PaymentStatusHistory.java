package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "payment_status")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="payment_status_seq",sequenceName="payment_status_seq",allocationSize=1, initialValue = 1)
public class PaymentStatusHistory extends HistBusinessObject  {


    public PaymentStatusHistory() {
    super();
    }

    public PaymentStatusHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="payment_status_seq")
    public Long getId() {
    return id;
    }
}

