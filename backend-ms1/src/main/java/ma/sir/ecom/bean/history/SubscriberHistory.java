package ma.sir.ecom.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "subscriber")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="subscriber_seq",sequenceName="subscriber_seq",allocationSize=1, initialValue = 1)
public class SubscriberHistory extends HistBusinessObject  {


    public SubscriberHistory() {
    super();
    }

    public SubscriberHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="subscriber_seq")
    public Long getId() {
    return id;
    }
}

