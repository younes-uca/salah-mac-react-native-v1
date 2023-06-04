package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.Purchase;
import ma.sir.ecom.dao.criteria.core.PurchaseCriteria;
import ma.sir.ecom.dao.criteria.history.PurchaseHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.PurchaseDto;
import org.springframework.http.HttpEntity;

public interface PurchaseAdminService extends  IService<Purchase,PurchaseCriteria, PurchaseHistoryCriteria>  {

    List<Purchase> findBySupplierId(Long id);
    int deleteBySupplierId(Long id);
    List<Purchase> findByStoreId(Long id);
    int deleteByStoreId(Long id);
    List<Purchase> findByPurchaseStatusId(Long id);
    int deleteByPurchaseStatusId(Long id);

    HttpEntity<byte[]> createPdf(PurchaseDto dto) throws Exception;


}
