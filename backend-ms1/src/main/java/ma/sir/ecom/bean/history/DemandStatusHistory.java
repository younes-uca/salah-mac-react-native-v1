package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "demand_status")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="demand_status_seq",sequenceName="demand_status_seq",allocationSize=1, initialValue = 1)
public class DemandStatusHistory extends HistBusinessObject  {


    public DemandStatusHistory() {
    super();
    }

    public DemandStatusHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="demand_status_seq")
    public Long getId() {
    return id;
    }
}

