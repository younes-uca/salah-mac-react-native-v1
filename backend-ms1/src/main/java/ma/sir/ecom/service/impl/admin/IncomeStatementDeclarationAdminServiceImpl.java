package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.IncomeStatementDeclaration;
import ma.sir.ecom.bean.history.IncomeStatementDeclarationHistory;
import ma.sir.ecom.dao.criteria.core.IncomeStatementDeclarationCriteria;
import ma.sir.ecom.dao.criteria.history.IncomeStatementDeclarationHistoryCriteria;
import ma.sir.ecom.dao.facade.core.IncomeStatementDeclarationDao;
import ma.sir.ecom.dao.facade.history.IncomeStatementDeclarationHistoryDao;
import ma.sir.ecom.dao.specification.core.IncomeStatementDeclarationSpecification;
import ma.sir.ecom.service.facade.admin.IncomeStatementDeclarationAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.IncomeStatementDeclarationDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ecom.service.facade.admin.CompanyAdminService ;
import ma.sir.ecom.service.facade.admin.HandlingAccountantAdminService ;
import ma.sir.ecom.service.facade.admin.ValidationAccountantAdminService ;
import ma.sir.ecom.service.facade.admin.CorporateTaxRateAdminService ;


import java.util.List;
@Service
public class IncomeStatementDeclarationAdminServiceImpl extends AbstractServiceImpl<IncomeStatementDeclaration,IncomeStatementDeclarationHistory, IncomeStatementDeclarationCriteria, IncomeStatementDeclarationHistoryCriteria, IncomeStatementDeclarationDao,
IncomeStatementDeclarationHistoryDao> implements IncomeStatementDeclarationAdminService {
    public static final String TEMPLATE = "template/incomeStatementDeclaration.vm";
    public static final String FILE_NAME = "incomeStatementDeclaration.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(IncomeStatementDeclarationDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public IncomeStatementDeclaration findByReferenceEntity(IncomeStatementDeclaration t){
        return  dao.findByReference(t.getReference());
    }

    public List<IncomeStatementDeclaration> findByCompanyId(Long id){
        return dao.findByCompanyId(id);
    }
    public int deleteByCompanyId(Long id){
        return dao.deleteByCompanyId(id);
    }
    public List<IncomeStatementDeclaration> findByCorporateTaxRateId(Long id){
        return dao.findByCorporateTaxRateId(id);
    }
    public int deleteByCorporateTaxRateId(Long id){
        return dao.deleteByCorporateTaxRateId(id);
    }
    public List<IncomeStatementDeclaration> findByHandlingAccountantId(Long id){
        return dao.findByHandlingAccountantId(id);
    }
    public int deleteByHandlingAccountantId(Long id){
        return dao.deleteByHandlingAccountantId(id);
    }
    public List<IncomeStatementDeclaration> findByValidationAccountantId(Long id){
        return dao.findByValidationAccountantId(id);
    }
    public int deleteByValidationAccountantId(Long id){
        return dao.deleteByValidationAccountantId(id);
    }




    public void configure() {
        super.configure(IncomeStatementDeclaration.class,IncomeStatementDeclarationHistory.class, IncomeStatementDeclarationHistoryCriteria.class, IncomeStatementDeclarationSpecification.class);
    }

    @Autowired
    private CompanyAdminService companyService ;
    @Autowired
    private HandlingAccountantAdminService handlingAccountantService ;
    @Autowired
    private ValidationAccountantAdminService validationAccountantService ;
    @Autowired
    private CorporateTaxRateAdminService corporateTaxRateService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public IncomeStatementDeclarationAdminServiceImpl(IncomeStatementDeclarationDao dao, IncomeStatementDeclarationHistoryDao historyDao) {
        super(dao, historyDao);
    }

}