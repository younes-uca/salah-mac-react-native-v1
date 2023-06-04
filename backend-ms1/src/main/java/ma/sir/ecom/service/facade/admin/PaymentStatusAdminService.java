package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.PaymentStatus;
import ma.sir.ecom.dao.criteria.core.PaymentStatusCriteria;
import ma.sir.ecom.dao.criteria.history.PaymentStatusHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.PaymentStatusDto;
import org.springframework.http.HttpEntity;

public interface PaymentStatusAdminService extends  IService<PaymentStatus,PaymentStatusCriteria, PaymentStatusHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(PaymentStatusDto dto) throws Exception;


}
