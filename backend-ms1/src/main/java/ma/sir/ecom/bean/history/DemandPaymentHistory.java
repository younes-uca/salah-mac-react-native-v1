package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "demand_payment")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="demand_payment_seq",sequenceName="demand_payment_seq",allocationSize=1, initialValue = 1)
public class DemandPaymentHistory extends HistBusinessObject  {


    public DemandPaymentHistory() {
    super();
    }

    public DemandPaymentHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="demand_payment_seq")
    public Long getId() {
    return id;
    }
}

