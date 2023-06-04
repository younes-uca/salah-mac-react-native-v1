package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.Demand;
import ma.sir.ecom.dao.criteria.core.DemandCriteria;
import ma.sir.ecom.dao.criteria.history.DemandHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.DemandDto;
import org.springframework.http.HttpEntity;

public interface DemandAdminService extends  IService<Demand,DemandCriteria, DemandHistoryCriteria>  {

    List<Demand> findByClientId(Long id);
    int deleteByClientId(Long id);
    List<Demand> findByDemandStatusId(Long id);
    int deleteByDemandStatusId(Long id);

    HttpEntity<byte[]> createPdf(DemandDto dto) throws Exception;


}
