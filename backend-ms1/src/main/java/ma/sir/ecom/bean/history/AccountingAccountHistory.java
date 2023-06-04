package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "accounting_account")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="accounting_account_seq",sequenceName="accounting_account_seq",allocationSize=1, initialValue = 1)
public class AccountingAccountHistory extends HistBusinessObject  {


    public AccountingAccountHistory() {
    super();
    }

    public AccountingAccountHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="accounting_account_seq")
    public Long getId() {
    return id;
    }
}

