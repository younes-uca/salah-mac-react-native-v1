package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.PaymentDeliveryStatus;
import ma.sir.ecom.dao.criteria.core.PaymentDeliveryStatusCriteria;
import ma.sir.ecom.dao.criteria.history.PaymentDeliveryStatusHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.PaymentDeliveryStatusDto;
import org.springframework.http.HttpEntity;

public interface PaymentDeliveryStatusAdminService extends  IService<PaymentDeliveryStatus,PaymentDeliveryStatusCriteria, PaymentDeliveryStatusHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(PaymentDeliveryStatusDto dto) throws Exception;


}
