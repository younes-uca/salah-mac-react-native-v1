package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.ecom.bean.core.Company;

import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.IncomeStatementDeclarationHistory;
import ma.sir.ecom.bean.core.IncomeStatementDeclaration;
import ma.sir.ecom.ws.dto.IncomeStatementDeclarationDto;

@Component
public class IncomeStatementDeclarationConverter extends AbstractConverter<IncomeStatementDeclaration, IncomeStatementDeclarationDto, IncomeStatementDeclarationHistory> {

    @Autowired
    private CompanyConverter companyConverter ;
    @Autowired
    private HandlingAccountantConverter handlingAccountantConverter ;
    @Autowired
    private ValidationAccountantConverter validationAccountantConverter ;
    @Autowired
    private CorporateTaxRateConverter corporateTaxRateConverter ;
    private boolean company;
    private boolean corporateTaxRate;
    private boolean handlingAccountant;
    private boolean validationAccountant;

    public  IncomeStatementDeclarationConverter(){
        super(IncomeStatementDeclaration.class, IncomeStatementDeclarationDto.class, IncomeStatementDeclarationHistory.class);
    }

    @Override
    public IncomeStatementDeclaration toItem(IncomeStatementDeclarationDto dto) {
        if (dto == null) {
            return null;
        } else {
        IncomeStatementDeclaration item = new IncomeStatementDeclaration();
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
            if(StringUtil.isNotEmpty(dto.getTotalExpense()))
                item.setTotalExpense(dto.getTotalExpense());
            if(StringUtil.isNotEmpty(dto.getTotalRevenue()))
                item.setTotalRevenue(dto.getTotalRevenue());
            if(StringUtil.isNotEmpty(dto.getIncomeBeforeTax()))
                item.setIncomeBeforeTax(dto.getIncomeBeforeTax());
            if(StringUtil.isNotEmpty(dto.getTaxAmount()))
                item.setTaxAmount(dto.getTaxAmount());
            if(StringUtil.isNotEmpty(dto.getIncomeAfterTax()))
                item.setIncomeAfterTax(dto.getIncomeAfterTax());
            if(dto.getCompany() != null && dto.getCompany().getId() != null){
                item.setCompany(new Company());
                item.getCompany().setId(dto.getCompany().getId());
            }

            if(this.corporateTaxRate && dto.getCorporateTaxRate()!=null)
                item.setCorporateTaxRate(corporateTaxRateConverter.toItem(dto.getCorporateTaxRate())) ;

            if(this.handlingAccountant && dto.getHandlingAccountant()!=null)
                item.setHandlingAccountant(handlingAccountantConverter.toItem(dto.getHandlingAccountant())) ;

            if(this.validationAccountant && dto.getValidationAccountant()!=null)
                item.setValidationAccountant(validationAccountantConverter.toItem(dto.getValidationAccountant())) ;



        return item;
        }
    }

    @Override
    public IncomeStatementDeclarationDto toDto(IncomeStatementDeclaration item) {
        if (item == null) {
            return null;
        } else {
            IncomeStatementDeclarationDto dto = new IncomeStatementDeclarationDto();
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
            if(StringUtil.isNotEmpty(item.getTotalExpense()))
                dto.setTotalExpense(item.getTotalExpense());
            if(StringUtil.isNotEmpty(item.getTotalRevenue()))
                dto.setTotalRevenue(item.getTotalRevenue());
            if(StringUtil.isNotEmpty(item.getIncomeBeforeTax()))
                dto.setIncomeBeforeTax(item.getIncomeBeforeTax());
            if(StringUtil.isNotEmpty(item.getTaxAmount()))
                dto.setTaxAmount(item.getTaxAmount());
            if(StringUtil.isNotEmpty(item.getIncomeAfterTax()))
                dto.setIncomeAfterTax(item.getIncomeAfterTax());
        if(this.company && item.getCompany()!=null) {
            dto.setCompany(companyConverter.toDto(item.getCompany())) ;
        }
        if(this.corporateTaxRate && item.getCorporateTaxRate()!=null) {
            dto.setCorporateTaxRate(corporateTaxRateConverter.toDto(item.getCorporateTaxRate())) ;
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
        this.corporateTaxRate = value;
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
    public CorporateTaxRateConverter getCorporateTaxRateConverter(){
        return this.corporateTaxRateConverter;
    }
    public void setCorporateTaxRateConverter(CorporateTaxRateConverter corporateTaxRateConverter ){
        this.corporateTaxRateConverter = corporateTaxRateConverter;
    }
    public boolean  isCompany(){
        return this.company;
    }
    public void  setCompany(boolean company){
        this.company = company;
    }
    public boolean  isCorporateTaxRate(){
        return this.corporateTaxRate;
    }
    public void  setCorporateTaxRate(boolean corporateTaxRate){
        this.corporateTaxRate = corporateTaxRate;
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
