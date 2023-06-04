package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "supplier")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="supplier_seq",sequenceName="supplier_seq",allocationSize=1, initialValue = 1)
public class SupplierHistory extends HistBusinessObject  {


    public SupplierHistory() {
    super();
    }

    public SupplierHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="supplier_seq")
    public Long getId() {
    return id;
    }
}

