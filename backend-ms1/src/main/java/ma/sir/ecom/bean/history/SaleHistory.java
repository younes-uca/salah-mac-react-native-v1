package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "sale")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="sale_seq",sequenceName="sale_seq",allocationSize=1, initialValue = 1)
public class SaleHistory extends HistBusinessObject  {


    public SaleHistory() {
    super();
    }

    public SaleHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="sale_seq")
    public Long getId() {
    return id;
    }
}

