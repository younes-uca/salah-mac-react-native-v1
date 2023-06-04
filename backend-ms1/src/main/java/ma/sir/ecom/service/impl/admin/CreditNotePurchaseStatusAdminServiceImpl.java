package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.CreditNotePurchaseStatus;
import ma.sir.ecom.bean.history.CreditNotePurchaseStatusHistory;
import ma.sir.ecom.dao.criteria.core.CreditNotePurchaseStatusCriteria;
import ma.sir.ecom.dao.criteria.history.CreditNotePurchaseStatusHistoryCriteria;
import ma.sir.ecom.dao.facade.core.CreditNotePurchaseStatusDao;
import ma.sir.ecom.dao.facade.history.CreditNotePurchaseStatusHistoryDao;
import ma.sir.ecom.dao.specification.core.CreditNotePurchaseStatusSpecification;
import ma.sir.ecom.service.facade.admin.CreditNotePurchaseStatusAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.CreditNotePurchaseStatusDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class CreditNotePurchaseStatusAdminServiceImpl extends AbstractServiceImpl<CreditNotePurchaseStatus,CreditNotePurchaseStatusHistory, CreditNotePurchaseStatusCriteria, CreditNotePurchaseStatusHistoryCriteria, CreditNotePurchaseStatusDao,
CreditNotePurchaseStatusHistoryDao> implements CreditNotePurchaseStatusAdminService {
    public static final String TEMPLATE = "template/creditNotePurchaseStatus.vm";
    public static final String FILE_NAME = "creditNotePurchaseStatus.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(CreditNotePurchaseStatusDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public CreditNotePurchaseStatus findByReferenceEntity(CreditNotePurchaseStatus t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(CreditNotePurchaseStatus.class,CreditNotePurchaseStatusHistory.class, CreditNotePurchaseStatusHistoryCriteria.class, CreditNotePurchaseStatusSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public CreditNotePurchaseStatusAdminServiceImpl(CreditNotePurchaseStatusDao dao, CreditNotePurchaseStatusHistoryDao historyDao) {
        super(dao, historyDao);
    }

}