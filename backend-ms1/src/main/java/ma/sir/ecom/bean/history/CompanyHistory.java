package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "company")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="company_seq",sequenceName="company_seq",allocationSize=1, initialValue = 1)
public class CompanyHistory extends HistBusinessObject  {


    public CompanyHistory() {
    super();
    }

    public CompanyHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="company_seq")
    public Long getId() {
    return id;
    }
}

