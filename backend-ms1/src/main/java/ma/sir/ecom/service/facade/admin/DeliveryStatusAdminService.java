package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.DeliveryStatus;
import ma.sir.ecom.dao.criteria.core.DeliveryStatusCriteria;
import ma.sir.ecom.dao.criteria.history.DeliveryStatusHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.DeliveryStatusDto;
import org.springframework.http.HttpEntity;

public interface DeliveryStatusAdminService extends  IService<DeliveryStatus,DeliveryStatusCriteria, DeliveryStatusHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(DeliveryStatusDto dto) throws Exception;


}
