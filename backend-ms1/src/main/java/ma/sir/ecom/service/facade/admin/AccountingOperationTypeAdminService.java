package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.AccountingOperationType;
import ma.sir.ecom.dao.criteria.core.AccountingOperationTypeCriteria;
import ma.sir.ecom.dao.criteria.history.AccountingOperationTypeHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.AccountingOperationTypeDto;
import org.springframework.http.HttpEntity;

public interface AccountingOperationTypeAdminService extends  IService<AccountingOperationType,AccountingOperationTypeCriteria, AccountingOperationTypeHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(AccountingOperationTypeDto dto) throws Exception;


}
