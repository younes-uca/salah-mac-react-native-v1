package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.ReturnStatus;
import ma.sir.ecom.dao.criteria.core.ReturnStatusCriteria;
import ma.sir.ecom.dao.criteria.history.ReturnStatusHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.ReturnStatusDto;
import org.springframework.http.HttpEntity;

public interface ReturnStatusAdminService extends  IService<ReturnStatus,ReturnStatusCriteria, ReturnStatusHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(ReturnStatusDto dto) throws Exception;


}
