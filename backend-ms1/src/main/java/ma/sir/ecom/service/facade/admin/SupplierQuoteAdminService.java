package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.SupplierQuote;
import ma.sir.ecom.dao.criteria.core.SupplierQuoteCriteria;
import ma.sir.ecom.dao.criteria.history.SupplierQuoteHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.SupplierQuoteDto;
import org.springframework.http.HttpEntity;

public interface SupplierQuoteAdminService extends  IService<SupplierQuote,SupplierQuoteCriteria, SupplierQuoteHistoryCriteria>  {

    List<SupplierQuote> findBySupplierId(Long id);
    int deleteBySupplierId(Long id);

    HttpEntity<byte[]> createPdf(SupplierQuoteDto dto) throws Exception;


}
