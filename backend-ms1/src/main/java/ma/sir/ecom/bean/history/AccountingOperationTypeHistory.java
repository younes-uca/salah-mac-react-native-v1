package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "accounting_operation_type")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="accounting_operation_type_seq",sequenceName="accounting_operation_type_seq",allocationSize=1, initialValue = 1)
public class AccountingOperationTypeHistory extends HistBusinessObject  {


    public AccountingOperationTypeHistory() {
    super();
    }

    public AccountingOperationTypeHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="accounting_operation_type_seq")
    public Long getId() {
    return id;
    }
}

