package ma.sir.ecom.bean.core;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;



import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "credit_note_purchase")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="credit_note_purchase_seq",sequenceName="credit_note_purchase_seq",allocationSize=1, initialValue = 1)
public class CreditNotePurchase   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime creditNoteDate ;
    private BigDecimal amount = BigDecimal.ZERO;

    private Purchase purchase ;
    
    private CreditNotePurchaseStatus creditNotePurchaseStatus ;
    

    private List<CreditNotePurchaseItem> creditNotePurchaseItems ;

    public CreditNotePurchase(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="credit_note_purchase_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public LocalDateTime getCreditNoteDate(){
        return this.creditNoteDate;
    }
    public void setCreditNoteDate(LocalDateTime creditNoteDate){
        this.creditNoteDate = creditNoteDate;
    }
    public BigDecimal getAmount(){
        return this.amount;
    }
    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Purchase getPurchase(){
        return this.purchase;
    }
    public void setPurchase(Purchase purchase){
        this.purchase = purchase;
    }
    @OneToMany(mappedBy = "creditNotePurchase")
    public List<CreditNotePurchaseItem> getCreditNotePurchaseItems(){
        return this.creditNotePurchaseItems;
    }
    public void setCreditNotePurchaseItems(List<CreditNotePurchaseItem> creditNotePurchaseItems){
        this.creditNotePurchaseItems = creditNotePurchaseItems;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public CreditNotePurchaseStatus getCreditNotePurchaseStatus(){
        return this.creditNotePurchaseStatus;
    }
    public void setCreditNotePurchaseStatus(CreditNotePurchaseStatus creditNotePurchaseStatus){
        this.creditNotePurchaseStatus = creditNotePurchaseStatus;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditNotePurchase creditNotePurchase = (CreditNotePurchase) o;
        return id != null && id.equals(creditNotePurchase.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

