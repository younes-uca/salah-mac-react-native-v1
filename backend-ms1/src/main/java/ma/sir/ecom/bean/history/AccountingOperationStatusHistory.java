package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "accounting_operation_status")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="accounting_operation_status_seq",sequenceName="accounting_operation_status_seq",allocationSize=1, initialValue = 1)
public class AccountingOperationStatusHistory extends HistBusinessObject  {


    public AccountingOperationStatusHistory() {
    super();
    }

    public AccountingOperationStatusHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="accounting_operation_status_seq")
    public Long getId() {
    return id;
    }
}

