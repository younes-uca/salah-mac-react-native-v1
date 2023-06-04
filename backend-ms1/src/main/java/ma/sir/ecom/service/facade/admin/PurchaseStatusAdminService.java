package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.PurchaseStatus;
import ma.sir.ecom.dao.criteria.core.PurchaseStatusCriteria;
import ma.sir.ecom.dao.criteria.history.PurchaseStatusHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.PurchaseStatusDto;
import org.springframework.http.HttpEntity;

public interface PurchaseStatusAdminService extends  IService<PurchaseStatus,PurchaseStatusCriteria, PurchaseStatusHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(PurchaseStatusDto dto) throws Exception;


}
