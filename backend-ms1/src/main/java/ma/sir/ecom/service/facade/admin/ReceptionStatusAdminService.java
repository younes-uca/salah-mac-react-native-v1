package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.ReceptionStatus;
import ma.sir.ecom.dao.criteria.core.ReceptionStatusCriteria;
import ma.sir.ecom.dao.criteria.history.ReceptionStatusHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.ReceptionStatusDto;
import org.springframework.http.HttpEntity;

public interface ReceptionStatusAdminService extends  IService<ReceptionStatus,ReceptionStatusCriteria, ReceptionStatusHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(ReceptionStatusDto dto) throws Exception;


}
