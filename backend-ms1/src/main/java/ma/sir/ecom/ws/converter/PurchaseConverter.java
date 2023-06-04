package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.ecom.zynerator.util.ListUtil;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.PurchaseHistory;
import ma.sir.ecom.bean.core.Purchase;
import ma.sir.ecom.ws.dto.PurchaseDto;

@Component
public class PurchaseConverter extends AbstractConverter<Purchase, PurchaseDto, PurchaseHistory> {

    @Autowired
    private StoreConverter storeConverter ;
    @Autowired
    private SupplierConverter supplierConverter ;
    @Autowired
    private PurchaseItemConverter purchaseItemConverter ;
    @Autowired
    private ProductConverter productConverter ;
    @Autowired
    private PurchaseStatusConverter purchaseStatusConverter ;
    private boolean supplier;
    private boolean store;
    private boolean purchaseStatus;
    private boolean purchaseItems;

    public  PurchaseConverter(){
        super(Purchase.class, PurchaseDto.class, PurchaseHistory.class);
        init(true);
    }

    @Override
    public Purchase toItem(PurchaseDto dto) {
        if (dto == null) {
            return null;
        } else {
        Purchase item = new Purchase();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getPurchaseDate()))
                item.setPurchaseDate(DateUtil.stringEnToDate(dto.getPurchaseDate()));
            if(StringUtil.isNotEmpty(dto.getTotal()))
                item.setTotal(dto.getTotal());
            if(StringUtil.isNotEmpty(dto.getTotalPaid()))
                item.setTotalPaid(dto.getTotalPaid());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(this.supplier && dto.getSupplier()!=null)
                item.setSupplier(supplierConverter.toItem(dto.getSupplier())) ;

            if(this.store && dto.getStore()!=null)
                item.setStore(storeConverter.toItem(dto.getStore())) ;

            if(this.purchaseStatus && dto.getPurchaseStatus()!=null)
                item.setPurchaseStatus(purchaseStatusConverter.toItem(dto.getPurchaseStatus())) ;


            if(this.purchaseItems && ListUtil.isNotEmpty(dto.getPurchaseItems()))
                item.setPurchaseItems(purchaseItemConverter.toItem(dto.getPurchaseItems()));

        return item;
        }
    }

    @Override
    public PurchaseDto toDto(Purchase item) {
        if (item == null) {
            return null;
        } else {
            PurchaseDto dto = new PurchaseDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getPurchaseDate()!=null)
                dto.setPurchaseDate(DateUtil.dateTimeToString(item.getPurchaseDate()));
            if(StringUtil.isNotEmpty(item.getTotal()))
                dto.setTotal(item.getTotal());
            if(StringUtil.isNotEmpty(item.getTotalPaid()))
                dto.setTotalPaid(item.getTotalPaid());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.supplier && item.getSupplier()!=null) {
            dto.setSupplier(supplierConverter.toDto(item.getSupplier())) ;
        }
        if(this.store && item.getStore()!=null) {
            dto.setStore(storeConverter.toDto(item.getStore())) ;
        }
        if(this.purchaseStatus && item.getPurchaseStatus()!=null) {
            dto.setPurchaseStatus(purchaseStatusConverter.toDto(item.getPurchaseStatus())) ;
        }
        if(this.purchaseItems && ListUtil.isNotEmpty(item.getPurchaseItems())){
            purchaseItemConverter.init(true);
            purchaseItemConverter.setPurchase(false);
            dto.setPurchaseItems(purchaseItemConverter.toDto(item.getPurchaseItems()));
            purchaseItemConverter.setPurchase(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.purchaseItems = value;
    }

    public void initObject(boolean value) {
        this.supplier = value;
        this.store = value;
        this.purchaseStatus = value;
    }


    public StoreConverter getStoreConverter(){
        return this.storeConverter;
    }
    public void setStoreConverter(StoreConverter storeConverter ){
        this.storeConverter = storeConverter;
    }
    public SupplierConverter getSupplierConverter(){
        return this.supplierConverter;
    }
    public void setSupplierConverter(SupplierConverter supplierConverter ){
        this.supplierConverter = supplierConverter;
    }
    public PurchaseItemConverter getPurchaseItemConverter(){
        return this.purchaseItemConverter;
    }
    public void setPurchaseItemConverter(PurchaseItemConverter purchaseItemConverter ){
        this.purchaseItemConverter = purchaseItemConverter;
    }
    public ProductConverter getProductConverter(){
        return this.productConverter;
    }
    public void setProductConverter(ProductConverter productConverter ){
        this.productConverter = productConverter;
    }
    public PurchaseStatusConverter getPurchaseStatusConverter(){
        return this.purchaseStatusConverter;
    }
    public void setPurchaseStatusConverter(PurchaseStatusConverter purchaseStatusConverter ){
        this.purchaseStatusConverter = purchaseStatusConverter;
    }
    public boolean  isSupplier(){
        return this.supplier;
    }
    public void  setSupplier(boolean supplier){
        this.supplier = supplier;
    }
    public boolean  isStore(){
        return this.store;
    }
    public void  setStore(boolean store){
        this.store = store;
    }
    public boolean  isPurchaseStatus(){
        return this.purchaseStatus;
    }
    public void  setPurchaseStatus(boolean purchaseStatus){
        this.purchaseStatus = purchaseStatus;
    }
    public boolean  isPurchaseItems(){
        return this.purchaseItems ;
    }
    public void  setPurchaseItems(boolean purchaseItems ){
        this.purchaseItems  = purchaseItems ;
    }
}
