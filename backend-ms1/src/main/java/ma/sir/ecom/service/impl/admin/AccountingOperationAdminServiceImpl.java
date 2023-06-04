package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.AccountingOperation;
import ma.sir.ecom.bean.history.AccountingOperationHistory;
import ma.sir.ecom.dao.criteria.core.AccountingOperationCriteria;
import ma.sir.ecom.dao.criteria.history.AccountingOperationHistoryCriteria;
import ma.sir.ecom.dao.facade.core.AccountingOperationDao;
import ma.sir.ecom.dao.facade.history.AccountingOperationHistoryDao;
import ma.sir.ecom.dao.specification.core.AccountingOperationSpecification;
import ma.sir.ecom.service.facade.admin.AccountingOperationAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.service.Attribute;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.AccountingOperationDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ecom.service.facade.admin.CompanyAdminService ;
import ma.sir.ecom.service.facade.admin.AccountingAccountAdminService ;
import ma.sir.ecom.service.facade.admin.AccountingOperationStatusAdminService ;
import ma.sir.ecom.service.facade.admin.AccountingOperationTypeAdminService ;


import java.util.List;
@Service
public class AccountingOperationAdminServiceImpl extends AbstractServiceImpl<AccountingOperation,AccountingOperationHistory, AccountingOperationCriteria, AccountingOperationHistoryCriteria, AccountingOperationDao,
AccountingOperationHistoryDao> implements AccountingOperationAdminService {
    public static final String TEMPLATE = "template/accountingOperation.vm";
    public static final String FILE_NAME = "accountingOperation.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList<>();
    static{
    ATTRIBUTES.add(new Attribute("id","Long"));
    ATTRIBUTES.add(new Attribute("libelle"));
    ATTRIBUTES.add(new Attribute("year","Integer"));
    ATTRIBUTES.add(new Attribute("month","Integer"));
    ATTRIBUTES.add(new Attribute("amount","BigDecimal"));
    }

    @Override
    public HttpEntity<byte[]> createPdf(AccountingOperationDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }



    public List<AccountingOperation> findByCompanyId(Long id){
        return dao.findByCompanyId(id);
    }
    public int deleteByCompanyId(Long id){
        return dao.deleteByCompanyId(id);
    }
    public List<AccountingOperation> findByAccountingAccountId(Long id){
        return dao.findByAccountingAccountId(id);
    }
    public int deleteByAccountingAccountId(Long id){
        return dao.deleteByAccountingAccountId(id);
    }
    public List<AccountingOperation> findByAccountingOperationTypeId(Long id){
        return dao.findByAccountingOperationTypeId(id);
    }
    public int deleteByAccountingOperationTypeId(Long id){
        return dao.deleteByAccountingOperationTypeId(id);
    }
    public List<AccountingOperation> findByAccountingOperationStatusId(Long id){
        return dao.findByAccountingOperationStatusId(id);
    }
    public int deleteByAccountingOperationStatusId(Long id){
        return dao.deleteByAccountingOperationStatusId(id);
    }


    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }


    public void configure() {
        super.configure(AccountingOperation.class,AccountingOperationHistory.class, AccountingOperationHistoryCriteria.class, AccountingOperationSpecification.class);
    }

    @Autowired
    private CompanyAdminService companyService ;
    @Autowired
    private AccountingAccountAdminService accountingAccountService ;
    @Autowired
    private AccountingOperationStatusAdminService accountingOperationStatusService ;
    @Autowired
    private AccountingOperationTypeAdminService accountingOperationTypeService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public AccountingOperationAdminServiceImpl(AccountingOperationDao dao, AccountingOperationHistoryDao historyDao) {
        super(dao, historyDao);
    }

}