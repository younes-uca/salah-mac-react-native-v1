package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.BankCheckOwner;
import ma.sir.ecom.dao.criteria.core.BankCheckOwnerCriteria;
import ma.sir.ecom.dao.criteria.history.BankCheckOwnerHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.BankCheckOwnerDto;
import org.springframework.http.HttpEntity;

public interface BankCheckOwnerAdminService extends  IService<BankCheckOwner,BankCheckOwnerCriteria, BankCheckOwnerHistoryCriteria>  {

    List<BankCheckOwner> findByCheckOwnerId(Long id);
    int deleteByCheckOwnerId(Long id);
    List<BankCheckOwner> findByBankId(Long id);
    int deleteByBankId(Long id);

    HttpEntity<byte[]> createPdf(BankCheckOwnerDto dto) throws Exception;


}
