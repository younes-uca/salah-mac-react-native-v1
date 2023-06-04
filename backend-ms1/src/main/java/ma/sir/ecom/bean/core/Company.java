package ma.sir.ecom.bean.core;

import java.util.Objects;
import java.util.List;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "company")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="company_seq",sequenceName="company_seq",allocationSize=1, initialValue = 1)
public class Company   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String ice;
    @Column(length = 500)
    private String headquarters;
    private Integer lastPaidYearIS = 0;
    private Integer lastPaidQuarterIS = 0;
    private Integer lastPaidYearVAT = 0;
    private Integer lastPaidQuarterVAT = 0;
    @Column(columnDefinition = "boolean default false")
    private Boolean blocked = false;

    private Subscriber subscriber ;
    

    private List<Store> stores ;

    public Company(){
        super();
    }

    public Company(Long id,String ice){
        this.id = id;
        this.ice = ice ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="company_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getIce(){
        return this.ice;
    }
    public void setIce(String ice){
        this.ice = ice;
    }
    public String getHeadquarters(){
        return this.headquarters;
    }
    public void setHeadquarters(String headquarters){
        this.headquarters = headquarters;
    }
    public Integer getLastPaidYearIS(){
        return this.lastPaidYearIS;
    }
    public void setLastPaidYearIS(Integer lastPaidYearIS){
        this.lastPaidYearIS = lastPaidYearIS;
    }
    public Integer getLastPaidQuarterIS(){
        return this.lastPaidQuarterIS;
    }
    public void setLastPaidQuarterIS(Integer lastPaidQuarterIS){
        this.lastPaidQuarterIS = lastPaidQuarterIS;
    }
    public Integer getLastPaidYearVAT(){
        return this.lastPaidYearVAT;
    }
    public void setLastPaidYearVAT(Integer lastPaidYearVAT){
        this.lastPaidYearVAT = lastPaidYearVAT;
    }
    public Integer getLastPaidQuarterVAT(){
        return this.lastPaidQuarterVAT;
    }
    public void setLastPaidQuarterVAT(Integer lastPaidQuarterVAT){
        this.lastPaidQuarterVAT = lastPaidQuarterVAT;
    }
    public Boolean  getBlocked(){
        return this.blocked;
    }
    public void setBlocked(Boolean blocked){
        this.blocked = blocked;
    }
    @OneToMany(mappedBy = "company")
    public List<Store> getStores(){
        return this.stores;
    }
    public void setStores(List<Store> stores){
        this.stores = stores;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Subscriber getSubscriber(){
        return this.subscriber;
    }
    public void setSubscriber(Subscriber subscriber){
        this.subscriber = subscriber;
    }

    @Transient
    public String getLabel() {
        label = ice;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return id != null && id.equals(company.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

