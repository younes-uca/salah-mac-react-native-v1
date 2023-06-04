package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "reception_status")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="reception_status_seq",sequenceName="reception_status_seq",allocationSize=1, initialValue = 1)
public class ReceptionStatusHistory extends HistBusinessObject  {


    public ReceptionStatusHistory() {
    super();
    }

    public ReceptionStatusHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="reception_status_seq")
    public Long getId() {
    return id;
    }
}

