package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.VatDeclaration;
import ma.sir.ecom.bean.history.VatDeclarationHistory;
import ma.sir.ecom.dao.criteria.core.VatDeclarationCriteria;
import ma.sir.ecom.dao.criteria.history.VatDeclarationHistoryCriteria;
import ma.sir.ecom.dao.facade.core.VatDeclarationDao;
import ma.sir.ecom.dao.facade.history.VatDeclarationHistoryDao;
import ma.sir.ecom.dao.specification.core.VatDeclarationSpecification;
import ma.sir.ecom.service.facade.admin.VatDeclarationAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.VatDeclarationDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ecom.service.facade.admin.CompanyAdminService ;
import ma.sir.ecom.service.facade.admin.HandlingAccountantAdminService ;
import ma.sir.ecom.service.facade.admin.ValidationAccountantAdminService ;
import ma.sir.ecom.service.facade.admin.LatePaymentRateAdminService ;


import java.util.List;
@Service
public class VatDeclarationAdminServiceImpl extends AbstractServiceImpl<VatDeclaration,VatDeclarationHistory, VatDeclarationCriteria, VatDeclarationHistoryCriteria, VatDeclarationDao,
VatDeclarationHistoryDao> implements VatDeclarationAdminService {
    public static final String TEMPLATE = "template/vatDeclaration.vm";
    public static final String FILE_NAME = "vatDeclaration.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(VatDeclarationDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public VatDeclaration findByReferenceEntity(VatDeclaration t){
        return  dao.findByReference(t.getReference());
    }

    public List<VatDeclaration> findByCompanyId(Long id){
        return dao.findByCompanyId(id);
    }
    public int deleteByCompanyId(Long id){
        return dao.deleteByCompanyId(id);
    }
    public List<VatDeclaration> findByLatePaymentRateId(Long id){
        return dao.findByLatePaymentRateId(id);
    }
    public int deleteByLatePaymentRateId(Long id){
        return dao.deleteByLatePaymentRateId(id);
    }
    public List<VatDeclaration> findByHandlingAccountantId(Long id){
        return dao.findByHandlingAccountantId(id);
    }
    public int deleteByHandlingAccountantId(Long id){
        return dao.deleteByHandlingAccountantId(id);
    }
    public List<VatDeclaration> findByValidationAccountantId(Long id){
        return dao.findByValidationAccountantId(id);
    }
    public int deleteByValidationAccountantId(Long id){
        return dao.deleteByValidationAccountantId(id);
    }




    public void configure() {
        super.configure(VatDeclaration.class,VatDeclarationHistory.class, VatDeclarationHistoryCriteria.class, VatDeclarationSpecification.class);
    }

    @Autowired
    private CompanyAdminService companyService ;
    @Autowired
    private HandlingAccountantAdminService handlingAccountantService ;
    @Autowired
    private ValidationAccountantAdminService validationAccountantService ;
    @Autowired
    private LatePaymentRateAdminService latePaymentRateService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public VatDeclarationAdminServiceImpl(VatDeclarationDao dao, VatDeclarationHistoryDao historyDao) {
        super(dao, historyDao);
    }

}