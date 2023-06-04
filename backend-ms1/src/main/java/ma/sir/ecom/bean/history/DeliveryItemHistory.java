package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "delivery_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="delivery_item_seq",sequenceName="delivery_item_seq",allocationSize=1, initialValue = 1)
public class DeliveryItemHistory extends HistBusinessObject  {


    public DeliveryItemHistory() {
    super();
    }

    public DeliveryItemHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="delivery_item_seq")
    public Long getId() {
    return id;
    }
}

