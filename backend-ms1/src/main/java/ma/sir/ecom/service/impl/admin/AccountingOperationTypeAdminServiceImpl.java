package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.AccountingOperationType;
import ma.sir.ecom.bean.history.AccountingOperationTypeHistory;
import ma.sir.ecom.dao.criteria.core.AccountingOperationTypeCriteria;
import ma.sir.ecom.dao.criteria.history.AccountingOperationTypeHistoryCriteria;
import ma.sir.ecom.dao.facade.core.AccountingOperationTypeDao;
import ma.sir.ecom.dao.facade.history.AccountingOperationTypeHistoryDao;
import ma.sir.ecom.dao.specification.core.AccountingOperationTypeSpecification;
import ma.sir.ecom.service.facade.admin.AccountingOperationTypeAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.AccountingOperationTypeDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class AccountingOperationTypeAdminServiceImpl extends AbstractServiceImpl<AccountingOperationType,AccountingOperationTypeHistory, AccountingOperationTypeCriteria, AccountingOperationTypeHistoryCriteria, AccountingOperationTypeDao,
AccountingOperationTypeHistoryDao> implements AccountingOperationTypeAdminService {
    public static final String TEMPLATE = "template/accountingOperationType.vm";
    public static final String FILE_NAME = "accountingOperationType.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(AccountingOperationTypeDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public AccountingOperationType findByReferenceEntity(AccountingOperationType t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(AccountingOperationType.class,AccountingOperationTypeHistory.class, AccountingOperationTypeHistoryCriteria.class, AccountingOperationTypeSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public AccountingOperationTypeAdminServiceImpl(AccountingOperationTypeDao dao, AccountingOperationTypeHistoryDao historyDao) {
        super(dao, historyDao);
    }

}