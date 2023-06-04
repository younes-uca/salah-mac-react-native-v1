package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.OrderPayment;
import ma.sir.ecom.dao.criteria.core.OrderPaymentCriteria;
import ma.sir.ecom.dao.criteria.history.OrderPaymentHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.OrderPaymentDto;
import org.springframework.http.HttpEntity;

public interface OrderPaymentAdminService extends  IService<OrderPayment,OrderPaymentCriteria, OrderPaymentHistoryCriteria>  {

    List<OrderPayment> findByOrderId(Long id);
    int deleteByOrderId(Long id);
    List<OrderPayment> findByPaymentModeId(Long id);
    int deleteByPaymentModeId(Long id);
    List<OrderPayment> findByOrderStatusOrderId(Long id);
    int deleteByOrderStatusOrderId(Long id);

    HttpEntity<byte[]> createPdf(OrderPaymentDto dto) throws Exception;


}
