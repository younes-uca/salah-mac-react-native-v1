package ma.sir.ecom.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "validation_accountant")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="validation_accountant_seq",sequenceName="validation_accountant_seq",allocationSize=1, initialValue = 1)
public class ValidationAccountant   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String cin;
    @Column(length = 500)
    private String lastName;
    @Column(length = 500)
    private String firstName;



    public ValidationAccountant(){
        super();
    }

    public ValidationAccountant(Long id,String cin){
        this.id = id;
        this.cin = cin ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="validation_accountant_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getCin(){
        return this.cin;
    }
    public void setCin(String cin){
        this.cin = cin;
    }
    public String getLastName(){
        return this.lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    @Transient
    public String getLabel() {
        label = cin;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValidationAccountant validationAccountant = (ValidationAccountant) o;
        return id != null && id.equals(validationAccountant.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

