package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.ecom.bean.core.Delivery;

import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.DeliveryItemHistory;
import ma.sir.ecom.bean.core.DeliveryItem;
import ma.sir.ecom.ws.dto.DeliveryItemDto;

@Component
public class DeliveryItemConverter extends AbstractConverter<DeliveryItem, DeliveryItemDto, DeliveryItemHistory> {

    @Autowired
    private StoreConverter storeConverter ;
    @Autowired
    private DeliveryConverter deliveryConverter ;
    @Autowired
    private ProductConverter productConverter ;
    private boolean product;
    private boolean store;
    private boolean delivery;

    public  DeliveryItemConverter(){
        super(DeliveryItem.class, DeliveryItemDto.class, DeliveryItemHistory.class);
    }

    @Override
    public DeliveryItem toItem(DeliveryItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        DeliveryItem item = new DeliveryItem();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getQuantity()))
                item.setQuantity(dto.getQuantity());
            if(this.product && dto.getProduct()!=null)
                item.setProduct(productConverter.toItem(dto.getProduct())) ;

            if(this.store && dto.getStore()!=null)
                item.setStore(storeConverter.toItem(dto.getStore())) ;

            if(dto.getDelivery() != null && dto.getDelivery().getId() != null){
                item.setDelivery(new Delivery());
                item.getDelivery().setId(dto.getDelivery().getId());
            }



        return item;
        }
    }

    @Override
    public DeliveryItemDto toDto(DeliveryItem item) {
        if (item == null) {
            return null;
        } else {
            DeliveryItemDto dto = new DeliveryItemDto();
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
        if(this.delivery && item.getDelivery()!=null) {
            dto.setDelivery(deliveryConverter.toDto(item.getDelivery())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.product = value;
        this.store = value;
        this.delivery = value;
    }


    public StoreConverter getStoreConverter(){
        return this.storeConverter;
    }
    public void setStoreConverter(StoreConverter storeConverter ){
        this.storeConverter = storeConverter;
    }
    public DeliveryConverter getDeliveryConverter(){
        return this.deliveryConverter;
    }
    public void setDeliveryConverter(DeliveryConverter deliveryConverter ){
        this.deliveryConverter = deliveryConverter;
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
    public boolean  isDelivery(){
        return this.delivery;
    }
    public void  setDelivery(boolean delivery){
        this.delivery = delivery;
    }
}
