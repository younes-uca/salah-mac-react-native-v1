package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "return_status")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="return_status_seq",sequenceName="return_status_seq",allocationSize=1, initialValue = 1)
public class ReturnStatusHistory extends HistBusinessObject  {


    public ReturnStatusHistory() {
    super();
    }

    public ReturnStatusHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="return_status_seq")
    public Long getId() {
    return id;
    }
}

