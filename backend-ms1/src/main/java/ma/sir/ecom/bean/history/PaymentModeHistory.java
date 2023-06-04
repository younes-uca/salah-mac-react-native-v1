package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "payment_mode")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="payment_mode_seq",sequenceName="payment_mode_seq",allocationSize=1, initialValue = 1)
public class PaymentModeHistory extends HistBusinessObject  {


    public PaymentModeHistory() {
    super();
    }

    public PaymentModeHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="payment_mode_seq")
    public Long getId() {
    return id;
    }
}

