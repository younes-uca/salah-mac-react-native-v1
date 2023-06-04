package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "payment_method")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="payment_method_seq",sequenceName="payment_method_seq",allocationSize=1, initialValue = 1)
public class PaymentMethodHistory extends HistBusinessObject  {


    public PaymentMethodHistory() {
    super();
    }

    public PaymentMethodHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="payment_method_seq")
    public Long getId() {
    return id;
    }
}

