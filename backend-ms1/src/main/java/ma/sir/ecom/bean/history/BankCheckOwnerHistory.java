package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "bank_check_owner")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="bank_check_owner_seq",sequenceName="bank_check_owner_seq",allocationSize=1, initialValue = 1)
public class BankCheckOwnerHistory extends HistBusinessObject  {


    public BankCheckOwnerHistory() {
    super();
    }

    public BankCheckOwnerHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="bank_check_owner_seq")
    public Long getId() {
    return id;
    }
}

