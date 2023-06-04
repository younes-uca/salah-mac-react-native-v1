package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.AccountingOperation;
import ma.sir.ecom.dao.criteria.core.AccountingOperationCriteria;
import ma.sir.ecom.dao.criteria.history.AccountingOperationHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.AccountingOperationDto;
import org.springframework.http.HttpEntity;

public interface AccountingOperationAdminService extends  IService<AccountingOperation,AccountingOperationCriteria, AccountingOperationHistoryCriteria>  {

    List<AccountingOperation> findByCompanyId(Long id);
    int deleteByCompanyId(Long id);
    List<AccountingOperation> findByAccountingAccountId(Long id);
    int deleteByAccountingAccountId(Long id);
    List<AccountingOperation> findByAccountingOperationTypeId(Long id);
    int deleteByAccountingOperationTypeId(Long id);
    List<AccountingOperation> findByAccountingOperationStatusId(Long id);
    int deleteByAccountingOperationStatusId(Long id);

    HttpEntity<byte[]> createPdf(AccountingOperationDto dto) throws Exception;


}
