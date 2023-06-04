package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.ReturnSale;
import ma.sir.ecom.dao.criteria.core.ReturnSaleCriteria;
import ma.sir.ecom.dao.criteria.history.ReturnSaleHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.ReturnSaleDto;
import org.springframework.http.HttpEntity;

public interface ReturnSaleAdminService extends  IService<ReturnSale,ReturnSaleCriteria, ReturnSaleHistoryCriteria>  {

    List<ReturnSale> findBySaleId(Long id);
    int deleteBySaleId(Long id);
    List<ReturnSale> findByReturnStatusId(Long id);
    int deleteByReturnStatusId(Long id);

    HttpEntity<byte[]> createPdf(ReturnSaleDto dto) throws Exception;


}
