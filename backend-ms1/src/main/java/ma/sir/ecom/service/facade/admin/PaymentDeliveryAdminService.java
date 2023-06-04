package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.PaymentDelivery;
import ma.sir.ecom.dao.criteria.core.PaymentDeliveryCriteria;
import ma.sir.ecom.dao.criteria.history.PaymentDeliveryHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.PaymentDeliveryDto;
import org.springframework.http.HttpEntity;

public interface PaymentDeliveryAdminService extends  IService<PaymentDelivery,PaymentDeliveryCriteria, PaymentDeliveryHistoryCriteria>  {

    List<PaymentDelivery> findByDeliveryId(Long id);
    int deleteByDeliveryId(Long id);
    List<PaymentDelivery> findBySaleId(Long id);
    int deleteBySaleId(Long id);
    List<PaymentDelivery> findByPaymentMethodId(Long id);
    int deleteByPaymentMethodId(Long id);
    List<PaymentDelivery> findByPaymentDeliveryStatusId(Long id);
    int deleteByPaymentDeliveryStatusId(Long id);

    HttpEntity<byte[]> createPdf(PaymentDeliveryDto dto) throws Exception;


}
