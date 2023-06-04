package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.PaymentSale;
import ma.sir.ecom.dao.criteria.core.PaymentSaleCriteria;
import ma.sir.ecom.dao.criteria.history.PaymentSaleHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.PaymentSaleDto;
import org.springframework.http.HttpEntity;

public interface PaymentSaleAdminService extends  IService<PaymentSale,PaymentSaleCriteria, PaymentSaleHistoryCriteria>  {

    List<PaymentSale> findBySaleId(Long id);
    int deleteBySaleId(Long id);
    List<PaymentSale> findByPaymentMethodId(Long id);
    int deleteByPaymentMethodId(Long id);
    List<PaymentSale> findByPaymentStatusId(Long id);
    int deleteByPaymentStatusId(Long id);

    HttpEntity<byte[]> createPdf(PaymentSaleDto dto) throws Exception;


}
