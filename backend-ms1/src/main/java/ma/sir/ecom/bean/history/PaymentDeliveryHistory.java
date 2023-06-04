package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "payment_delivery")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="payment_delivery_seq",sequenceName="payment_delivery_seq",allocationSize=1, initialValue = 1)
public class PaymentDeliveryHistory extends HistBusinessObject  {


    public PaymentDeliveryHistory() {
    super();
    }

    public PaymentDeliveryHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="payment_delivery_seq")
    public Long getId() {
    return id;
    }
}

