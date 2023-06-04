package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "vat_declaration")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="vat_declaration_seq",sequenceName="vat_declaration_seq",allocationSize=1, initialValue = 1)
public class VatDeclarationHistory extends HistBusinessObject  {


    public VatDeclarationHistory() {
    super();
    }

    public VatDeclarationHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="vat_declaration_seq")
    public Long getId() {
    return id;
    }
}

