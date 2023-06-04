package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.AccountingOperationStatus;
import ma.sir.ecom.bean.history.AccountingOperationStatusHistory;
import ma.sir.ecom.dao.criteria.core.AccountingOperationStatusCriteria;
import ma.sir.ecom.dao.criteria.history.AccountingOperationStatusHistoryCriteria;
import ma.sir.ecom.dao.facade.core.AccountingOperationStatusDao;
import ma.sir.ecom.dao.facade.history.AccountingOperationStatusHistoryDao;
import ma.sir.ecom.dao.specification.core.AccountingOperationStatusSpecification;
import ma.sir.ecom.service.facade.admin.AccountingOperationStatusAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.AccountingOperationStatusDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class AccountingOperationStatusAdminServiceImpl extends AbstractServiceImpl<AccountingOperationStatus,AccountingOperationStatusHistory, AccountingOperationStatusCriteria, AccountingOperationStatusHistoryCriteria, AccountingOperationStatusDao,
AccountingOperationStatusHistoryDao> implements AccountingOperationStatusAdminService {
    public static final String TEMPLATE = "template/accountingOperationStatus.vm";
    public static final String FILE_NAME = "accountingOperationStatus.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(AccountingOperationStatusDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public AccountingOperationStatus findByReferenceEntity(AccountingOperationStatus t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(AccountingOperationStatus.class,AccountingOperationStatusHistory.class, AccountingOperationStatusHistoryCriteria.class, AccountingOperationStatusSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public AccountingOperationStatusAdminServiceImpl(AccountingOperationStatusDao dao, AccountingOperationStatusHistoryDao historyDao) {
        super(dao, historyDao);
    }

}