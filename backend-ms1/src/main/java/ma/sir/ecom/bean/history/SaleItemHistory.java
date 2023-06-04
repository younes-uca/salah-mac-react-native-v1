package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "sale_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="sale_item_seq",sequenceName="sale_item_seq",allocationSize=1, initialValue = 1)
public class SaleItemHistory extends HistBusinessObject  {


    public SaleItemHistory() {
    super();
    }

    public SaleItemHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="sale_item_seq")
    public Long getId() {
    return id;
    }
}

