package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.ecom.zynerator.util.ListUtil;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.SupplierQuoteHistory;
import ma.sir.ecom.bean.core.SupplierQuote;
import ma.sir.ecom.ws.dto.SupplierQuoteDto;

@Component
public class SupplierQuoteConverter extends AbstractConverter<SupplierQuote, SupplierQuoteDto, SupplierQuoteHistory> {

    @Autowired
    private SupplierQuoteItemConverter supplierQuoteItemConverter ;
    @Autowired
    private SupplierConverter supplierConverter ;
    @Autowired
    private ProductConverter productConverter ;
    private boolean supplier;
    private boolean supplierQuoteItems;

    public  SupplierQuoteConverter(){
        super(SupplierQuote.class, SupplierQuoteDto.class, SupplierQuoteHistory.class);
        init(true);
    }

    @Override
    public SupplierQuote toItem(SupplierQuoteDto dto) {
        if (dto == null) {
            return null;
        } else {
        SupplierQuote item = new SupplierQuote();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getQuoteDate()))
                item.setQuoteDate(DateUtil.stringEnToDate(dto.getQuoteDate()));
            if(StringUtil.isNotEmpty(dto.getTotal()))
                item.setTotal(dto.getTotal());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(this.supplier && dto.getSupplier()!=null)
                item.setSupplier(supplierConverter.toItem(dto.getSupplier())) ;


            if(this.supplierQuoteItems && ListUtil.isNotEmpty(dto.getSupplierQuoteItems()))
                item.setSupplierQuoteItems(supplierQuoteItemConverter.toItem(dto.getSupplierQuoteItems()));

        return item;
        }
    }

    @Override
    public SupplierQuoteDto toDto(SupplierQuote item) {
        if (item == null) {
            return null;
        } else {
            SupplierQuoteDto dto = new SupplierQuoteDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getQuoteDate()!=null)
                dto.setQuoteDate(DateUtil.dateTimeToString(item.getQuoteDate()));
            if(StringUtil.isNotEmpty(item.getTotal()))
                dto.setTotal(item.getTotal());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.supplier && item.getSupplier()!=null) {
            dto.setSupplier(supplierConverter.toDto(item.getSupplier())) ;
        }
        if(this.supplierQuoteItems && ListUtil.isNotEmpty(item.getSupplierQuoteItems())){
            supplierQuoteItemConverter.init(true);
            supplierQuoteItemConverter.setSupplierQuote(false);
            dto.setSupplierQuoteItems(supplierQuoteItemConverter.toDto(item.getSupplierQuoteItems()));
            supplierQuoteItemConverter.setSupplierQuote(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.supplierQuoteItems = value;
    }

    public void initObject(boolean value) {
        this.supplier = value;
    }


    public SupplierQuoteItemConverter getSupplierQuoteItemConverter(){
        return this.supplierQuoteItemConverter;
    }
    public void setSupplierQuoteItemConverter(SupplierQuoteItemConverter supplierQuoteItemConverter ){
        this.supplierQuoteItemConverter = supplierQuoteItemConverter;
    }
    public SupplierConverter getSupplierConverter(){
        return this.supplierConverter;
    }
    public void setSupplierConverter(SupplierConverter supplierConverter ){
        this.supplierConverter = supplierConverter;
    }
    public ProductConverter getProductConverter(){
        return this.productConverter;
    }
    public void setProductConverter(ProductConverter productConverter ){
        this.productConverter = productConverter;
    }
    public boolean  isSupplier(){
        return this.supplier;
    }
    public void  setSupplier(boolean supplier){
        this.supplier = supplier;
    }
    public boolean  isSupplierQuoteItems(){
        return this.supplierQuoteItems ;
    }
    public void  setSupplierQuoteItems(boolean supplierQuoteItems ){
        this.supplierQuoteItems  = supplierQuoteItems ;
    }
}
