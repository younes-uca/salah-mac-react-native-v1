package  ma.sir.ecom.ws.dto;

import ma.sir.ecom.zynerator.audit.Log;
import ma.sir.ecom.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubscriberDto  extends AuditBaseDto {

    private String code  ;
    private String address  ;
    private Boolean blocked  ;
    private String creationDate ;
    private String email  ;
    private String phone  ;
    private String logo  ;
    private String firstName  ;
    private String lastName  ;
    private String companyName  ;
    private String backupPath  ;
    private String patent  ;
    private String rc  ;
    private String cnss  ;
    private String ifisc  ;
    private String ice  ;


    private List<CompanyDto> companys ;


    public SubscriberDto(){
        super();
    }



    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }

    @Log
    public String getAddress(){
        return this.address;
    }
    public void setAddress(String address){
        this.address = address;
    }

    @Log
    public Boolean getBlocked(){
        return this.blocked;
    }
    public void setBlocked(Boolean blocked){
        this.blocked = blocked;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getCreationDate(){
        return this.creationDate;
    }
    public void setCreationDate(String creationDate){
        this.creationDate = creationDate;
    }

    @Log
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    @Log
    public String getPhone(){
        return this.phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }

    @Log
    public String getLogo(){
        return this.logo;
    }
    public void setLogo(String logo){
        this.logo = logo;
    }

    @Log
    public String getFirstName(){
        return this.firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    @Log
    public String getLastName(){
        return this.lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    @Log
    public String getCompanyName(){
        return this.companyName;
    }
    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }

    @Log
    public String getBackupPath(){
        return this.backupPath;
    }
    public void setBackupPath(String backupPath){
        this.backupPath = backupPath;
    }

    @Log
    public String getPatent(){
        return this.patent;
    }
    public void setPatent(String patent){
        this.patent = patent;
    }

    @Log
    public String getRc(){
        return this.rc;
    }
    public void setRc(String rc){
        this.rc = rc;
    }

    @Log
    public String getCnss(){
        return this.cnss;
    }
    public void setCnss(String cnss){
        this.cnss = cnss;
    }

    @Log
    public String getIfisc(){
        return this.ifisc;
    }
    public void setIfisc(String ifisc){
        this.ifisc = ifisc;
    }

    @Log
    public String getIce(){
        return this.ice;
    }
    public void setIce(String ice){
        this.ice = ice;
    }





    public List<CompanyDto> getCompanys(){
        return this.companys;
    }

    public void setCompanys(List<CompanyDto> companys){
        this.companys = companys;
    }

}
