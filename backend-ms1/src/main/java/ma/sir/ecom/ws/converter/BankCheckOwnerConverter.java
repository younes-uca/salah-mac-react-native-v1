package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.BankCheckOwnerHistory;
import ma.sir.ecom.bean.core.BankCheckOwner;
import ma.sir.ecom.ws.dto.BankCheckOwnerDto;

@Component
public class BankCheckOwnerConverter extends AbstractConverter<BankCheckOwner, BankCheckOwnerDto, BankCheckOwnerHistory> {

    @Autowired
    private CheckOwnerConverter checkOwnerConverter ;
    @Autowired
    private BankConverter bankConverter ;
    private boolean checkOwner;
    private boolean bank;

    public  BankCheckOwnerConverter(){
        super(BankCheckOwner.class, BankCheckOwnerDto.class, BankCheckOwnerHistory.class);
    }

    @Override
    public BankCheckOwner toItem(BankCheckOwnerDto dto) {
        if (dto == null) {
            return null;
        } else {
        BankCheckOwner item = new BankCheckOwner();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(this.checkOwner && dto.getCheckOwner()!=null)
                item.setCheckOwner(checkOwnerConverter.toItem(dto.getCheckOwner())) ;

            if(this.bank && dto.getBank()!=null)
                item.setBank(bankConverter.toItem(dto.getBank())) ;



        return item;
        }
    }

    @Override
    public BankCheckOwnerDto toDto(BankCheckOwner item) {
        if (item == null) {
            return null;
        } else {
            BankCheckOwnerDto dto = new BankCheckOwnerDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
        if(this.checkOwner && item.getCheckOwner()!=null) {
            dto.setCheckOwner(checkOwnerConverter.toDto(item.getCheckOwner())) ;
        }
        if(this.bank && item.getBank()!=null) {
            dto.setBank(bankConverter.toDto(item.getBank())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.checkOwner = value;
        this.bank = value;
    }


    public CheckOwnerConverter getCheckOwnerConverter(){
        return this.checkOwnerConverter;
    }
    public void setCheckOwnerConverter(CheckOwnerConverter checkOwnerConverter ){
        this.checkOwnerConverter = checkOwnerConverter;
    }
    public BankConverter getBankConverter(){
        return this.bankConverter;
    }
    public void setBankConverter(BankConverter bankConverter ){
        this.bankConverter = bankConverter;
    }
    public boolean  isCheckOwner(){
        return this.checkOwner;
    }
    public void  setCheckOwner(boolean checkOwner){
        this.checkOwner = checkOwner;
    }
    public boolean  isBank(){
        return this.bank;
    }
    public void  setBank(boolean bank){
        this.bank = bank;
    }
}
