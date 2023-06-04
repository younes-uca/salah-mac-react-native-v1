package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "order_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="order_item_seq",sequenceName="order_item_seq",allocationSize=1, initialValue = 1)
public class OrderItemHistory extends HistBusinessObject  {


    public OrderItemHistory() {
    super();
    }

    public OrderItemHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="order_item_seq")
    public Long getId() {
    return id;
    }
}

