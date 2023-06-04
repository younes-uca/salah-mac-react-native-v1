package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.ecom.bean.core.Sale;

import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.SaleItemHistory;
import ma.sir.ecom.bean.core.SaleItem;
import ma.sir.ecom.ws.dto.SaleItemDto;

@Component
public class SaleItemConverter extends AbstractConverter<SaleItem, SaleItemDto, SaleItemHistory> {

    @Autowired
    private SaleConverter saleConverter ;
    @Autowired
    private ProductConverter productConverter ;
    private boolean product;
    private boolean sale;

    public  SaleItemConverter(){
        super(SaleItem.class, SaleItemDto.class, SaleItemHistory.class);
    }

    @Override
    public SaleItem toItem(SaleItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        SaleItem item = new SaleItem();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getUnitPrice()))
                item.setUnitPrice(dto.getUnitPrice());
            if(StringUtil.isNotEmpty(dto.getQuantity()))
                item.setQuantity(dto.getQuantity());
            if(StringUtil.isNotEmpty(dto.getDiscount()))
                item.setDiscount(dto.getDiscount());
            if(StringUtil.isNotEmpty(dto.getQuantityReturned()))
                item.setQuantityReturned(dto.getQuantityReturned());
            if(this.product && dto.getProduct()!=null)
                item.setProduct(productConverter.toItem(dto.getProduct())) ;

            if(dto.getSale() != null && dto.getSale().getId() != null){
                item.setSale(new Sale());
                item.getSale().setId(dto.getSale().getId());
            }



        return item;
        }
    }

    @Override
    public SaleItemDto toDto(SaleItem item) {
        if (item == null) {
            return null;
        } else {
            SaleItemDto dto = new SaleItemDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getUnitPrice()))
                dto.setUnitPrice(item.getUnitPrice());
            if(StringUtil.isNotEmpty(item.getQuantity()))
                dto.setQuantity(item.getQuantity());
            if(StringUtil.isNotEmpty(item.getDiscount()))
                dto.setDiscount(item.getDiscount());
            if(StringUtil.isNotEmpty(item.getQuantityReturned()))
                dto.setQuantityReturned(item.getQuantityReturned());
        if(this.product && item.getProduct()!=null) {
            dto.setProduct(productConverter.toDto(item.getProduct())) ;
        }
        if(this.sale && item.getSale()!=null) {
            dto.setSale(saleConverter.toDto(item.getSale())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.product = value;
        this.sale = value;
    }


    public SaleConverter getSaleConverter(){
        return this.saleConverter;
    }
    public void setSaleConverter(SaleConverter saleConverter ){
        this.saleConverter = saleConverter;
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
    public boolean  isSale(){
        return this.sale;
    }
    public void  setSale(boolean sale){
        this.sale = sale;
    }
}
