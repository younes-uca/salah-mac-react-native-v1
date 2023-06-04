package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.LatePaymentRate;
import ma.sir.ecom.dao.criteria.core.LatePaymentRateCriteria;
import ma.sir.ecom.dao.criteria.history.LatePaymentRateHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.LatePaymentRateDto;
import org.springframework.http.HttpEntity;

public interface LatePaymentRateAdminService extends  IService<LatePaymentRate,LatePaymentRateCriteria, LatePaymentRateHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(LatePaymentRateDto dto) throws Exception;


}
