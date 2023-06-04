package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "sub_accounting_class")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="sub_accounting_class_seq",sequenceName="sub_accounting_class_seq",allocationSize=1, initialValue = 1)
public class SubAccountingClassHistory extends HistBusinessObject  {


    public SubAccountingClassHistory() {
    super();
    }

    public SubAccountingClassHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="sub_accounting_class_seq")
    public Long getId() {
    return id;
    }
}

