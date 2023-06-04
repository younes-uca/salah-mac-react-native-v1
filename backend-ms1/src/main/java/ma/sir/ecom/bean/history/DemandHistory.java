package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "demand")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="demand_seq",sequenceName="demand_seq",allocationSize=1, initialValue = 1)
public class DemandHistory extends HistBusinessObject  {


    public DemandHistory() {
    super();
    }

    public DemandHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="demand_seq")
    public Long getId() {
    return id;
    }
}

