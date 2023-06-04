package ma.sir.ecom.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "bank_check_owner")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="bank_check_owner_seq",sequenceName="bank_check_owner_seq",allocationSize=1, initialValue = 1)
public class BankCheckOwner   extends AuditBusinessObject     {

    private Long id;


    private CheckOwner checkOwner ;
    
    private Bank bank ;
    


    public BankCheckOwner(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="bank_check_owner_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public CheckOwner getCheckOwner(){
        return this.checkOwner;
    }
    public void setCheckOwner(CheckOwner checkOwner){
        this.checkOwner = checkOwner;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Bank getBank(){
        return this.bank;
    }
    public void setBank(Bank bank){
        this.bank = bank;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankCheckOwner bankCheckOwner = (BankCheckOwner) o;
        return id != null && id.equals(bankCheckOwner.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

