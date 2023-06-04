package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.ecom.bean.core.Reception;

import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.ReceptionItemHistory;
import ma.sir.ecom.bean.core.ReceptionItem;
import ma.sir.ecom.ws.dto.ReceptionItemDto;

@Component
public class ReceptionItemConverter extends AbstractConverter<ReceptionItem, ReceptionItemDto, ReceptionItemHistory> {

    @Autowired
    private StoreConverter storeConverter ;
    @Autowired
    private ReceptionConverter receptionConverter ;
    @Autowired
    private ProductConverter productConverter ;
    private boolean product;
    private boolean store;
    private boolean reception;

    public  ReceptionItemConverter(){
        super(ReceptionItem.class, ReceptionItemDto.class, ReceptionItemHistory.class);
    }

    @Override
    public ReceptionItem toItem(ReceptionItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        ReceptionItem item = new ReceptionItem();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getQuantity()))
                item.setQuantity(dto.getQuantity());
            if(this.product && dto.getProduct()!=null)
                item.setProduct(productConverter.toItem(dto.getProduct())) ;

            if(this.store && dto.getStore()!=null)
                item.setStore(storeConverter.toItem(dto.getStore())) ;

            if(dto.getReception() != null && dto.getReception().getId() != null){
                item.setReception(new Reception());
                item.getReception().setId(dto.getReception().getId());
            }



        return item;
        }
    }

    @Override
    public ReceptionItemDto toDto(ReceptionItem item) {
        if (item == null) {
            return null;
        } else {
            ReceptionItemDto dto = new ReceptionItemDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getQuantity()))
                dto.setQuantity(item.getQuantity());
        if(this.product && item.getProduct()!=null) {
            dto.setProduct(productConverter.toDto(item.getProduct())) ;
        }
        if(this.store && item.getStore()!=null) {
            dto.setStore(storeConverter.toDto(item.getStore())) ;
        }
        if(this.reception && item.getReception()!=null) {
            dto.setReception(receptionConverter.toDto(item.getReception())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.product = value;
        this.store = value;
        this.reception = value;
    }


    public StoreConverter getStoreConverter(){
        return this.storeConverter;
    }
    public void setStoreConverter(StoreConverter storeConverter ){
        this.storeConverter = storeConverter;
    }
    public ReceptionConverter getReceptionConverter(){
        return this.receptionConverter;
    }
    public void setReceptionConverter(ReceptionConverter receptionConverter ){
        this.receptionConverter = receptionConverter;
    }
    public ProductConverter getProductConverter(){
        return this.productConverter;
    }
    public void setProductConverter(ProductConverter productConverter ){
        this.productConverter = productConverter;
    }
    public boolean  isProduct(){
        return this.product;
    }
    public void  setProduct(boolean product){
        this.product = product;
    }
    public boolean  isStore(){
        return this.store;
    }
    public void  setStore(boolean store){
        this.store = store;
    }
    public boolean  isReception(){
        return this.reception;
    }
    public void  setReception(boolean reception){
        this.reception = reception;
    }
}
