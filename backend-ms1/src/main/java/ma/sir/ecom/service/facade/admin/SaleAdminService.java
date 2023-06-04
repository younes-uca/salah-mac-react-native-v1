package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.Sale;
import ma.sir.ecom.dao.criteria.core.SaleCriteria;
import ma.sir.ecom.dao.criteria.history.SaleHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.SaleDto;
import org.springframework.http.HttpEntity;

public interface SaleAdminService extends  IService<Sale,SaleCriteria, SaleHistoryCriteria>  {

    List<Sale> findByStoreId(Long id);
    int deleteByStoreId(Long id);
    List<Sale> findByClientId(Long id);
    int deleteByClientId(Long id);
    List<Sale> findBySaleStatusId(Long id);
    int deleteBySaleStatusId(Long id);

    HttpEntity<byte[]> createPdf(SaleDto dto) throws Exception;


}
