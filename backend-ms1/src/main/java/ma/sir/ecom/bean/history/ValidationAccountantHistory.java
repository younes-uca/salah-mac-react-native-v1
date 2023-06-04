package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "validation_accountant")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="validation_accountant_seq",sequenceName="validation_accountant_seq",allocationSize=1, initialValue = 1)
public class ValidationAccountantHistory extends HistBusinessObject  {


    public ValidationAccountantHistory() {
    super();
    }

    public ValidationAccountantHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="validation_accountant_seq")
    public Long getId() {
    return id;
    }
}

