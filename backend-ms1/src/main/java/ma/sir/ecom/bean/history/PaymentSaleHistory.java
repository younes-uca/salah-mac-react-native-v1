package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "payment_sale")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="payment_sale_seq",sequenceName="payment_sale_seq",allocationSize=1, initialValue = 1)
public class PaymentSaleHistory extends HistBusinessObject  {


    public PaymentSaleHistory() {
    super();
    }

    public PaymentSaleHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="payment_sale_seq")
    public Long getId() {
    return id;
    }
}

