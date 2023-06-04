package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.AccountingAccount;
import ma.sir.ecom.dao.criteria.core.AccountingAccountCriteria;
import ma.sir.ecom.dao.criteria.history.AccountingAccountHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.AccountingAccountDto;
import org.springframework.http.HttpEntity;

public interface AccountingAccountAdminService extends  IService<AccountingAccount,AccountingAccountCriteria, AccountingAccountHistoryCriteria>  {

    List<AccountingAccount> findBySubAccountingClassId(Long id);
    int deleteBySubAccountingClassId(Long id);

    HttpEntity<byte[]> createPdf(AccountingAccountDto dto) throws Exception;


}
