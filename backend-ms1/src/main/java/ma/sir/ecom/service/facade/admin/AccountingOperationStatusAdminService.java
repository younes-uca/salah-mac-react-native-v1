package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.AccountingOperationStatus;
import ma.sir.ecom.dao.criteria.core.AccountingOperationStatusCriteria;
import ma.sir.ecom.dao.criteria.history.AccountingOperationStatusHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.AccountingOperationStatusDto;
import org.springframework.http.HttpEntity;

public interface AccountingOperationStatusAdminService extends  IService<AccountingOperationStatus,AccountingOperationStatusCriteria, AccountingOperationStatusHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(AccountingOperationStatusDto dto) throws Exception;


}
