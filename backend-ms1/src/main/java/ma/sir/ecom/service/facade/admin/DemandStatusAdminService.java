package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.DemandStatus;
import ma.sir.ecom.dao.criteria.core.DemandStatusCriteria;
import ma.sir.ecom.dao.criteria.history.DemandStatusHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.DemandStatusDto;
import org.springframework.http.HttpEntity;

public interface DemandStatusAdminService extends  IService<DemandStatus,DemandStatusCriteria, DemandStatusHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(DemandStatusDto dto) throws Exception;


}
