package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.ecom.bean.core.Company;

import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.VatDeclarationHistory;
import ma.sir.ecom.bean.core.VatDeclaration;
import ma.sir.ecom.ws.dto.VatDeclarationDto;

@Component
public class VatDeclarationConverter extends AbstractConverter<VatDeclaration, VatDeclarationDto, VatDeclarationHistory> {

    @Autowired
    private CompanyConverter companyConverter ;
    @Autowired
    private HandlingAccountantConverter handlingAccountantConverter ;
    @Autowired
    private ValidationAccountantConverter validationAccountantConverter ;
    @Autowired
    private LatePaymentRateConverter latePaymentRateConverter ;
    private boolean company;
    private boolean latePaymentRate;
    private boolean handlingAccountant;
    private boolean validationAccountant;

    public  VatDeclarationConverter(){
        super(VatDeclaration.class, VatDeclarationDto.class, VatDeclarationHistory.class);
    }

    @Override
    public VatDeclaration toItem(VatDeclarationDto dto) {
        if (dto == null) {
            return null;
        } else {
        VatDeclaration item = new VatDeclaration();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getDeclarationDate()))
                item.setDeclarationDate(DateUtil.stringEnToDate(dto.getDeclarationDate()));
            if(StringUtil.isNotEmpty(dto.getQuarter()))
                item.setQuarter(dto.getQuarter());
            if(StringUtil.isNotEmpty(dto.getYear()))
                item.setYear(dto.getYear());
            if(StringUtil.isNotEmpty(dto.getTotalCollectedVat()))
                item.setTotalCollectedVat(dto.getTotalCollectedVat());
            if(StringUtil.isNotEmpty(dto.getTotalDueVat()))
                item.setTotalDueVat(dto.getTotalDueVat());
            if(StringUtil.isNotEmpty(dto.getVatDifference()))
                item.setVatDifference(dto.getVatDifference());
            if(StringUtil.isNotEmpty(dto.getVatAmount()))
                item.setVatAmount(dto.getVatAmount());
            if(dto.getCompany() != null && dto.getCompany().getId() != null){
                item.setCompany(new Company());
                item.getCompany().setId(dto.getCompany().getId());
            }

            if(this.latePaymentRate && dto.getLatePaymentRate()!=null)
                item.setLatePaymentRate(latePaymentRateConverter.toItem(dto.getLatePaymentRate())) ;

            if(this.handlingAccountant && dto.getHandlingAccountant()!=null)
                item.setHandlingAccountant(handlingAccountantConverter.toItem(dto.getHandlingAccountant())) ;

            if(this.validationAccountant && dto.getValidationAccountant()!=null)
                item.setValidationAccountant(validationAccountantConverter.toItem(dto.getValidationAccountant())) ;



        return item;
        }
    }

    @Override
    public VatDeclarationDto toDto(VatDeclaration item) {
        if (item == null) {
            return null;
        } else {
            VatDeclarationDto dto = new VatDeclarationDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getDeclarationDate()!=null)
                dto.setDeclarationDate(DateUtil.dateTimeToString(item.getDeclarationDate()));
            if(StringUtil.isNotEmpty(item.getQuarter()))
                dto.setQuarter(item.getQuarter());
            if(StringUtil.isNotEmpty(item.getYear()))
                dto.setYear(item.getYear());
            if(StringUtil.isNotEmpty(item.getTotalCollectedVat()))
                dto.setTotalCollectedVat(item.getTotalCollectedVat());
            if(StringUtil.isNotEmpty(item.getTotalDueVat()))
                dto.setTotalDueVat(item.getTotalDueVat());
            if(StringUtil.isNotEmpty(item.getVatDifference()))
                dto.setVatDifference(item.getVatDifference());
            if(StringUtil.isNotEmpty(item.getVatAmount()))
                dto.setVatAmount(item.getVatAmount());
        if(this.company && item.getCompany()!=null) {
            dto.setCompany(companyConverter.toDto(item.getCompany())) ;
        }
        if(this.latePaymentRate && item.getLatePaymentRate()!=null) {
            dto.setLatePaymentRate(latePaymentRateConverter.toDto(item.getLatePaymentRate())) ;
        }
        if(this.handlingAccountant && item.getHandlingAccountant()!=null) {
            dto.setHandlingAccountant(handlingAccountantConverter.toDto(item.getHandlingAccountant())) ;
        }
        if(this.validationAccountant && item.getValidationAccountant()!=null) {
            dto.setValidationAccountant(validationAccountantConverter.toDto(item.getValidationAccountant())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.company = value;
        this.latePaymentRate = value;
        this.handlingAccountant = value;
        this.validationAccountant = value;
    }


    public CompanyConverter getCompanyConverter(){
        return this.companyConverter;
    }
    public void setCompanyConverter(CompanyConverter companyConverter ){
        this.companyConverter = companyConverter;
    }
    public HandlingAccountantConverter getHandlingAccountantConverter(){
        return this.handlingAccountantConverter;
    }
    public void setHandlingAccountantConverter(HandlingAccountantConverter handlingAccountantConverter ){
        this.handlingAccountantConverter = handlingAccountantConverter;
    }
    public ValidationAccountantConverter getValidationAccountantConverter(){
        return this.validationAccountantConverter;
    }
    public void setValidationAccountantConverter(ValidationAccountantConverter validationAccountantConverter ){
        this.validationAccountantConverter = validationAccountantConverter;
    }
    public LatePaymentRateConverter getLatePaymentRateConverter(){
        return this.latePaymentRateConverter;
    }
    public void setLatePaymentRateConverter(LatePaymentRateConverter latePaymentRateConverter ){
        this.latePaymentRateConverter = latePaymentRateConverter;
    }
    public boolean  isCompany(){
        return this.company;
    }
    public void  setCompany(boolean company){
        this.company = company;
    }
    public boolean  isLatePaymentRate(){
        return this.latePaymentRate;
    }
    public void  setLatePaymentRate(boolean latePaymentRate){
        this.latePaymentRate = latePaymentRate;
    }
    public boolean  isHandlingAccountant(){
        return this.handlingAccountant;
    }
    public void  setHandlingAccountant(boolean handlingAccountant){
        this.handlingAccountant = handlingAccountant;
    }
    public boolean  isValidationAccountant(){
        return this.validationAccountant;
    }
    public void  setValidationAccountant(boolean validationAccountant){
        this.validationAccountant = validationAccountant;
    }
}
