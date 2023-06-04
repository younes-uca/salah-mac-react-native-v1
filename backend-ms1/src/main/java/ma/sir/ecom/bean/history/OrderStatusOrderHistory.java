package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "order_status_order")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="order_status_order_seq",sequenceName="order_status_order_seq",allocationSize=1, initialValue = 1)
public class OrderStatusOrderHistory extends HistBusinessObject  {


    public OrderStatusOrderHistory() {
    super();
    }

    public OrderStatusOrderHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="order_status_order_seq")
    public Long getId() {
    return id;
    }
}

