package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "demand_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="demand_item_seq",sequenceName="demand_item_seq",allocationSize=1, initialValue = 1)
public class DemandItemHistory extends HistBusinessObject  {


    public DemandItemHistory() {
    super();
    }

    public DemandItemHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="demand_item_seq")
    public Long getId() {
    return id;
    }
}

