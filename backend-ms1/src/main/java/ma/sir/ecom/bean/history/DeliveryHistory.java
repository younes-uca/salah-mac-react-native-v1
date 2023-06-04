package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "delivery")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="delivery_seq",sequenceName="delivery_seq",allocationSize=1, initialValue = 1)
public class DeliveryHistory extends HistBusinessObject  {


    public DeliveryHistory() {
    super();
    }

    public DeliveryHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="delivery_seq")
    public Long getId() {
    return id;
    }
}

