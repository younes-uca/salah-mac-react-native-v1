package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.ecom.bean.core.Company;

import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.BalanceSheetHistory;
import ma.sir.ecom.bean.core.BalanceSheet;
import ma.sir.ecom.ws.dto.BalanceSheetDto;

@Component
public class BalanceSheetConverter extends AbstractConverter<BalanceSheet, BalanceSheetDto, BalanceSheetHistory> {

    @Autowired
    private CompanyConverter companyConverter ;
    @Autowired
    private BalanceSheetStatusConverter balanceSheetStatusConverter ;
    private boolean company;
    private boolean balanceSheetStatus;

    public  BalanceSheetConverter(){
        super(BalanceSheet.class, BalanceSheetDto.class, BalanceSheetHistory.class);
    }

    @Override
    public BalanceSheet toItem(BalanceSheetDto dto) {
        if (dto == null) {
            return null;
        } else {
        BalanceSheet item = new BalanceSheet();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getYear()))
                item.setYear(dto.getYear());
            if(StringUtil.isNotEmpty(dto.getIntangibleAssets()))
                item.setIntangibleAssets(dto.getIntangibleAssets());
            if(StringUtil.isNotEmpty(dto.getTangibleAssets()))
                item.setTangibleAssets(dto.getTangibleAssets());
            if(StringUtil.isNotEmpty(dto.getFinancialAssets()))
                item.setFinancialAssets(dto.getFinancialAssets());
            if(StringUtil.isNotEmpty(dto.getTotalFixedAssets()))
                item.setTotalFixedAssets(dto.getTotalFixedAssets());
            if(StringUtil.isNotEmpty(dto.getInventories()))
                item.setInventories(dto.getInventories());
            if(StringUtil.isNotEmpty(dto.getAccountsReceivable()))
                item.setAccountsReceivable(dto.getAccountsReceivable());
            if(StringUtil.isNotEmpty(dto.getTotalCurrentAssets()))
                item.setTotalCurrentAssets(dto.getTotalCurrentAssets());
            if(StringUtil.isNotEmpty(dto.getBankDeposits()))
                item.setBankDeposits(dto.getBankDeposits());
            if(StringUtil.isNotEmpty(dto.getCashInHand()))
                item.setCashInHand(dto.getCashInHand());
            if(StringUtil.isNotEmpty(dto.getTotalTreasuryAssets()))
                item.setTotalTreasuryAssets(dto.getTotalTreasuryAssets());
            if(StringUtil.isNotEmpty(dto.getTotalAssets()))
                item.setTotalAssets(dto.getTotalAssets());
            if(StringUtil.isNotEmpty(dto.getEquity()))
                item.setEquity(dto.getEquity());
            if(StringUtil.isNotEmpty(dto.getLoans()))
                item.setLoans(dto.getLoans());
            if(StringUtil.isNotEmpty(dto.getProfit()))
                item.setProfit(dto.getProfit());
            if(StringUtil.isNotEmpty(dto.getTotalPermanentFinancing()))
                item.setTotalPermanentFinancing(dto.getTotalPermanentFinancing());
            if(StringUtil.isNotEmpty(dto.getAccountsPayable()))
                item.setAccountsPayable(dto.getAccountsPayable());
            if(StringUtil.isNotEmpty(dto.getOtherCurrentLiabilities()))
                item.setOtherCurrentLiabilities(dto.getOtherCurrentLiabilities());
            if(StringUtil.isNotEmpty(dto.getTotalCurrentLiabilities()))
                item.setTotalCurrentLiabilities(dto.getTotalCurrentLiabilities());
            if(StringUtil.isNotEmpty(dto.getTotalLiabilities()))
                item.setTotalLiabilities(dto.getTotalLiabilities());
            if(dto.getCompany() != null && dto.getCompany().getId() != null){
                item.setCompany(new Company());
                item.getCompany().setId(dto.getCompany().getId());
            }

            if(this.balanceSheetStatus && dto.getBalanceSheetStatus()!=null)
                item.setBalanceSheetStatus(balanceSheetStatusConverter.toItem(dto.getBalanceSheetStatus())) ;



        return item;
        }
    }

    @Override
    public BalanceSheetDto toDto(BalanceSheet item) {
        if (item == null) {
            return null;
        } else {
            BalanceSheetDto dto = new BalanceSheetDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(StringUtil.isNotEmpty(item.getYear()))
                dto.setYear(item.getYear());
            if(StringUtil.isNotEmpty(item.getIntangibleAssets()))
                dto.setIntangibleAssets(item.getIntangibleAssets());
            if(StringUtil.isNotEmpty(item.getTangibleAssets()))
                dto.setTangibleAssets(item.getTangibleAssets());
            if(StringUtil.isNotEmpty(item.getFinancialAssets()))
                dto.setFinancialAssets(item.getFinancialAssets());
            if(StringUtil.isNotEmpty(item.getTotalFixedAssets()))
                dto.setTotalFixedAssets(item.getTotalFixedAssets());
            if(StringUtil.isNotEmpty(item.getInventories()))
                dto.setInventories(item.getInventories());
            if(StringUtil.isNotEmpty(item.getAccountsReceivable()))
                dto.setAccountsReceivable(item.getAccountsReceivable());
            if(StringUtil.isNotEmpty(item.getTotalCurrentAssets()))
                dto.setTotalCurrentAssets(item.getTotalCurrentAssets());
            if(StringUtil.isNotEmpty(item.getBankDeposits()))
                dto.setBankDeposits(item.getBankDeposits());
            if(StringUtil.isNotEmpty(item.getCashInHand()))
                dto.setCashInHand(item.getCashInHand());
            if(StringUtil.isNotEmpty(item.getTotalTreasuryAssets()))
                dto.setTotalTreasuryAssets(item.getTotalTreasuryAssets());
            if(StringUtil.isNotEmpty(item.getTotalAssets()))
                dto.setTotalAssets(item.getTotalAssets());
            if(StringUtil.isNotEmpty(item.getEquity()))
                dto.setEquity(item.getEquity());
            if(StringUtil.isNotEmpty(item.getLoans()))
                dto.setLoans(item.getLoans());
            if(StringUtil.isNotEmpty(item.getProfit()))
                dto.setProfit(item.getProfit());
            if(StringUtil.isNotEmpty(item.getTotalPermanentFinancing()))
                dto.setTotalPermanentFinancing(item.getTotalPermanentFinancing());
            if(StringUtil.isNotEmpty(item.getAccountsPayable()))
                dto.setAccountsPayable(item.getAccountsPayable());
            if(StringUtil.isNotEmpty(item.getOtherCurrentLiabilities()))
                dto.setOtherCurrentLiabilities(item.getOtherCurrentLiabilities());
            if(StringUtil.isNotEmpty(item.getTotalCurrentLiabilities()))
                dto.setTotalCurrentLiabilities(item.getTotalCurrentLiabilities());
            if(StringUtil.isNotEmpty(item.getTotalLiabilities()))
                dto.setTotalLiabilities(item.getTotalLiabilities());
        if(this.company && item.getCompany()!=null) {
            dto.setCompany(companyConverter.toDto(item.getCompany())) ;
        }
        if(this.balanceSheetStatus && item.getBalanceSheetStatus()!=null) {
            dto.setBalanceSheetStatus(balanceSheetStatusConverter.toDto(item.getBalanceSheetStatus())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.company = value;
        this.balanceSheetStatus = value;
    }


    public CompanyConverter getCompanyConverter(){
        return this.companyConverter;
    }
    public void setCompanyConverter(CompanyConverter companyConverter ){
        this.companyConverter = companyConverter;
    }
    public BalanceSheetStatusConverter getBalanceSheetStatusConverter(){
        return this.balanceSheetStatusConverter;
    }
    public void setBalanceSheetStatusConverter(BalanceSheetStatusConverter balanceSheetStatusConverter ){
        this.balanceSheetStatusConverter = balanceSheetStatusConverter;
    }
    public boolean  isCompany(){
        return this.company;
    }
    public void  setCompany(boolean company){
        this.company = company;
    }
    public boolean  isBalanceSheetStatus(){
        return this.balanceSheetStatus;
    }
    public void  setBalanceSheetStatus(boolean balanceSheetStatus){
        this.balanceSheetStatus = balanceSheetStatus;
    }
}
