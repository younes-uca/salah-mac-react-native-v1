package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.ReceptionItem;
import ma.sir.ecom.dao.criteria.core.ReceptionItemCriteria;
import ma.sir.ecom.dao.criteria.history.ReceptionItemHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.ReceptionItemDto;
import org.springframework.http.HttpEntity;

public interface ReceptionItemAdminService extends  IService<ReceptionItem,ReceptionItemCriteria, ReceptionItemHistoryCriteria>  {

    List<ReceptionItem> findByProductId(Long id);
    int deleteByProductId(Long id);
    List<ReceptionItem> findByStoreId(Long id);
    int deleteByStoreId(Long id);
    List<ReceptionItem> findByReceptionId(Long id);
    int deleteByReceptionId(Long id);

    HttpEntity<byte[]> createPdf(ReceptionItemDto dto) throws Exception;


}
