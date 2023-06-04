package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.ecom.zynerator.util.ListUtil;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.DemandHistory;
import ma.sir.ecom.bean.core.Demand;
import ma.sir.ecom.ws.dto.DemandDto;

@Component
public class DemandConverter extends AbstractConverter<Demand, DemandDto, DemandHistory> {

    @Autowired
    private ClientConverter clientConverter ;
    @Autowired
    private DemandStatusConverter demandStatusConverter ;
    @Autowired
    private ProductConverter productConverter ;
    @Autowired
    private DemandItemConverter demandItemConverter ;
    private boolean client;
    private boolean demandStatus;
    private boolean demandItems;

    public  DemandConverter(){
        super(Demand.class, DemandDto.class, DemandHistory.class);
        init(true);
    }

    @Override
    public Demand toItem(DemandDto dto) {
        if (dto == null) {
            return null;
        } else {
        Demand item = new Demand();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getDemandDate()))
                item.setDemandDate(DateUtil.stringEnToDate(dto.getDemandDate()));
            if(StringUtil.isNotEmpty(dto.getTotalCheck()))
                item.setTotalCheck(dto.getTotalCheck());
            if(StringUtil.isNotEmpty(dto.getTotalCash()))
                item.setTotalCash(dto.getTotalCash());
            if(StringUtil.isNotEmpty(dto.getTotal()))
                item.setTotal(dto.getTotal());
            if(StringUtil.isNotEmpty(dto.getTotalPaid()))
                item.setTotalPaid(dto.getTotalPaid());
            if(this.client && dto.getClient()!=null)
                item.setClient(clientConverter.toItem(dto.getClient())) ;

            if(this.demandStatus && dto.getDemandStatus()!=null)
                item.setDemandStatus(demandStatusConverter.toItem(dto.getDemandStatus())) ;


            if(this.demandItems && ListUtil.isNotEmpty(dto.getDemandItems()))
                item.setDemandItems(demandItemConverter.toItem(dto.getDemandItems()));

        return item;
        }
    }

    @Override
    public DemandDto toDto(Demand item) {
        if (item == null) {
            return null;
        } else {
            DemandDto dto = new DemandDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getDemandDate()!=null)
                dto.setDemandDate(DateUtil.dateTimeToString(item.getDemandDate()));
            if(StringUtil.isNotEmpty(item.getTotalCheck()))
                dto.setTotalCheck(item.getTotalCheck());
            if(StringUtil.isNotEmpty(item.getTotalCash()))
                dto.setTotalCash(item.getTotalCash());
            if(StringUtil.isNotEmpty(item.getTotal()))
                dto.setTotal(item.getTotal());
            if(StringUtil.isNotEmpty(item.getTotalPaid()))
                dto.setTotalPaid(item.getTotalPaid());
        if(this.client && item.getClient()!=null) {
            dto.setClient(clientConverter.toDto(item.getClient())) ;
        }
        if(this.demandStatus && item.getDemandStatus()!=null) {
            dto.setDemandStatus(demandStatusConverter.toDto(item.getDemandStatus())) ;
        }
        if(this.demandItems && ListUtil.isNotEmpty(item.getDemandItems())){
            demandItemConverter.init(true);
            demandItemConverter.setDemand(false);
            dto.setDemandItems(demandItemConverter.toDto(item.getDemandItems()));
            demandItemConverter.setDemand(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.demandItems = value;
    }

    public void initObject(boolean value) {
        this.client = value;
        this.demandStatus = value;
    }


    public ClientConverter getClientConverter(){
        return this.clientConverter;
    }
    public void setClientConverter(ClientConverter clientConverter ){
        this.clientConverter = clientConverter;
    }
    public DemandStatusConverter getDemandStatusConverter(){
        return this.demandStatusConverter;
    }
    public void setDemandStatusConverter(DemandStatusConverter demandStatusConverter ){
        this.demandStatusConverter = demandStatusConverter;
    }
    public ProductConverter getProductConverter(){
        return this.productConverter;
    }
    public void setProductConverter(ProductConverter productConverter ){
        this.productConverter = productConverter;
    }
    public DemandItemConverter getDemandItemConverter(){
        return this.demandItemConverter;
    }
    public void setDemandItemConverter(DemandItemConverter demandItemConverter ){
        this.demandItemConverter = demandItemConverter;
    }
    public boolean  isClient(){
        return this.client;
    }
    public void  setClient(boolean client){
        this.client = client;
    }
    public boolean  isDemandStatus(){
        return this.demandStatus;
    }
    public void  setDemandStatus(boolean demandStatus){
        this.demandStatus = demandStatus;
    }
    public boolean  isDemandItems(){
        return this.demandItems ;
    }
    public void  setDemandItems(boolean demandItems ){
        this.demandItems  = demandItems ;
    }
}
