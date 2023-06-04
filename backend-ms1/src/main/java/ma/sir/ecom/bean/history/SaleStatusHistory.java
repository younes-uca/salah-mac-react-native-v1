package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "sale_status")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="sale_status_seq",sequenceName="sale_status_seq",allocationSize=1, initialValue = 1)
public class SaleStatusHistory extends HistBusinessObject  {


    public SaleStatusHistory() {
    super();
    }

    public SaleStatusHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="sale_status_seq")
    public Long getId() {
    return id;
    }
}

