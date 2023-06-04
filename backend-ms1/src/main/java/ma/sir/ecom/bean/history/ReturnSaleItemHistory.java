package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "return_sale_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="return_sale_item_seq",sequenceName="return_sale_item_seq",allocationSize=1, initialValue = 1)
public class ReturnSaleItemHistory extends HistBusinessObject  {


    public ReturnSaleItemHistory() {
    super();
    }

    public ReturnSaleItemHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="return_sale_item_seq")
    public Long getId() {
    return id;
    }
}

