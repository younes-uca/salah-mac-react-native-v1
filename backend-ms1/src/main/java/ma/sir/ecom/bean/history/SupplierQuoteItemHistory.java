package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "supplier_quote_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="supplier_quote_item_seq",sequenceName="supplier_quote_item_seq",allocationSize=1, initialValue = 1)
public class SupplierQuoteItemHistory extends HistBusinessObject  {


    public SupplierQuoteItemHistory() {
    super();
    }

    public SupplierQuoteItemHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="supplier_quote_item_seq")
    public Long getId() {
    return id;
    }
}

