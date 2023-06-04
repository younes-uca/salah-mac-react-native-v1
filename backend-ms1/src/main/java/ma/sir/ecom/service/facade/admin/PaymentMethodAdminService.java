package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.PaymentMethod;
import ma.sir.ecom.dao.criteria.core.PaymentMethodCriteria;
import ma.sir.ecom.dao.criteria.history.PaymentMethodHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.PaymentMethodDto;
import org.springframework.http.HttpEntity;

public interface PaymentMethodAdminService extends  IService<PaymentMethod,PaymentMethodCriteria, PaymentMethodHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(PaymentMethodDto dto) throws Exception;


}
