package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.PurchaseStatus;
import ma.sir.ecom.bean.history.PurchaseStatusHistory;
import ma.sir.ecom.dao.criteria.core.PurchaseStatusCriteria;
import ma.sir.ecom.dao.criteria.history.PurchaseStatusHistoryCriteria;
import ma.sir.ecom.dao.facade.core.PurchaseStatusDao;
import ma.sir.ecom.dao.facade.history.PurchaseStatusHistoryDao;
import ma.sir.ecom.dao.specification.core.PurchaseStatusSpecification;
import ma.sir.ecom.service.facade.admin.PurchaseStatusAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.PurchaseStatusDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class PurchaseStatusAdminServiceImpl extends AbstractServiceImpl<PurchaseStatus,PurchaseStatusHistory, PurchaseStatusCriteria, PurchaseStatusHistoryCriteria, PurchaseStatusDao,
PurchaseStatusHistoryDao> implements PurchaseStatusAdminService {
    public static final String TEMPLATE = "template/purchaseStatus.vm";
    public static final String FILE_NAME = "purchaseStatus.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(PurchaseStatusDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public PurchaseStatus findByReferenceEntity(PurchaseStatus t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(PurchaseStatus.class,PurchaseStatusHistory.class, PurchaseStatusHistoryCriteria.class, PurchaseStatusSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public PurchaseStatusAdminServiceImpl(PurchaseStatusDao dao, PurchaseStatusHistoryDao historyDao) {
        super(dao, historyDao);
    }

}