package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "order_payment")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="order_payment_seq",sequenceName="order_payment_seq",allocationSize=1, initialValue = 1)
public class OrderPaymentHistory extends HistBusinessObject  {


    public OrderPaymentHistory() {
    super();
    }

    public OrderPaymentHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="order_payment_seq")
    public Long getId() {
    return id;
    }
}

