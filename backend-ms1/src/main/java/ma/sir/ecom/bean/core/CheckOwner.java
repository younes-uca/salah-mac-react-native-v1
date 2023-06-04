package ma.sir.ecom.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "check_owner")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="check_owner_seq",sequenceName="check_owner_seq",allocationSize=1, initialValue = 1)
public class CheckOwner   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String name;
    @Column(length = 500)
    private String code;



    public CheckOwner(){
        super();
    }

    public CheckOwner(Long id,String name){
        this.id = id;
        this.name = name ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="check_owner_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }

    @Transient
    public String getLabel() {
        label = name;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckOwner checkOwner = (CheckOwner) o;
        return id != null && id.equals(checkOwner.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

