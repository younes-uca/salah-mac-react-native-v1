package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.PurchasePaymentStatus;
import ma.sir.ecom.bean.history.PurchasePaymentStatusHistory;
import ma.sir.ecom.dao.criteria.core.PurchasePaymentStatusCriteria;
import ma.sir.ecom.dao.criteria.history.PurchasePaymentStatusHistoryCriteria;
import ma.sir.ecom.dao.facade.core.PurchasePaymentStatusDao;
import ma.sir.ecom.dao.facade.history.PurchasePaymentStatusHistoryDao;
import ma.sir.ecom.dao.specification.core.PurchasePaymentStatusSpecification;
import ma.sir.ecom.service.facade.admin.PurchasePaymentStatusAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.PurchasePaymentStatusDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class PurchasePaymentStatusAdminServiceImpl extends AbstractServiceImpl<PurchasePaymentStatus,PurchasePaymentStatusHistory, PurchasePaymentStatusCriteria, PurchasePaymentStatusHistoryCriteria, PurchasePaymentStatusDao,
PurchasePaymentStatusHistoryDao> implements PurchasePaymentStatusAdminService {
    public static final String TEMPLATE = "template/purchasePaymentStatus.vm";
    public static final String FILE_NAME = "purchasePaymentStatus.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(PurchasePaymentStatusDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public PurchasePaymentStatus findByReferenceEntity(PurchasePaymentStatus t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(PurchasePaymentStatus.class,PurchasePaymentStatusHistory.class, PurchasePaymentStatusHistoryCriteria.class, PurchasePaymentStatusSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public PurchasePaymentStatusAdminServiceImpl(PurchasePaymentStatusDao dao, PurchasePaymentStatusHistoryDao historyDao) {
        super(dao, historyDao);
    }

}