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




@Entity
@Table(name = "subscriber")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="subscriber_seq",sequenceName="subscriber_seq",allocationSize=1, initialValue = 1)
public class Subscriber   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String address;
    @Column(columnDefinition = "boolean default false")
    private Boolean blocked = false;
    private LocalDateTime creationDate ;
    @Column(length = 500)
    private String email;
    @Column(length = 500)
    private String phone;
    @Column(length = 500)
    private String logo;
    @Column(length = 500)
    private String firstName;
    @Column(length = 500)
    private String lastName;
    @Column(length = 500)
    private String companyName;
    @Column(length = 500)
    private String backupPath;
    @Column(length = 500)
    private String patent;
    @Column(length = 500)
    private String rc;
    @Column(length = 500)
    private String cnss;
    @Column(length = 500)
    private String ifisc;
    @Column(length = 500)
    private String ice;


    private List<Company> companys ;

    public Subscriber(){
        super();
    }

    public Subscriber(Long id,String code){
        this.id = id;
        this.code = code ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="subscriber_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getAddress(){
        return this.address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public Boolean  getBlocked(){
        return this.blocked;
    }
    public void setBlocked(Boolean blocked){
        this.blocked = blocked;
    }
    public LocalDateTime getCreationDate(){
        return this.creationDate;
    }
    public void setCreationDate(LocalDateTime creationDate){
        this.creationDate = creationDate;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPhone(){
        return this.phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getLogo(){
        return this.logo;
    }
    public void setLogo(String logo){
        this.logo = logo;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getCompanyName(){
        return this.companyName;
    }
    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }
    public String getBackupPath(){
        return this.backupPath;
    }
    public void setBackupPath(String backupPath){
        this.backupPath = backupPath;
    }
    public String getPatent(){
        return this.patent;
    }
    public void setPatent(String patent){
        this.patent = patent;
    }
    public String getRc(){
        return this.rc;
    }
    public void setRc(String rc){
        this.rc = rc;
    }
    public String getCnss(){
        return this.cnss;
    }
    public void setCnss(String cnss){
        this.cnss = cnss;
    }
    public String getIfisc(){
        return this.ifisc;
    }
    public void setIfisc(String ifisc){
        this.ifisc = ifisc;
    }
    public String getIce(){
        return this.ice;
    }
    public void setIce(String ice){
        this.ice = ice;
    }
    @OneToMany(mappedBy = "subscriber")
    public List<Company> getCompanys(){
        return this.companys;
    }
    public void setCompanys(List<Company> companys){
        this.companys = companys;
    }

    @Transient
    public String getLabel() {
        label = code;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscriber subscriber = (Subscriber) o;
        return id != null && id.equals(subscriber.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

