package ma.sir.ecom.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "accounting_account")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="accounting_account_seq",sequenceName="accounting_account_seq",allocationSize=1, initialValue = 1)
public class AccountingAccount   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String code;

    private SubAccountingClass subAccountingClass ;
    


    public AccountingAccount(){
        super();
    }

    public AccountingAccount(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="accounting_account_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public SubAccountingClass getSubAccountingClass(){
        return this.subAccountingClass;
    }
    public void setSubAccountingClass(SubAccountingClass subAccountingClass){
        this.subAccountingClass = subAccountingClass;
    }

    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountingAccount accountingAccount = (AccountingAccount) o;
        return id != null && id.equals(accountingAccount.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

