package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.ecom.bean.core.CreditNotePurchase;

import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.CreditNotePurchaseItemHistory;
import ma.sir.ecom.bean.core.CreditNotePurchaseItem;
import ma.sir.ecom.ws.dto.CreditNotePurchaseItemDto;

@Component
public class CreditNotePurchaseItemConverter extends AbstractConverter<CreditNotePurchaseItem, CreditNotePurchaseItemDto, CreditNotePurchaseItemHistory> {

    @Autowired
    private CreditNotePurchaseConverter creditNotePurchaseConverter ;
    @Autowired
    private ProductConverter productConverter ;
    private boolean product;
    private boolean creditNotePurchase;

    public  CreditNotePurchaseItemConverter(){
        super(CreditNotePurchaseItem.class, CreditNotePurchaseItemDto.class, CreditNotePurchaseItemHistory.class);
    }

    @Override
    public CreditNotePurchaseItem toItem(CreditNotePurchaseItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        CreditNotePurchaseItem item = new CreditNotePurchaseItem();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getAmount()))
                item.setAmount(dto.getAmount());
            if(StringUtil.isNotEmpty(dto.getQuantity()))
                item.setQuantity(dto.getQuantity());
            if(this.product && dto.getProduct()!=null)
                item.setProduct(productConverter.toItem(dto.getProduct())) ;

            if(dto.getCreditNotePurchase() != null && dto.getCreditNotePurchase().getId() != null){
                item.setCreditNotePurchase(new CreditNotePurchase());
                item.getCreditNotePurchase().setId(dto.getCreditNotePurchase().getId());
            }



        return item;
        }
    }

    @Override
    public CreditNotePurchaseItemDto toDto(CreditNotePurchaseItem item) {
        if (item == null) {
            return null;
        } else {
            CreditNotePurchaseItemDto dto = new CreditNotePurchaseItemDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getAmount()))
                dto.setAmount(item.getAmount());
            if(StringUtil.isNotEmpty(item.getQuantity()))
                dto.setQuantity(item.getQuantity());
        if(this.product && item.getProduct()!=null) {
            dto.setProduct(productConverter.toDto(item.getProduct())) ;
        }
        if(this.creditNotePurchase && item.getCreditNotePurchase()!=null) {
            dto.setCreditNotePurchase(creditNotePurchaseConverter.toDto(item.getCreditNotePurchase())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.product = value;
        this.creditNotePurchase = value;
    }


    public CreditNotePurchaseConverter getCreditNotePurchaseConverter(){
        return this.creditNotePurchaseConverter;
    }
    public void setCreditNotePurchaseConverter(CreditNotePurchaseConverter creditNotePurchaseConverter ){
        this.creditNotePurchaseConverter = creditNotePurchaseConverter;
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
    public boolean  isCreditNotePurchase(){
        return this.creditNotePurchase;
    }
    public void  setCreditNotePurchase(boolean creditNotePurchase){
        this.creditNotePurchase = creditNotePurchase;
    }
}
