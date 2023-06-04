package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.DemandPayment;
import ma.sir.ecom.dao.criteria.core.DemandPaymentCriteria;
import ma.sir.ecom.dao.criteria.history.DemandPaymentHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.DemandPaymentDto;
import org.springframework.http.HttpEntity;

public interface DemandPaymentAdminService extends  IService<DemandPayment,DemandPaymentCriteria, DemandPaymentHistoryCriteria>  {

    List<DemandPayment> findByDemandId(Long id);
    int deleteByDemandId(Long id);
    List<DemandPayment> findByPaymentModeId(Long id);
    int deleteByPaymentModeId(Long id);
    List<DemandPayment> findByStatusPaymentDemandId(Long id);
    int deleteByStatusPaymentDemandId(Long id);

    HttpEntity<byte[]> createPdf(DemandPaymentDto dto) throws Exception;


}
