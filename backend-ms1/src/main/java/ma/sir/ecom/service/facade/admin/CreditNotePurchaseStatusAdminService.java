package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.CreditNotePurchaseStatus;
import ma.sir.ecom.dao.criteria.core.CreditNotePurchaseStatusCriteria;
import ma.sir.ecom.dao.criteria.history.CreditNotePurchaseStatusHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.CreditNotePurchaseStatusDto;
import org.springframework.http.HttpEntity;

public interface CreditNotePurchaseStatusAdminService extends  IService<CreditNotePurchaseStatus,CreditNotePurchaseStatusCriteria, CreditNotePurchaseStatusHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(CreditNotePurchaseStatusDto dto) throws Exception;


}
