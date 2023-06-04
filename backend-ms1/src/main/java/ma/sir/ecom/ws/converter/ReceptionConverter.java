package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.ecom.zynerator.util.ListUtil;

import ma.sir.ecom.bean.core.Order;

import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.ReceptionHistory;
import ma.sir.ecom.bean.core.Reception;
import ma.sir.ecom.ws.dto.ReceptionDto;

@Component
public class ReceptionConverter extends AbstractConverter<Reception, ReceptionDto, ReceptionHistory> {

    @Autowired
    private ReceptionStatusConverter receptionStatusConverter ;
    @Autowired
    private StoreConverter storeConverter ;
    @Autowired
    private OrderConverter orderConverter ;
    @Autowired
    private ProductConverter productConverter ;
    @Autowired
    private ReceptionItemConverter receptionItemConverter ;
    private boolean order;
    private boolean receptionStatus;
    private boolean receptionItems;

    public  ReceptionConverter(){
        super(Reception.class, ReceptionDto.class, ReceptionHistory.class);
        init(true);
    }

    @Override
    public Reception toItem(ReceptionDto dto) {
        if (dto == null) {
            return null;
        } else {
        Reception item = new Reception();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getReceptionDate()))
                item.setReceptionDate(DateUtil.stringEnToDate(dto.getReceptionDate()));
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(dto.getOrder() != null && dto.getOrder().getId() != null){
                item.setOrder(new Order());
                item.getOrder().setId(dto.getOrder().getId());
            }

            if(this.receptionStatus && dto.getReceptionStatus()!=null)
                item.setReceptionStatus(receptionStatusConverter.toItem(dto.getReceptionStatus())) ;


            if(this.receptionItems && ListUtil.isNotEmpty(dto.getReceptionItems()))
                item.setReceptionItems(receptionItemConverter.toItem(dto.getReceptionItems()));

        return item;
        }
    }

    @Override
    public ReceptionDto toDto(Reception item) {
        if (item == null) {
            return null;
        } else {
            ReceptionDto dto = new ReceptionDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getReceptionDate()!=null)
                dto.setReceptionDate(DateUtil.dateTimeToString(item.getReceptionDate()));
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.order && item.getOrder()!=null) {
            dto.setOrder(orderConverter.toDto(item.getOrder())) ;
        }
        if(this.receptionStatus && item.getReceptionStatus()!=null) {
            dto.setReceptionStatus(receptionStatusConverter.toDto(item.getReceptionStatus())) ;
        }
        if(this.receptionItems && ListUtil.isNotEmpty(item.getReceptionItems())){
            receptionItemConverter.init(true);
            receptionItemConverter.setReception(false);
            dto.setReceptionItems(receptionItemConverter.toDto(item.getReceptionItems()));
            receptionItemConverter.setReception(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.receptionItems = value;
    }

    public void initObject(boolean value) {
        this.order = value;
        this.receptionStatus = value;
    }


    public ReceptionStatusConverter getReceptionStatusConverter(){
        return this.receptionStatusConverter;
    }
    public void setReceptionStatusConverter(ReceptionStatusConverter receptionStatusConverter ){
        this.receptionStatusConverter = receptionStatusConverter;
    }
    public StoreConverter getStoreConverter(){
        return this.storeConverter;
    }
    public void setStoreConverter(StoreConverter storeConverter ){
        this.storeConverter = storeConverter;
    }
    public OrderConverter getOrderConverter(){
        return this.orderConverter;
    }
    public void setOrderConverter(OrderConverter orderConverter ){
        this.orderConverter = orderConverter;
    }
    public ProductConverter getProductConverter(){
        return this.productConverter;
    }
    public void setProductConverter(ProductConverter productConverter ){
        this.productConverter = productConverter;
    }
    public ReceptionItemConverter getReceptionItemConverter(){
        return this.receptionItemConverter;
    }
    public void setReceptionItemConverter(ReceptionItemConverter receptionItemConverter ){
        this.receptionItemConverter = receptionItemConverter;
    }
    public boolean  isOrder(){
        return this.order;
    }
    public void  setOrder(boolean order){
        this.order = order;
    }
    public boolean  isReceptionStatus(){
        return this.receptionStatus;
    }
    public void  setReceptionStatus(boolean receptionStatus){
        this.receptionStatus = receptionStatus;
    }
    public boolean  isReceptionItems(){
        return this.receptionItems ;
    }
    public void  setReceptionItems(boolean receptionItems ){
        this.receptionItems  = receptionItems ;
    }
}
