package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.ecom.bean.core.SupplierQuote;

import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.SupplierQuoteItemHistory;
import ma.sir.ecom.bean.core.SupplierQuoteItem;
import ma.sir.ecom.ws.dto.SupplierQuoteItemDto;

@Component
public class SupplierQuoteItemConverter extends AbstractConverter<SupplierQuoteItem, SupplierQuoteItemDto, SupplierQuoteItemHistory> {

    @Autowired
    private ProductConverter productConverter ;
    @Autowired
    private SupplierQuoteConverter supplierQuoteConverter ;
    private boolean product;
    private boolean supplierQuote;

    public  SupplierQuoteItemConverter(){
        super(SupplierQuoteItem.class, SupplierQuoteItemDto.class, SupplierQuoteItemHistory.class);
    }

    @Override
    public SupplierQuoteItem toItem(SupplierQuoteItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        SupplierQuoteItem item = new SupplierQuoteItem();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getUnitPrice()))
                item.setUnitPrice(dto.getUnitPrice());
            if(StringUtil.isNotEmpty(dto.getQuantity()))
                item.setQuantity(dto.getQuantity());
            if(StringUtil.isNotEmpty(dto.getDiscount()))
                item.setDiscount(dto.getDiscount());
            if(this.product && dto.getProduct()!=null)
                item.setProduct(productConverter.toItem(dto.getProduct())) ;

            if(dto.getSupplierQuote() != null && dto.getSupplierQuote().getId() != null){
                item.setSupplierQuote(new SupplierQuote());
                item.getSupplierQuote().setId(dto.getSupplierQuote().getId());
            }



        return item;
        }
    }

    @Override
    public SupplierQuoteItemDto toDto(SupplierQuoteItem item) {
        if (item == null) {
            return null;
        } else {
            SupplierQuoteItemDto dto = new SupplierQuoteItemDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getUnitPrice()))
                dto.setUnitPrice(item.getUnitPrice());
            if(StringUtil.isNotEmpty(item.getQuantity()))
                dto.setQuantity(item.getQuantity());
            if(StringUtil.isNotEmpty(item.getDiscount()))
                dto.setDiscount(item.getDiscount());
        if(this.product && item.getProduct()!=null) {
            dto.setProduct(productConverter.toDto(item.getProduct())) ;
        }
        if(this.supplierQuote && item.getSupplierQuote()!=null) {
            dto.setSupplierQuote(supplierQuoteConverter.toDto(item.getSupplierQuote())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.product = value;
        this.supplierQuote = value;
    }


    public ProductConverter getProductConverter(){
        return this.productConverter;
    }
    public void setProductConverter(ProductConverter productConverter ){
        this.productConverter = productConverter;
    }
    public SupplierQuoteConverter getSupplierQuoteConverter(){
        return this.supplierQuoteConverter;
    }
    public void setSupplierQuoteConverter(SupplierQuoteConverter supplierQuoteConverter ){
        this.supplierQuoteConverter = supplierQuoteConverter;
    }
    public boolean  isProduct(){
        return this.product;
    }
    public void  setProduct(boolean product){
        this.product = product;
    }
    public boolean  isSupplierQuote(){
        return this.supplierQuote;
    }
    public void  setSupplierQuote(boolean supplierQuote){
        this.supplierQuote = supplierQuote;
    }
}
