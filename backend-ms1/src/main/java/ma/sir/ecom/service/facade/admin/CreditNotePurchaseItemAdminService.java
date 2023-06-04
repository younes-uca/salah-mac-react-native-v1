package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.CreditNotePurchaseItem;
import ma.sir.ecom.dao.criteria.core.CreditNotePurchaseItemCriteria;
import ma.sir.ecom.dao.criteria.history.CreditNotePurchaseItemHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.CreditNotePurchaseItemDto;
import org.springframework.http.HttpEntity;

public interface CreditNotePurchaseItemAdminService extends  IService<CreditNotePurchaseItem,CreditNotePurchaseItemCriteria, CreditNotePurchaseItemHistoryCriteria>  {

    List<CreditNotePurchaseItem> findByProductId(Long id);
    int deleteByProductId(Long id);
    List<CreditNotePurchaseItem> findByCreditNotePurchaseId(Long id);
    int deleteByCreditNotePurchaseId(Long id);

    HttpEntity<byte[]> createPdf(CreditNotePurchaseItemDto dto) throws Exception;


}
