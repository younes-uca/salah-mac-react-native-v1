package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.ecom.zynerator.util.ListUtil;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.SubscriberHistory;
import ma.sir.ecom.bean.core.Subscriber;
import ma.sir.ecom.ws.dto.SubscriberDto;

@Component
public class SubscriberConverter extends AbstractConverter<Subscriber, SubscriberDto, SubscriberHistory> {

    @Autowired
    private CompanyConverter companyConverter ;
    @Autowired
    private StoreConverter storeConverter ;
    private boolean companys;

    public  SubscriberConverter(){
        super(Subscriber.class, SubscriberDto.class, SubscriberHistory.class);
        init(true);
    }

    @Override
    public Subscriber toItem(SubscriberDto dto) {
        if (dto == null) {
            return null;
        } else {
        Subscriber item = new Subscriber();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getAddress()))
                item.setAddress(dto.getAddress());
            if(dto.getBlocked() != null)
                item.setBlocked(dto.getBlocked());
            if(StringUtil.isNotEmpty(dto.getCreationDate()))
                item.setCreationDate(DateUtil.stringEnToDate(dto.getCreationDate()));
            if(StringUtil.isNotEmpty(dto.getEmail()))
                item.setEmail(dto.getEmail());
            if(StringUtil.isNotEmpty(dto.getPhone()))
                item.setPhone(dto.getPhone());
            if(StringUtil.isNotEmpty(dto.getLogo()))
                item.setLogo(dto.getLogo());
            if(StringUtil.isNotEmpty(dto.getFirstName()))
                item.setFirstName(dto.getFirstName());
            if(StringUtil.isNotEmpty(dto.getLastName()))
                item.setLastName(dto.getLastName());
            if(StringUtil.isNotEmpty(dto.getCompanyName()))
                item.setCompanyName(dto.getCompanyName());
            if(StringUtil.isNotEmpty(dto.getBackupPath()))
                item.setBackupPath(dto.getBackupPath());
            if(StringUtil.isNotEmpty(dto.getPatent()))
                item.setPatent(dto.getPatent());
            if(StringUtil.isNotEmpty(dto.getRc()))
                item.setRc(dto.getRc());
            if(StringUtil.isNotEmpty(dto.getCnss()))
                item.setCnss(dto.getCnss());
            if(StringUtil.isNotEmpty(dto.getIfisc()))
                item.setIfisc(dto.getIfisc());
            if(StringUtil.isNotEmpty(dto.getIce()))
                item.setIce(dto.getIce());

            if(this.companys && ListUtil.isNotEmpty(dto.getCompanys()))
                item.setCompanys(companyConverter.toItem(dto.getCompanys()));

        return item;
        }
    }

    @Override
    public SubscriberDto toDto(Subscriber item) {
        if (item == null) {
            return null;
        } else {
            SubscriberDto dto = new SubscriberDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getAddress()))
                dto.setAddress(item.getAddress());
                dto.setBlocked(item.getBlocked());
            if(item.getCreationDate()!=null)
                dto.setCreationDate(DateUtil.dateTimeToString(item.getCreationDate()));
            if(StringUtil.isNotEmpty(item.getEmail()))
                dto.setEmail(item.getEmail());
            if(StringUtil.isNotEmpty(item.getPhone()))
                dto.setPhone(item.getPhone());
            if(StringUtil.isNotEmpty(item.getLogo()))
                dto.setLogo(item.getLogo());
            if(StringUtil.isNotEmpty(item.getFirstName()))
                dto.setFirstName(item.getFirstName());
            if(StringUtil.isNotEmpty(item.getLastName()))
                dto.setLastName(item.getLastName());
            if(StringUtil.isNotEmpty(item.getCompanyName()))
                dto.setCompanyName(item.getCompanyName());
            if(StringUtil.isNotEmpty(item.getBackupPath()))
                dto.setBackupPath(item.getBackupPath());
            if(StringUtil.isNotEmpty(item.getPatent()))
                dto.setPatent(item.getPatent());
            if(StringUtil.isNotEmpty(item.getRc()))
                dto.setRc(item.getRc());
            if(StringUtil.isNotEmpty(item.getCnss()))
                dto.setCnss(item.getCnss());
            if(StringUtil.isNotEmpty(item.getIfisc()))
                dto.setIfisc(item.getIfisc());
            if(StringUtil.isNotEmpty(item.getIce()))
                dto.setIce(item.getIce());
        if(this.companys && ListUtil.isNotEmpty(item.getCompanys())){
            companyConverter.init(true);
            companyConverter.setSubscriber(false);
            dto.setCompanys(companyConverter.toDto(item.getCompanys()));
            companyConverter.setSubscriber(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.companys = value;
    }

    public void initObject(boolean value) {
    }


    public CompanyConverter getCompanyConverter(){
        return this.companyConverter;
    }
    public void setCompanyConverter(CompanyConverter companyConverter ){
        this.companyConverter = companyConverter;
    }
    public StoreConverter getStoreConverter(){
        return this.storeConverter;
    }
    public void setStoreConverter(StoreConverter storeConverter ){
        this.storeConverter = storeConverter;
    }
    public boolean  isCompanys(){
        return this.companys ;
    }
    public void  setCompanys(boolean companys ){
        this.companys  = companys ;
    }
}
