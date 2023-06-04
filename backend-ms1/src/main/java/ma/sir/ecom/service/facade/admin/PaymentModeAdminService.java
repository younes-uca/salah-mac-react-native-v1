package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.PaymentMode;
import ma.sir.ecom.dao.criteria.core.PaymentModeCriteria;
import ma.sir.ecom.dao.criteria.history.PaymentModeHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.PaymentModeDto;
import org.springframework.http.HttpEntity;

public interface PaymentModeAdminService extends  IService<PaymentMode,PaymentModeCriteria, PaymentModeHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(PaymentModeDto dto) throws Exception;


}
