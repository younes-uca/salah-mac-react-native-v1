package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "status_payment_demand")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="status_payment_demand_seq",sequenceName="status_payment_demand_seq",allocationSize=1, initialValue = 1)
public class StatusPaymentDemandHistory extends HistBusinessObject  {


    public StatusPaymentDemandHistory() {
    super();
    }

    public StatusPaymentDemandHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="status_payment_demand_seq")
    public Long getId() {
    return id;
    }
}

