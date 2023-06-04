package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "accounting_class")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="accounting_class_seq",sequenceName="accounting_class_seq",allocationSize=1, initialValue = 1)
public class AccountingClassHistory extends HistBusinessObject  {


    public AccountingClassHistory() {
    super();
    }

    public AccountingClassHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="accounting_class_seq")
    public Long getId() {
    return id;
    }
}

