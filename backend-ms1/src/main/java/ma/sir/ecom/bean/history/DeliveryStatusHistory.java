package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "delivery_status")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="delivery_status_seq",sequenceName="delivery_status_seq",allocationSize=1, initialValue = 1)
public class DeliveryStatusHistory extends HistBusinessObject  {


    public DeliveryStatusHistory() {
    super();
    }

    public DeliveryStatusHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="delivery_status_seq")
    public Long getId() {
    return id;
    }
}

