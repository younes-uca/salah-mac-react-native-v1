package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.Store;
import ma.sir.ecom.dao.criteria.core.StoreCriteria;
import ma.sir.ecom.dao.criteria.history.StoreHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.StoreDto;
import org.springframework.http.HttpEntity;

public interface StoreAdminService extends  IService<Store,StoreCriteria, StoreHistoryCriteria>  {

    List<Store> findByCompanyId(Long id);
    int deleteByCompanyId(Long id);

    HttpEntity<byte[]> createPdf(StoreDto dto) throws Exception;


}
