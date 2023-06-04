package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.StatusPaymentDemand;
import ma.sir.ecom.dao.criteria.core.StatusPaymentDemandCriteria;
import ma.sir.ecom.dao.criteria.history.StatusPaymentDemandHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.StatusPaymentDemandDto;
import org.springframework.http.HttpEntity;

public interface StatusPaymentDemandAdminService extends  IService<StatusPaymentDemand,StatusPaymentDemandCriteria, StatusPaymentDemandHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(StatusPaymentDemandDto dto) throws Exception;


}
