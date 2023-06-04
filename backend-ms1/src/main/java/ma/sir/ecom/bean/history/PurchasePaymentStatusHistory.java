package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "purchase_payment_status")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="purchase_payment_status_seq",sequenceName="purchase_payment_status_seq",allocationSize=1, initialValue = 1)
public class PurchasePaymentStatusHistory extends HistBusinessObject  {


    public PurchasePaymentStatusHistory() {
    super();
    }

    public PurchasePaymentStatusHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="purchase_payment_status_seq")
    public Long getId() {
    return id;
    }
}

