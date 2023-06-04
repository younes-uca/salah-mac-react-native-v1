package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.SupplierQuoteItem;
import ma.sir.ecom.dao.criteria.core.SupplierQuoteItemCriteria;
import ma.sir.ecom.dao.criteria.history.SupplierQuoteItemHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.SupplierQuoteItemDto;
import org.springframework.http.HttpEntity;

public interface SupplierQuoteItemAdminService extends  IService<SupplierQuoteItem,SupplierQuoteItemCriteria, SupplierQuoteItemHistoryCriteria>  {

    List<SupplierQuoteItem> findByProductId(Long id);
    int deleteByProductId(Long id);
    List<SupplierQuoteItem> findBySupplierQuoteId(Long id);
    int deleteBySupplierQuoteId(Long id);

    HttpEntity<byte[]> createPdf(SupplierQuoteItemDto dto) throws Exception;


}
