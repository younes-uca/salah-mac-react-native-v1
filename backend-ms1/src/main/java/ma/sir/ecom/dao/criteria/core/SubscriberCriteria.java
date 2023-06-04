package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class SubscriberCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String address;
    private String addressLike;
    private Boolean blocked;
    private LocalDateTime creationDate;
    private LocalDateTime creationDateFrom;
    private LocalDateTime creationDateTo;
    private String email;
    private String emailLike;
    private String phone;
    private String phoneLike;
    private String logo;
    private String logoLike;
    private String firstName;
    private String firstNameLike;
    private String lastName;
    private String lastNameLike;
    private String companyName;
    private String companyNameLike;
    private String backupPath;
    private String backupPathLike;
    private String patent;
    private String patentLike;
    private String rc;
    private String rcLike;
    private String cnss;
    private String cnssLike;
    private String ifisc;
    private String ifiscLike;
    private String ice;
    private String iceLike;



    public SubscriberCriteria(){}

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCodeLike(){
        return this.codeLike;
    }
    public void setCodeLike(String codeLike){
        this.codeLike = codeLike;
    }

    public String getAddress(){
        return this.address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddressLike(){
        return this.addressLike;
    }
    public void setAddressLike(String addressLike){
        this.addressLike = addressLike;
    }

    public Boolean getBlocked(){
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
    public LocalDateTime getCreationDateFrom(){
        return this.creationDateFrom;
    }
    public void setCreationDateFrom(LocalDateTime creationDateFrom){
        this.creationDateFrom = creationDateFrom;
    }
    public LocalDateTime getCreationDateTo(){
        return this.creationDateTo;
    }
    public void setCreationDateTo(LocalDateTime creationDateTo){
        this.creationDateTo = creationDateTo;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmailLike(){
        return this.emailLike;
    }
    public void setEmailLike(String emailLike){
        this.emailLike = emailLike;
    }

    public String getPhone(){
        return this.phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhoneLike(){
        return this.phoneLike;
    }
    public void setPhoneLike(String phoneLike){
        this.phoneLike = phoneLike;
    }

    public String getLogo(){
        return this.logo;
    }
    public void setLogo(String logo){
        this.logo = logo;
    }
    public String getLogoLike(){
        return this.logoLike;
    }
    public void setLogoLike(String logoLike){
        this.logoLike = logoLike;
    }

    public String getFirstName(){
        return this.firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstNameLike(){
        return this.firstNameLike;
    }
    public void setFirstNameLike(String firstNameLike){
        this.firstNameLike = firstNameLike;
    }

    public String getLastName(){
        return this.lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastNameLike(){
        return this.lastNameLike;
    }
    public void setLastNameLike(String lastNameLike){
        this.lastNameLike = lastNameLike;
    }

    public String getCompanyName(){
        return this.companyName;
    }
    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }
    public String getCompanyNameLike(){
        return this.companyNameLike;
    }
    public void setCompanyNameLike(String companyNameLike){
        this.companyNameLike = companyNameLike;
    }

    public String getBackupPath(){
        return this.backupPath;
    }
    public void setBackupPath(String backupPath){
        this.backupPath = backupPath;
    }
    public String getBackupPathLike(){
        return this.backupPathLike;
    }
    public void setBackupPathLike(String backupPathLike){
        this.backupPathLike = backupPathLike;
    }

    public String getPatent(){
        return this.patent;
    }
    public void setPatent(String patent){
        this.patent = patent;
    }
    public String getPatentLike(){
        return this.patentLike;
    }
    public void setPatentLike(String patentLike){
        this.patentLike = patentLike;
    }

    public String getRc(){
        return this.rc;
    }
    public void setRc(String rc){
        this.rc = rc;
    }
    public String getRcLike(){
        return this.rcLike;
    }
    public void setRcLike(String rcLike){
        this.rcLike = rcLike;
    }

    public String getCnss(){
        return this.cnss;
    }
    public void setCnss(String cnss){
        this.cnss = cnss;
    }
    public String getCnssLike(){
        return this.cnssLike;
    }
    public void setCnssLike(String cnssLike){
        this.cnssLike = cnssLike;
    }

    public String getIfisc(){
        return this.ifisc;
    }
    public void setIfisc(String ifisc){
        this.ifisc = ifisc;
    }
    public String getIfiscLike(){
        return this.ifiscLike;
    }
    public void setIfiscLike(String ifiscLike){
        this.ifiscLike = ifiscLike;
    }

    public String getIce(){
        return this.ice;
    }
    public void setIce(String ice){
        this.ice = ice;
    }
    public String getIceLike(){
        return this.iceLike;
    }
    public void setIceLike(String iceLike){
        this.iceLike = iceLike;
    }


}
