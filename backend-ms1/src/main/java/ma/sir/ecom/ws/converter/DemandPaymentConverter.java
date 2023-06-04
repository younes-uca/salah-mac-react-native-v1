package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.ecom.bean.core.Demand;

import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.DemandPaymentHistory;
import ma.sir.ecom.bean.core.DemandPayment;
import ma.sir.ecom.ws.dto.DemandPaymentDto;

@Component
public class DemandPaymentConverter extends AbstractConverter<DemandPayment, DemandPaymentDto, DemandPaymentHistory> {

    @Autowired
    private StatusPaymentDemandConverter statusPaymentDemandConverter ;
    @Autowired
    private PaymentModeConverter paymentModeConverter ;
    @Autowired
    private DemandConverter demandConverter ;
    private boolean demand;
    private boolean paymentMode;
    private boolean statusPaymentDemand;

    public  DemandPaymentConverter(){
        super(DemandPayment.class, DemandPaymentDto.class, DemandPaymentHistory.class);
    }

    @Override
    public DemandPayment toItem(DemandPaymentDto dto) {
        if (dto == null) {
            return null;
        } else {
        DemandPayment item = new DemandPayment();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getPaymentDate()))
                item.setPaymentDate(DateUtil.stringEnToDate(dto.getPaymentDate()));
            if(StringUtil.isNotEmpty(dto.getAmount()))
                item.setAmount(dto.getAmount());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(dto.getVireCheck() != null)
                item.setVireCheck(dto.getVireCheck());
            if(dto.getDemand() != null && dto.getDemand().getId() != null){
                item.setDemand(new Demand());
                item.getDemand().setId(dto.getDemand().getId());
            }

            if(this.paymentMode && dto.getPaymentMode()!=null)
                item.setPaymentMode(paymentModeConverter.toItem(dto.getPaymentMode())) ;

            if(this.statusPaymentDemand && dto.getStatusPaymentDemand()!=null)
                item.setStatusPaymentDemand(statusPaymentDemandConverter.toItem(dto.getStatusPaymentDemand())) ;



        return item;
        }
    }

    @Override
    public DemandPaymentDto toDto(DemandPayment item) {
        if (item == null) {
            return null;
        } else {
            DemandPaymentDto dto = new DemandPaymentDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getPaymentDate()!=null)
                dto.setPaymentDate(DateUtil.dateTimeToString(item.getPaymentDate()));
            if(StringUtil.isNotEmpty(item.getAmount()))
                dto.setAmount(item.getAmount());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
                dto.setVireCheck(item.getVireCheck());
        if(this.demand && item.getDemand()!=null) {
            dto.setDemand(demandConverter.toDto(item.getDemand())) ;
        }
        if(this.paymentMode && item.getPaymentMode()!=null) {
            dto.setPaymentMode(paymentModeConverter.toDto(item.getPaymentMode())) ;
        }
        if(this.statusPaymentDemand && item.getStatusPaymentDemand()!=null) {
            dto.setStatusPaymentDemand(statusPaymentDemandConverter.toDto(item.getStatusPaymentDemand())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.demand = value;
        this.paymentMode = value;
        this.statusPaymentDemand = value;
    }


    public StatusPaymentDemandConverter getStatusPaymentDemandConverter(){
        return this.statusPaymentDemandConverter;
    }
    public void setStatusPaymentDemandConverter(StatusPaymentDemandConverter statusPaymentDemandConverter ){
        this.statusPaymentDemandConverter = statusPaymentDemandConverter;
    }
    public PaymentModeConverter getPaymentModeConverter(){
        return this.paymentModeConverter;
    }
    public void setPaymentModeConverter(PaymentModeConverter paymentModeConverter ){
        this.paymentModeConverter = paymentModeConverter;
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
    public boolean  isPaymentMode(){
        return this.paymentMode;
    }
    public void  setPaymentMode(boolean paymentMode){
        this.paymentMode = paymentMode;
    }
    public boolean  isStatusPaymentDemand(){
        return this.statusPaymentDemand;
    }
    public void  setStatusPaymentDemand(boolean statusPaymentDemand){
        this.statusPaymentDemand = statusPaymentDemand;
    }
}
