package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "shop")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="shop_seq",sequenceName="shop_seq",allocationSize=1, initialValue = 1)
public class ShopHistory extends HistBusinessObject  {


    public ShopHistory() {
    super();
    }

    public ShopHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="shop_seq")
    public Long getId() {
    return id;
    }
}

