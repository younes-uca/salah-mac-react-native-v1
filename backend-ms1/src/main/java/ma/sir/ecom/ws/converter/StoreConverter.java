package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.ecom.bean.core.Company;

import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.StoreHistory;
import ma.sir.ecom.bean.core.Store;
import ma.sir.ecom.ws.dto.StoreDto;

@Component
public class StoreConverter extends AbstractConverter<Store, StoreDto, StoreHistory> {

    @Autowired
    private CompanyConverter companyConverter ;
    private boolean company;

    public  StoreConverter(){
        super(Store.class, StoreDto.class, StoreHistory.class);
    }

    @Override
    public Store toItem(StoreDto dto) {
        if (dto == null) {
            return null;
        } else {
        Store item = new Store();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(dto.getCompany() != null && dto.getCompany().getId() != null){
                item.setCompany(new Company());
                item.getCompany().setId(dto.getCompany().getId());
            }



        return item;
        }
    }

    @Override
    public StoreDto toDto(Store item) {
        if (item == null) {
            return null;
        } else {
            StoreDto dto = new StoreDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
        if(this.company && item.getCompany()!=null) {
            dto.setCompany(companyConverter.toDto(item.getCompany())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.company = value;
    }


    public CompanyConverter getCompanyConverter(){
        return this.companyConverter;
    }
    public void setCompanyConverter(CompanyConverter companyConverter ){
        this.companyConverter = companyConverter;
    }
    public boolean  isCompany(){
        return this.company;
    }
    public void  setCompany(boolean company){
        this.company = company;
    }
}
