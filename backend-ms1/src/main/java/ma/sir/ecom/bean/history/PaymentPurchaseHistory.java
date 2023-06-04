package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "payment_purchase")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="payment_purchase_seq",sequenceName="payment_purchase_seq",allocationSize=1, initialValue = 1)
public class PaymentPurchaseHistory extends HistBusinessObject  {


    public PaymentPurchaseHistory() {
    super();
    }

    public PaymentPurchaseHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="payment_purchase_seq")
    public Long getId() {
    return id;
    }
}

