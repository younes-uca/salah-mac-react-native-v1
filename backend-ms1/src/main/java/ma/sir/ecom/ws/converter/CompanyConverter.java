package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.ecom.zynerator.util.ListUtil;

import ma.sir.ecom.bean.core.Subscriber;

import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.CompanyHistory;
import ma.sir.ecom.bean.core.Company;
import ma.sir.ecom.ws.dto.CompanyDto;

@Component
public class CompanyConverter extends AbstractConverter<Company, CompanyDto, CompanyHistory> {

    @Autowired
    private StoreConverter storeConverter ;
    @Autowired
    private SubscriberConverter subscriberConverter ;
    private boolean subscriber;
    private boolean stores;

    public  CompanyConverter(){
        super(Company.class, CompanyDto.class, CompanyHistory.class);
        init(true);
    }

    @Override
    public Company toItem(CompanyDto dto) {
        if (dto == null) {
            return null;
        } else {
        Company item = new Company();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getIce()))
                item.setIce(dto.getIce());
            if(StringUtil.isNotEmpty(dto.getHeadquarters()))
                item.setHeadquarters(dto.getHeadquarters());
            if(StringUtil.isNotEmpty(dto.getLastPaidYearIS()))
                item.setLastPaidYearIS(dto.getLastPaidYearIS());
            if(StringUtil.isNotEmpty(dto.getLastPaidQuarterIS()))
                item.setLastPaidQuarterIS(dto.getLastPaidQuarterIS());
            if(StringUtil.isNotEmpty(dto.getLastPaidYearVAT()))
                item.setLastPaidYearVAT(dto.getLastPaidYearVAT());
            if(StringUtil.isNotEmpty(dto.getLastPaidQuarterVAT()))
                item.setLastPaidQuarterVAT(dto.getLastPaidQuarterVAT());
            if(dto.getBlocked() != null)
                item.setBlocked(dto.getBlocked());
            if(dto.getSubscriber() != null && dto.getSubscriber().getId() != null){
                item.setSubscriber(new Subscriber());
                item.getSubscriber().setId(dto.getSubscriber().getId());
            }


            if(this.stores && ListUtil.isNotEmpty(dto.getStores()))
                item.setStores(storeConverter.toItem(dto.getStores()));

        return item;
        }
    }

    @Override
    public CompanyDto toDto(Company item) {
        if (item == null) {
            return null;
        } else {
            CompanyDto dto = new CompanyDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getIce()))
                dto.setIce(item.getIce());
            if(StringUtil.isNotEmpty(item.getHeadquarters()))
                dto.setHeadquarters(item.getHeadquarters());
            if(StringUtil.isNotEmpty(item.getLastPaidYearIS()))
                dto.setLastPaidYearIS(item.getLastPaidYearIS());
            if(StringUtil.isNotEmpty(item.getLastPaidQuarterIS()))
                dto.setLastPaidQuarterIS(item.getLastPaidQuarterIS());
            if(StringUtil.isNotEmpty(item.getLastPaidYearVAT()))
                dto.setLastPaidYearVAT(item.getLastPaidYearVAT());
            if(StringUtil.isNotEmpty(item.getLastPaidQuarterVAT()))
                dto.setLastPaidQuarterVAT(item.getLastPaidQuarterVAT());
                dto.setBlocked(item.getBlocked());
        if(this.subscriber && item.getSubscriber()!=null) {
            dto.setSubscriber(subscriberConverter.toDto(item.getSubscriber())) ;
        }
        if(this.stores && ListUtil.isNotEmpty(item.getStores())){
            storeConverter.init(true);
            storeConverter.setCompany(false);
            dto.setStores(storeConverter.toDto(item.getStores()));
            storeConverter.setCompany(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.stores = value;
    }

    public void initObject(boolean value) {
        this.subscriber = value;
    }


    public StoreConverter getStoreConverter(){
        return this.storeConverter;
    }
    public void setStoreConverter(StoreConverter storeConverter ){
        this.storeConverter = storeConverter;
    }
    public SubscriberConverter getSubscriberConverter(){
        return this.subscriberConverter;
    }
    public void setSubscriberConverter(SubscriberConverter subscriberConverter ){
        this.subscriberConverter = subscriberConverter;
    }
    public boolean  isSubscriber(){
        return this.subscriber;
    }
    public void  setSubscriber(boolean subscriber){
        this.subscriber = subscriber;
    }
    public boolean  isStores(){
        return this.stores ;
    }
    public void  setStores(boolean stores ){
        this.stores  = stores ;
    }
}
