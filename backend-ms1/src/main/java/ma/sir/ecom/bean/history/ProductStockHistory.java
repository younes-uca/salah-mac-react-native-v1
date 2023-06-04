package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "product_stock")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="product_stock_seq",sequenceName="product_stock_seq",allocationSize=1, initialValue = 1)
public class ProductStockHistory extends HistBusinessObject  {


    public ProductStockHistory() {
    super();
    }

    public ProductStockHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="product_stock_seq")
    public Long getId() {
    return id;
    }
}

