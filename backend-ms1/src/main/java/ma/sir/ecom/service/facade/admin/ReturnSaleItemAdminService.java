package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.ReturnSaleItem;
import ma.sir.ecom.dao.criteria.core.ReturnSaleItemCriteria;
import ma.sir.ecom.dao.criteria.history.ReturnSaleItemHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.ReturnSaleItemDto;
import org.springframework.http.HttpEntity;

public interface ReturnSaleItemAdminService extends  IService<ReturnSaleItem,ReturnSaleItemCriteria, ReturnSaleItemHistoryCriteria>  {

    List<ReturnSaleItem> findByProductId(Long id);
    int deleteByProductId(Long id);
    List<ReturnSaleItem> findByReturnSaleId(Long id);
    int deleteByReturnSaleId(Long id);

    HttpEntity<byte[]> createPdf(ReturnSaleItemDto dto) throws Exception;


}
