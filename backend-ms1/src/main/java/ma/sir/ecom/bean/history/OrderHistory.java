package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "order")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="order_seq",sequenceName="order_seq",allocationSize=1, initialValue = 1)
public class OrderHistory extends HistBusinessObject  {


    public OrderHistory() {
    super();
    }

    public OrderHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="order_seq")
    public Long getId() {
    return id;
    }
}

