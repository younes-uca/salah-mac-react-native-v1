package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.ecom.zynerator.util.ListUtil;

import ma.sir.ecom.bean.core.Purchase;

import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.CreditNotePurchaseHistory;
import ma.sir.ecom.bean.core.CreditNotePurchase;
import ma.sir.ecom.ws.dto.CreditNotePurchaseDto;

@Component
public class CreditNotePurchaseConverter extends AbstractConverter<CreditNotePurchase, CreditNotePurchaseDto, CreditNotePurchaseHistory> {

    @Autowired
    private CreditNotePurchaseStatusConverter creditNotePurchaseStatusConverter ;
    @Autowired
    private PurchaseConverter purchaseConverter ;
    @Autowired
    private CreditNotePurchaseItemConverter creditNotePurchaseItemConverter ;
    @Autowired
    private ProductConverter productConverter ;
    private boolean purchase;
    private boolean creditNotePurchaseStatus;
    private boolean creditNotePurchaseItems;

    public  CreditNotePurchaseConverter(){
        super(CreditNotePurchase.class, CreditNotePurchaseDto.class, CreditNotePurchaseHistory.class);
        init(true);
    }

    @Override
    public CreditNotePurchase toItem(CreditNotePurchaseDto dto) {
        if (dto == null) {
            return null;
        } else {
        CreditNotePurchase item = new CreditNotePurchase();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCreditNoteDate()))
                item.setCreditNoteDate(DateUtil.stringEnToDate(dto.getCreditNoteDate()));
            if(StringUtil.isNotEmpty(dto.getAmount()))
                item.setAmount(dto.getAmount());
            if(dto.getPurchase() != null && dto.getPurchase().getId() != null){
                item.setPurchase(new Purchase());
                item.getPurchase().setId(dto.getPurchase().getId());
            }

            if(this.creditNotePurchaseStatus && dto.getCreditNotePurchaseStatus()!=null)
                item.setCreditNotePurchaseStatus(creditNotePurchaseStatusConverter.toItem(dto.getCreditNotePurchaseStatus())) ;


            if(this.creditNotePurchaseItems && ListUtil.isNotEmpty(dto.getCreditNotePurchaseItems()))
                item.setCreditNotePurchaseItems(creditNotePurchaseItemConverter.toItem(dto.getCreditNotePurchaseItems()));

        return item;
        }
    }

    @Override
    public CreditNotePurchaseDto toDto(CreditNotePurchase item) {
        if (item == null) {
            return null;
        } else {
            CreditNotePurchaseDto dto = new CreditNotePurchaseDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getCreditNoteDate()!=null)
                dto.setCreditNoteDate(DateUtil.dateTimeToString(item.getCreditNoteDate()));
            if(StringUtil.isNotEmpty(item.getAmount()))
                dto.setAmount(item.getAmount());
        if(this.purchase && item.getPurchase()!=null) {
            dto.setPurchase(purchaseConverter.toDto(item.getPurchase())) ;
        }
        if(this.creditNotePurchaseStatus && item.getCreditNotePurchaseStatus()!=null) {
            dto.setCreditNotePurchaseStatus(creditNotePurchaseStatusConverter.toDto(item.getCreditNotePurchaseStatus())) ;
        }
        if(this.creditNotePurchaseItems && ListUtil.isNotEmpty(item.getCreditNotePurchaseItems())){
            creditNotePurchaseItemConverter.init(true);
            creditNotePurchaseItemConverter.setCreditNotePurchase(false);
            dto.setCreditNotePurchaseItems(creditNotePurchaseItemConverter.toDto(item.getCreditNotePurchaseItems()));
            creditNotePurchaseItemConverter.setCreditNotePurchase(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.creditNotePurchaseItems = value;
    }

    public void initObject(boolean value) {
        this.purchase = value;
        this.creditNotePurchaseStatus = value;
    }


    public CreditNotePurchaseStatusConverter getCreditNotePurchaseStatusConverter(){
        return this.creditNotePurchaseStatusConverter;
    }
    public void setCreditNotePurchaseStatusConverter(CreditNotePurchaseStatusConverter creditNotePurchaseStatusConverter ){
        this.creditNotePurchaseStatusConverter = creditNotePurchaseStatusConverter;
    }
    public PurchaseConverter getPurchaseConverter(){
        return this.purchaseConverter;
    }
    public void setPurchaseConverter(PurchaseConverter purchaseConverter ){
        this.purchaseConverter = purchaseConverter;
    }
    public CreditNotePurchaseItemConverter getCreditNotePurchaseItemConverter(){
        return this.creditNotePurchaseItemConverter;
    }
    public void setCreditNotePurchaseItemConverter(CreditNotePurchaseItemConverter creditNotePurchaseItemConverter ){
        this.creditNotePurchaseItemConverter = creditNotePurchaseItemConverter;
    }
    public ProductConverter getProductConverter(){
        return this.productConverter;
    }
    public void setProductConverter(ProductConverter productConverter ){
        this.productConverter = productConverter;
    }
    public boolean  isPurchase(){
        return this.purchase;
    }
    public void  setPurchase(boolean purchase){
        this.purchase = purchase;
    }
    public boolean  isCreditNotePurchaseStatus(){
        return this.creditNotePurchaseStatus;
    }
    public void  setCreditNotePurchaseStatus(boolean creditNotePurchaseStatus){
        this.creditNotePurchaseStatus = creditNotePurchaseStatus;
    }
    public boolean  isCreditNotePurchaseItems(){
        return this.creditNotePurchaseItems ;
    }
    public void  setCreditNotePurchaseItems(boolean creditNotePurchaseItems ){
        this.creditNotePurchaseItems  = creditNotePurchaseItems ;
    }
}
