package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "check_owner")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="check_owner_seq",sequenceName="check_owner_seq",allocationSize=1, initialValue = 1)
public class CheckOwnerHistory extends HistBusinessObject  {


    public CheckOwnerHistory() {
    super();
    }

    public CheckOwnerHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="check_owner_seq")
    public Long getId() {
    return id;
    }
}

