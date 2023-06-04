package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.DemandItem;
import ma.sir.ecom.dao.criteria.core.DemandItemCriteria;
import ma.sir.ecom.dao.criteria.history.DemandItemHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.DemandItemDto;
import org.springframework.http.HttpEntity;

public interface DemandItemAdminService extends  IService<DemandItem,DemandItemCriteria, DemandItemHistoryCriteria>  {

    List<DemandItem> findByProductId(Long id);
    int deleteByProductId(Long id);
    List<DemandItem> findByDemandId(Long id);
    int deleteByDemandId(Long id);

    HttpEntity<byte[]> createPdf(DemandItemDto dto) throws Exception;


}
