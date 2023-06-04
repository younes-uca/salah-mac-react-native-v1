package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.PurchasePaymentStatus;
import ma.sir.ecom.dao.criteria.core.PurchasePaymentStatusCriteria;
import ma.sir.ecom.dao.criteria.history.PurchasePaymentStatusHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.PurchasePaymentStatusDto;
import org.springframework.http.HttpEntity;

public interface PurchasePaymentStatusAdminService extends  IService<PurchasePaymentStatus,PurchasePaymentStatusCriteria, PurchasePaymentStatusHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(PurchasePaymentStatusDto dto) throws Exception;


}
