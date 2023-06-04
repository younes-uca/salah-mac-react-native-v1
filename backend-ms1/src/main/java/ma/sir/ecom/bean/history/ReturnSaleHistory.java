package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "return_sale")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="return_sale_seq",sequenceName="return_sale_seq",allocationSize=1, initialValue = 1)
public class ReturnSaleHistory extends HistBusinessObject  {


    public ReturnSaleHistory() {
    super();
    }

    public ReturnSaleHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="return_sale_seq")
    public Long getId() {
    return id;
    }
}

