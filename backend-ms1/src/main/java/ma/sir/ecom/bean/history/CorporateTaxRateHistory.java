package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "corporate_tax_rate")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="corporate_tax_rate_seq",sequenceName="corporate_tax_rate_seq",allocationSize=1, initialValue = 1)
public class CorporateTaxRateHistory extends HistBusinessObject  {


    public CorporateTaxRateHistory() {
    super();
    }

    public CorporateTaxRateHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="corporate_tax_rate_seq")
    public Long getId() {
    return id;
    }
}

