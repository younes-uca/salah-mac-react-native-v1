package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.PurchaseItem;
import ma.sir.ecom.dao.criteria.core.PurchaseItemCriteria;
import ma.sir.ecom.dao.criteria.history.PurchaseItemHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.PurchaseItemDto;
import org.springframework.http.HttpEntity;

public interface PurchaseItemAdminService extends  IService<PurchaseItem,PurchaseItemCriteria, PurchaseItemHistoryCriteria>  {

    List<PurchaseItem> findByProductId(Long id);
    int deleteByProductId(Long id);
    List<PurchaseItem> findByPurchaseId(Long id);
    int deleteByPurchaseId(Long id);

    HttpEntity<byte[]> createPdf(PurchaseItemDto dto) throws Exception;


}
