package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.AccountingClass;
import ma.sir.ecom.bean.history.AccountingClassHistory;
import ma.sir.ecom.dao.criteria.core.AccountingClassCriteria;
import ma.sir.ecom.dao.criteria.history.AccountingClassHistoryCriteria;
import ma.sir.ecom.dao.facade.core.AccountingClassDao;
import ma.sir.ecom.dao.facade.history.AccountingClassHistoryDao;
import ma.sir.ecom.dao.specification.core.AccountingClassSpecification;
import ma.sir.ecom.service.facade.admin.AccountingClassAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.AccountingClassDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class AccountingClassAdminServiceImpl extends AbstractServiceImpl<AccountingClass,AccountingClassHistory, AccountingClassCriteria, AccountingClassHistoryCriteria, AccountingClassDao,
AccountingClassHistoryDao> implements AccountingClassAdminService {
    public static final String TEMPLATE = "template/accountingClass.vm";
    public static final String FILE_NAME = "accountingClass.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(AccountingClassDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public AccountingClass findByReferenceEntity(AccountingClass t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(AccountingClass.class,AccountingClassHistory.class, AccountingClassHistoryCriteria.class, AccountingClassSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public AccountingClassAdminServiceImpl(AccountingClassDao dao, AccountingClassHistoryDao historyDao) {
        super(dao, historyDao);
    }

}