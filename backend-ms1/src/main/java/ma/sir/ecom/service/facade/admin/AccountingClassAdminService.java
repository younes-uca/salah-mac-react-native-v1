package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.AccountingClass;
import ma.sir.ecom.dao.criteria.core.AccountingClassCriteria;
import ma.sir.ecom.dao.criteria.history.AccountingClassHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.AccountingClassDto;
import org.springframework.http.HttpEntity;

public interface AccountingClassAdminService extends  IService<AccountingClass,AccountingClassCriteria, AccountingClassHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(AccountingClassDto dto) throws Exception;


}
