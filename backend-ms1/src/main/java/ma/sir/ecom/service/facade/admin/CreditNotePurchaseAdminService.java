package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.CreditNotePurchase;
import ma.sir.ecom.dao.criteria.core.CreditNotePurchaseCriteria;
import ma.sir.ecom.dao.criteria.history.CreditNotePurchaseHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.CreditNotePurchaseDto;
import org.springframework.http.HttpEntity;

public interface CreditNotePurchaseAdminService extends  IService<CreditNotePurchase,CreditNotePurchaseCriteria, CreditNotePurchaseHistoryCriteria>  {

    List<CreditNotePurchase> findByPurchaseId(Long id);
    int deleteByPurchaseId(Long id);
    List<CreditNotePurchase> findByCreditNotePurchaseStatusId(Long id);
    int deleteByCreditNotePurchaseStatusId(Long id);

    HttpEntity<byte[]> createPdf(CreditNotePurchaseDto dto) throws Exception;


}
