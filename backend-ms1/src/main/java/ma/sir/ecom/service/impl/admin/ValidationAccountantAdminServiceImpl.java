package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.ValidationAccountant;
import ma.sir.ecom.bean.history.ValidationAccountantHistory;
import ma.sir.ecom.dao.criteria.core.ValidationAccountantCriteria;
import ma.sir.ecom.dao.criteria.history.ValidationAccountantHistoryCriteria;
import ma.sir.ecom.dao.facade.core.ValidationAccountantDao;
import ma.sir.ecom.dao.facade.history.ValidationAccountantHistoryDao;
import ma.sir.ecom.dao.specification.core.ValidationAccountantSpecification;
import ma.sir.ecom.service.facade.admin.ValidationAccountantAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.ValidationAccountantDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class ValidationAccountantAdminServiceImpl extends AbstractServiceImpl<ValidationAccountant,ValidationAccountantHistory, ValidationAccountantCriteria, ValidationAccountantHistoryCriteria, ValidationAccountantDao,
ValidationAccountantHistoryDao> implements ValidationAccountantAdminService {
    public static final String TEMPLATE = "template/validationAccountant.vm";
    public static final String FILE_NAME = "validationAccountant.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(ValidationAccountantDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public ValidationAccountant findByReferenceEntity(ValidationAccountant t){
        return  dao.findByCin(t.getCin());
    }





    public void configure() {
        super.configure(ValidationAccountant.class,ValidationAccountantHistory.class, ValidationAccountantHistoryCriteria.class, ValidationAccountantSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public ValidationAccountantAdminServiceImpl(ValidationAccountantDao dao, ValidationAccountantHistoryDao historyDao) {
        super(dao, historyDao);
    }

}