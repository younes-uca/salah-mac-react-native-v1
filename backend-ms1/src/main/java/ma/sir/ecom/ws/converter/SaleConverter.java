package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.ecom.zynerator.util.ListUtil;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.SaleHistory;
import ma.sir.ecom.bean.core.Sale;
import ma.sir.ecom.ws.dto.SaleDto;

@Component
public class SaleConverter extends AbstractConverter<Sale, SaleDto, SaleHistory> {

    @Autowired
    private StoreConverter storeConverter ;
    @Autowired
    private SaleItemConverter saleItemConverter ;
    @Autowired
    private ClientConverter clientConverter ;
    @Autowired
    private ProductConverter productConverter ;
    @Autowired
    private SaleStatusConverter saleStatusConverter ;
    private boolean store;
    private boolean client;
    private boolean saleStatus;
    private boolean saleItems;

    public  SaleConverter(){
        super(Sale.class, SaleDto.class, SaleHistory.class);
        init(true);
    }

    @Override
    public Sale toItem(SaleDto dto) {
        if (dto == null) {
            return null;
        } else {
        Sale item = new Sale();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getSaleDate()))
                item.setSaleDate(DateUtil.stringEnToDate(dto.getSaleDate()));
            if(StringUtil.isNotEmpty(dto.getTotal()))
                item.setTotal(dto.getTotal());
            if(StringUtil.isNotEmpty(dto.getTotalPaid()))
                item.setTotalPaid(dto.getTotalPaid());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(this.store && dto.getStore()!=null)
                item.setStore(storeConverter.toItem(dto.getStore())) ;

            if(this.client && dto.getClient()!=null)
                item.setClient(clientConverter.toItem(dto.getClient())) ;

            if(this.saleStatus && dto.getSaleStatus()!=null)
                item.setSaleStatus(saleStatusConverter.toItem(dto.getSaleStatus())) ;


            if(this.saleItems && ListUtil.isNotEmpty(dto.getSaleItems()))
                item.setSaleItems(saleItemConverter.toItem(dto.getSaleItems()));

        return item;
        }
    }

    @Override
    public SaleDto toDto(Sale item) {
        if (item == null) {
            return null;
        } else {
            SaleDto dto = new SaleDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getSaleDate()!=null)
                dto.setSaleDate(DateUtil.dateTimeToString(item.getSaleDate()));
            if(StringUtil.isNotEmpty(item.getTotal()))
                dto.setTotal(item.getTotal());
            if(StringUtil.isNotEmpty(item.getTotalPaid()))
                dto.setTotalPaid(item.getTotalPaid());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.store && item.getStore()!=null) {
            dto.setStore(storeConverter.toDto(item.getStore())) ;
        }
        if(this.client && item.getClient()!=null) {
            dto.setClient(clientConverter.toDto(item.getClient())) ;
        }
        if(this.saleStatus && item.getSaleStatus()!=null) {
            dto.setSaleStatus(saleStatusConverter.toDto(item.getSaleStatus())) ;
        }
        if(this.saleItems && ListUtil.isNotEmpty(item.getSaleItems())){
            saleItemConverter.init(true);
            saleItemConverter.setSale(false);
            dto.setSaleItems(saleItemConverter.toDto(item.getSaleItems()));
            saleItemConverter.setSale(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.saleItems = value;
    }

    public void initObject(boolean value) {
        this.store = value;
        this.client = value;
        this.saleStatus = value;
    }


    public StoreConverter getStoreConverter(){
        return this.storeConverter;
    }
    public void setStoreConverter(StoreConverter storeConverter ){
        this.storeConverter = storeConverter;
    }
    public SaleItemConverter getSaleItemConverter(){
        return this.saleItemConverter;
    }
    public void setSaleItemConverter(SaleItemConverter saleItemConverter ){
        this.saleItemConverter = saleItemConverter;
    }
    public ClientConverter getClientConverter(){
        return this.clientConverter;
    }
    public void setClientConverter(ClientConverter clientConverter ){
        this.clientConverter = clientConverter;
    }
    public ProductConverter getProductConverter(){
        return this.productConverter;
    }
    public void setProductConverter(ProductConverter productConverter ){
        this.productConverter = productConverter;
    }
    public SaleStatusConverter getSaleStatusConverter(){
        return this.saleStatusConverter;
    }
    public void setSaleStatusConverter(SaleStatusConverter saleStatusConverter ){
        this.saleStatusConverter = saleStatusConverter;
    }
    public boolean  isStore(){
        return this.store;
    }
    public void  setStore(boolean store){
        this.store = store;
    }
    public boolean  isClient(){
        return this.client;
    }
    public void  setClient(boolean client){
        this.client = client;
    }
    public boolean  isSaleStatus(){
        return this.saleStatus;
    }
    public void  setSaleStatus(boolean saleStatus){
        this.saleStatus = saleStatus;
    }
    public boolean  isSaleItems(){
        return this.saleItems ;
    }
    public void  setSaleItems(boolean saleItems ){
        this.saleItems  = saleItems ;
    }
}
