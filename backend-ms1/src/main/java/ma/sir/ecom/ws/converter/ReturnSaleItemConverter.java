package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.ecom.bean.core.ReturnSale;

import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.ReturnSaleItemHistory;
import ma.sir.ecom.bean.core.ReturnSaleItem;
import ma.sir.ecom.ws.dto.ReturnSaleItemDto;

@Component
public class ReturnSaleItemConverter extends AbstractConverter<ReturnSaleItem, ReturnSaleItemDto, ReturnSaleItemHistory> {

    @Autowired
    private ProductConverter productConverter ;
    @Autowired
    private ReturnSaleConverter returnSaleConverter ;
    private boolean product;
    private boolean returnSale;

    public  ReturnSaleItemConverter(){
        super(ReturnSaleItem.class, ReturnSaleItemDto.class, ReturnSaleItemHistory.class);
    }

    @Override
    public ReturnSaleItem toItem(ReturnSaleItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        ReturnSaleItem item = new ReturnSaleItem();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReturnAmount()))
                item.setReturnAmount(dto.getReturnAmount());
            if(StringUtil.isNotEmpty(dto.getQuantity()))
                item.setQuantity(dto.getQuantity());
            if(this.product && dto.getProduct()!=null)
                item.setProduct(productConverter.toItem(dto.getProduct())) ;

            if(dto.getReturnSale() != null && dto.getReturnSale().getId() != null){
                item.setReturnSale(new ReturnSale());
                item.getReturnSale().setId(dto.getReturnSale().getId());
            }



        return item;
        }
    }

    @Override
    public ReturnSaleItemDto toDto(ReturnSaleItem item) {
        if (item == null) {
            return null;
        } else {
            ReturnSaleItemDto dto = new ReturnSaleItemDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReturnAmount()))
                dto.setReturnAmount(item.getReturnAmount());
            if(StringUtil.isNotEmpty(item.getQuantity()))
                dto.setQuantity(item.getQuantity());
        if(this.product && item.getProduct()!=null) {
            dto.setProduct(productConverter.toDto(item.getProduct())) ;
        }
        if(this.returnSale && item.getReturnSale()!=null) {
            dto.setReturnSale(returnSaleConverter.toDto(item.getReturnSale())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.product = value;
        this.returnSale = value;
    }


    public ProductConverter getProductConverter(){
        return this.productConverter;
    }
    public void setProductConverter(ProductConverter productConverter ){
        this.productConverter = productConverter;
    }
    public ReturnSaleConverter getReturnSaleConverter(){
        return this.returnSaleConverter;
    }
    public void setReturnSaleConverter(ReturnSaleConverter returnSaleConverter ){
        this.returnSaleConverter = returnSaleConverter;
    }
    public boolean  isProduct(){
        return this.product;
    }
    public void  setProduct(boolean product){
        this.product = product;
    }
    public boolean  isReturnSale(){
        return this.returnSale;
    }
    public void  setReturnSale(boolean returnSale){
        this.returnSale = returnSale;
    }
}
