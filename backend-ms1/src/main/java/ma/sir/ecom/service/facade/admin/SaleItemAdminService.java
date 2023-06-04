package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.SaleItem;
import ma.sir.ecom.dao.criteria.core.SaleItemCriteria;
import ma.sir.ecom.dao.criteria.history.SaleItemHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.SaleItemDto;
import org.springframework.http.HttpEntity;

public interface SaleItemAdminService extends  IService<SaleItem,SaleItemCriteria, SaleItemHistoryCriteria>  {

    List<SaleItem> findByProductId(Long id);
    int deleteByProductId(Long id);
    List<SaleItem> findBySaleId(Long id);
    int deleteBySaleId(Long id);

    HttpEntity<byte[]> createPdf(SaleItemDto dto) throws Exception;


}
