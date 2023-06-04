package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "product_category")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="product_category_seq",sequenceName="product_category_seq",allocationSize=1, initialValue = 1)
public class ProductCategoryHistory extends HistBusinessObject  {


    public ProductCategoryHistory() {
    super();
    }

    public ProductCategoryHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="product_category_seq")
    public Long getId() {
    return id;
    }
}

