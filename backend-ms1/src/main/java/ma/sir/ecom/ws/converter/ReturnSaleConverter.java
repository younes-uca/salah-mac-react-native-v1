package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.ecom.zynerator.util.ListUtil;

import ma.sir.ecom.bean.core.Sale;

import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.ReturnSaleHistory;
import ma.sir.ecom.bean.core.ReturnSale;
import ma.sir.ecom.ws.dto.ReturnSaleDto;

@Component
public class ReturnSaleConverter extends AbstractConverter<ReturnSale, ReturnSaleDto, ReturnSaleHistory> {

    @Autowired
    private SaleConverter saleConverter ;
    @Autowired
    private ReturnSaleItemConverter returnSaleItemConverter ;
    @Autowired
    private ReturnStatusConverter returnStatusConverter ;
    @Autowired
    private ProductConverter productConverter ;
    private boolean sale;
    private boolean returnStatus;
    private boolean returnSaleItems;

    public  ReturnSaleConverter(){
        super(ReturnSale.class, ReturnSaleDto.class, ReturnSaleHistory.class);
        init(true);
    }

    @Override
    public ReturnSale toItem(ReturnSaleDto dto) {
        if (dto == null) {
            return null;
        } else {
        ReturnSale item = new ReturnSale();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReturnDate()))
                item.setReturnDate(DateUtil.stringEnToDate(dto.getReturnDate()));
            if(StringUtil.isNotEmpty(dto.getAmount()))
                item.setAmount(dto.getAmount());
            if(dto.getSale() != null && dto.getSale().getId() != null){
                item.setSale(new Sale());
                item.getSale().setId(dto.getSale().getId());
            }

            if(this.returnStatus && dto.getReturnStatus()!=null)
                item.setReturnStatus(returnStatusConverter.toItem(dto.getReturnStatus())) ;


            if(this.returnSaleItems && ListUtil.isNotEmpty(dto.getReturnSaleItems()))
                item.setReturnSaleItems(returnSaleItemConverter.toItem(dto.getReturnSaleItems()));

        return item;
        }
    }

    @Override
    public ReturnSaleDto toDto(ReturnSale item) {
        if (item == null) {
            return null;
        } else {
            ReturnSaleDto dto = new ReturnSaleDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getReturnDate()!=null)
                dto.setReturnDate(DateUtil.dateTimeToString(item.getReturnDate()));
            if(StringUtil.isNotEmpty(item.getAmount()))
                dto.setAmount(item.getAmount());
        if(this.sale && item.getSale()!=null) {
            dto.setSale(saleConverter.toDto(item.getSale())) ;
        }
        if(this.returnStatus && item.getReturnStatus()!=null) {
            dto.setReturnStatus(returnStatusConverter.toDto(item.getReturnStatus())) ;
        }
        if(this.returnSaleItems && ListUtil.isNotEmpty(item.getReturnSaleItems())){
            returnSaleItemConverter.init(true);
            returnSaleItemConverter.setReturnSale(false);
            dto.setReturnSaleItems(returnSaleItemConverter.toDto(item.getReturnSaleItems()));
            returnSaleItemConverter.setReturnSale(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.returnSaleItems = value;
    }

    public void initObject(boolean value) {
        this.sale = value;
        this.returnStatus = value;
    }


    public SaleConverter getSaleConverter(){
        return this.saleConverter;
    }
    public void setSaleConverter(SaleConverter saleConverter ){
        this.saleConverter = saleConverter;
    }
    public ReturnSaleItemConverter getReturnSaleItemConverter(){
        return this.returnSaleItemConverter;
    }
    public void setReturnSaleItemConverter(ReturnSaleItemConverter returnSaleItemConverter ){
        this.returnSaleItemConverter = returnSaleItemConverter;
    }
    public ReturnStatusConverter getReturnStatusConverter(){
        return this.returnStatusConverter;
    }
    public void setReturnStatusConverter(ReturnStatusConverter returnStatusConverter ){
        this.returnStatusConverter = returnStatusConverter;
    }
    public ProductConverter getProductConverter(){
        return this.productConverter;
    }
    public void setProductConverter(ProductConverter productConverter ){
        this.productConverter = productConverter;
    }
    public boolean  isSale(){
        return this.sale;
    }
    public void  setSale(boolean sale){
        this.sale = sale;
    }
    public boolean  isReturnStatus(){
        return this.returnStatus;
    }
    public void  setReturnStatus(boolean returnStatus){
        this.returnStatus = returnStatus;
    }
    public boolean  isReturnSaleItems(){
        return this.returnSaleItems ;
    }
    public void  setReturnSaleItems(boolean returnSaleItems ){
        this.returnSaleItems  = returnSaleItems ;
    }
}
