package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.AccountingAccount;
import ma.sir.ecom.bean.history.AccountingAccountHistory;
import ma.sir.ecom.dao.criteria.core.AccountingAccountCriteria;
import ma.sir.ecom.dao.criteria.history.AccountingAccountHistoryCriteria;
import ma.sir.ecom.dao.facade.core.AccountingAccountDao;
import ma.sir.ecom.dao.facade.history.AccountingAccountHistoryDao;
import ma.sir.ecom.dao.specification.core.AccountingAccountSpecification;
import ma.sir.ecom.service.facade.admin.AccountingAccountAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.AccountingAccountDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ecom.service.facade.admin.SubAccountingClassAdminService ;


import java.util.List;
@Service
public class AccountingAccountAdminServiceImpl extends AbstractServiceImpl<AccountingAccount,AccountingAccountHistory, AccountingAccountCriteria, AccountingAccountHistoryCriteria, AccountingAccountDao,
AccountingAccountHistoryDao> implements AccountingAccountAdminService {
    public static final String TEMPLATE = "template/accountingAccount.vm";
    public static final String FILE_NAME = "accountingAccount.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(AccountingAccountDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public AccountingAccount findByReferenceEntity(AccountingAccount t){
        return  dao.findByCode(t.getCode());
    }

    public List<AccountingAccount> findBySubAccountingClassId(Long id){
        return dao.findBySubAccountingClassId(id);
    }
    public int deleteBySubAccountingClassId(Long id){
        return dao.deleteBySubAccountingClassId(id);
    }




    public void configure() {
        super.configure(AccountingAccount.class,AccountingAccountHistory.class, AccountingAccountHistoryCriteria.class, AccountingAccountSpecification.class);
    }

    @Autowired
    private SubAccountingClassAdminService subAccountingClassService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public AccountingAccountAdminServiceImpl(AccountingAccountDao dao, AccountingAccountHistoryDao historyDao) {
        super(dao, historyDao);
    }

}