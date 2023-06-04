package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.ecom.bean.core.Demand;

import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.DemandItemHistory;
import ma.sir.ecom.bean.core.DemandItem;
import ma.sir.ecom.ws.dto.DemandItemDto;

@Component
public class DemandItemConverter extends AbstractConverter<DemandItem, DemandItemDto, DemandItemHistory> {

    @Autowired
    private ProductConverter productConverter ;
    @Autowired
    private DemandConverter demandConverter ;
    private boolean product;
    private boolean demand;

    public  DemandItemConverter(){
        super(DemandItem.class, DemandItemDto.class, DemandItemHistory.class);
    }

    @Override
    public DemandItem toItem(DemandItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        DemandItem item = new DemandItem();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getPrice()))
                item.setPrice(dto.getPrice());
            if(StringUtil.isNotEmpty(dto.getQuantity()))
                item.setQuantity(dto.getQuantity());
            if(StringUtil.isNotEmpty(dto.getPoundQuantity()))
                item.setPoundQuantity(dto.getPoundQuantity());
            if(this.product && dto.getProduct()!=null)
                item.setProduct(productConverter.toItem(dto.getProduct())) ;

            if(dto.getDemand() != null && dto.getDemand().getId() != null){
                item.setDemand(new Demand());
                item.getDemand().setId(dto.getDemand().getId());
            }



        return item;
        }
    }

    @Override
    public DemandItemDto toDto(DemandItem item) {
        if (item == null) {
            return null;
        } else {
            DemandItemDto dto = new DemandItemDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getPrice()))
                dto.setPrice(item.getPrice());
            if(StringUtil.isNotEmpty(item.getQuantity()))
                dto.setQuantity(item.getQuantity());
            if(StringUtil.isNotEmpty(item.getPoundQuantity()))
                dto.setPoundQuantity(item.getPoundQuantity());
        if(this.product && item.getProduct()!=null) {
            dto.setProduct(productConverter.toDto(item.getProduct())) ;
        }
        if(this.demand && item.getDemand()!=null) {
            dto.setDemand(demandConverter.toDto(item.getDemand())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.product = value;
        this.demand = value;
    }


    public ProductConverter getProductConverter(){
        return this.productConverter;
    }
    public void setProductConverter(ProductConverter productConverter ){
        this.productConverter = productConverter;
    }
    public DemandConverter getDemandConverter(){
        return this.demandConverter;
    }
    public void setDemandConverter(DemandConverter demandConverter ){
        this.demandConverter = demandConverter;
    }
    public boolean  isProduct(){
        return this.product;
    }
    public void  setProduct(boolean product){
        this.product = product;
    }
    public boolean  isDemand(){
        return this.demand;
    }
    public void  setDemand(boolean demand){
        this.demand = demand;
    }
}
