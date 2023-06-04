package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.PaymentPurchase;
import ma.sir.ecom.dao.criteria.core.PaymentPurchaseCriteria;
import ma.sir.ecom.dao.criteria.history.PaymentPurchaseHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.PaymentPurchaseDto;
import org.springframework.http.HttpEntity;

public interface PaymentPurchaseAdminService extends  IService<PaymentPurchase,PaymentPurchaseCriteria, PaymentPurchaseHistoryCriteria>  {

    List<PaymentPurchase> findByPurchaseId(Long id);
    int deleteByPurchaseId(Long id);
    List<PaymentPurchase> findByPaymentModeId(Long id);
    int deleteByPaymentModeId(Long id);
    List<PaymentPurchase> findByPurchasePaymentStatusId(Long id);
    int deleteByPurchasePaymentStatusId(Long id);

    HttpEntity<byte[]> createPdf(PaymentPurchaseDto dto) throws Exception;


}
