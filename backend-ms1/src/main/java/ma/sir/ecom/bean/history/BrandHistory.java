package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "brand")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="brand_seq",sequenceName="brand_seq",allocationSize=1, initialValue = 1)
public class BrandHistory extends HistBusinessObject  {


    public BrandHistory() {
    super();
    }

    public BrandHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="brand_seq")
    public Long getId() {
    return id;
    }
}

