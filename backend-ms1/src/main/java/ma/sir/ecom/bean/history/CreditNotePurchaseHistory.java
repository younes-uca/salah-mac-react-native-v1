package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "credit_note_purchase")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="credit_note_purchase_seq",sequenceName="credit_note_purchase_seq",allocationSize=1, initialValue = 1)
public class CreditNotePurchaseHistory extends HistBusinessObject  {


    public CreditNotePurchaseHistory() {
    super();
    }

    public CreditNotePurchaseHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="credit_note_purchase_seq")
    public Long getId() {
    return id;
    }
}

