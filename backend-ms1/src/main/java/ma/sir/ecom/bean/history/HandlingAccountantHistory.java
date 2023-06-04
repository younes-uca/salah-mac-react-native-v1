package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "handling_accountant")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="handling_accountant_seq",sequenceName="handling_accountant_seq",allocationSize=1, initialValue = 1)
public class HandlingAccountantHistory extends HistBusinessObject  {


    public HandlingAccountantHistory() {
    super();
    }

    public HandlingAccountantHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="handling_accountant_seq")
    public Long getId() {
    return id;
    }
}

