package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.ecom.zynerator.util.ListUtil;

import ma.sir.ecom.bean.core.Demand;

import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.DeliveryHistory;
import ma.sir.ecom.bean.core.Delivery;
import ma.sir.ecom.ws.dto.DeliveryDto;

@Component
public class DeliveryConverter extends AbstractConverter<Delivery, DeliveryDto, DeliveryHistory> {

    @Autowired
    private StoreConverter storeConverter ;
    @Autowired
    private DeliveryStatusConverter deliveryStatusConverter ;
    @Autowired
    private ClientConverter clientConverter ;
    @Autowired
    private ProductConverter productConverter ;
    @Autowired
    private DeliveryItemConverter deliveryItemConverter ;
    @Autowired
    private DemandConverter demandConverter ;
    private boolean demand;
    private boolean deliveryStatus;
    private boolean client;
    private boolean deliveryItems;

    public  DeliveryConverter(){
        super(Delivery.class, DeliveryDto.class, DeliveryHistory.class);
        init(true);
    }

    @Override
    public Delivery toItem(DeliveryDto dto) {
        if (dto == null) {
            return null;
        } else {
        Delivery item = new Delivery();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDeliveryDate()))
                item.setDeliveryDate(DateUtil.stringEnToDate(dto.getDeliveryDate()));
            if(dto.getDemand() != null && dto.getDemand().getId() != null){
                item.setDemand(new Demand());
                item.getDemand().setId(dto.getDemand().getId());
            }

            if(this.deliveryStatus && dto.getDeliveryStatus()!=null)
                item.setDeliveryStatus(deliveryStatusConverter.toItem(dto.getDeliveryStatus())) ;

            if(this.client && dto.getClient()!=null)
                item.setClient(clientConverter.toItem(dto.getClient())) ;


            if(this.deliveryItems && ListUtil.isNotEmpty(dto.getDeliveryItems()))
                item.setDeliveryItems(deliveryItemConverter.toItem(dto.getDeliveryItems()));

        return item;
        }
    }

    @Override
    public DeliveryDto toDto(Delivery item) {
        if (item == null) {
            return null;
        } else {
            DeliveryDto dto = new DeliveryDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDeliveryDate()!=null)
                dto.setDeliveryDate(DateUtil.dateTimeToString(item.getDeliveryDate()));
        if(this.demand && item.getDemand()!=null) {
            dto.setDemand(demandConverter.toDto(item.getDemand())) ;
        }
        if(this.deliveryStatus && item.getDeliveryStatus()!=null) {
            dto.setDeliveryStatus(deliveryStatusConverter.toDto(item.getDeliveryStatus())) ;
        }
        if(this.client && item.getClient()!=null) {
            dto.setClient(clientConverter.toDto(item.getClient())) ;
        }
        if(this.deliveryItems && ListUtil.isNotEmpty(item.getDeliveryItems())){
            deliveryItemConverter.init(true);
            deliveryItemConverter.setDelivery(false);
            dto.setDeliveryItems(deliveryItemConverter.toDto(item.getDeliveryItems()));
            deliveryItemConverter.setDelivery(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.deliveryItems = value;
    }

    public void initObject(boolean value) {
        this.demand = value;
        this.deliveryStatus = value;
        this.client = value;
    }


    public StoreConverter getStoreConverter(){
        return this.storeConverter;
    }
    public void setStoreConverter(StoreConverter storeConverter ){
        this.storeConverter = storeConverter;
    }
    public DeliveryStatusConverter getDeliveryStatusConverter(){
        return this.deliveryStatusConverter;
    }
    public void setDeliveryStatusConverter(DeliveryStatusConverter deliveryStatusConverter ){
        this.deliveryStatusConverter = deliveryStatusConverter;
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
    public DeliveryItemConverter getDeliveryItemConverter(){
        return this.deliveryItemConverter;
    }
    public void setDeliveryItemConverter(DeliveryItemConverter deliveryItemConverter ){
        this.deliveryItemConverter = deliveryItemConverter;
    }
    public DemandConverter getDemandConverter(){
        return this.demandConverter;
    }
    public void setDemandConverter(DemandConverter demandConverter ){
        this.demandConverter = demandConverter;
    }
    public boolean  isDemand(){
        return this.demand;
    }
    public void  setDemand(boolean demand){
        this.demand = demand;
    }
    public boolean  isDeliveryStatus(){
        return this.deliveryStatus;
    }
    public void  setDeliveryStatus(boolean deliveryStatus){
        this.deliveryStatus = deliveryStatus;
    }
    public boolean  isClient(){
        return this.client;
    }
    public void  setClient(boolean client){
        this.client = client;
    }
    public boolean  isDeliveryItems(){
        return this.deliveryItems ;
    }
    public void  setDeliveryItems(boolean deliveryItems ){
        this.deliveryItems  = deliveryItems ;
    }
}
