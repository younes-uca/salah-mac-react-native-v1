package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "balance_sheet")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="balance_sheet_seq",sequenceName="balance_sheet_seq",allocationSize=1, initialValue = 1)
public class BalanceSheetHistory extends HistBusinessObject  {


    public BalanceSheetHistory() {
    super();
    }

    public BalanceSheetHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="balance_sheet_seq")
    public Long getId() {
    return id;
    }
}

