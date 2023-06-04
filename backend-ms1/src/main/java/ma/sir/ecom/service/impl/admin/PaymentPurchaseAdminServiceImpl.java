package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.PaymentPurchase;
import ma.sir.ecom.bean.history.PaymentPurchaseHistory;
import ma.sir.ecom.dao.criteria.core.PaymentPurchaseCriteria;
import ma.sir.ecom.dao.criteria.history.PaymentPurchaseHistoryCriteria;
import ma.sir.ecom.dao.facade.core.PaymentPurchaseDao;
import ma.sir.ecom.dao.facade.history.PaymentPurchaseHistoryDao;
import ma.sir.ecom.dao.specification.core.PaymentPurchaseSpecification;
import ma.sir.ecom.service.facade.admin.PaymentPurchaseAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.PaymentPurchaseDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ecom.service.facade.admin.PurchaseAdminService ;
import ma.sir.ecom.service.facade.admin.PaymentModeAdminService ;
import ma.sir.ecom.service.facade.admin.PurchasePaymentStatusAdminService ;


import java.util.List;
@Service
public class PaymentPurchaseAdminServiceImpl extends AbstractServiceImpl<PaymentPurchase,PaymentPurchaseHistory, PaymentPurchaseCriteria, PaymentPurchaseHistoryCriteria, PaymentPurchaseDao,
PaymentPurchaseHistoryDao> implements PaymentPurchaseAdminService {
    public static final String TEMPLATE = "template/paymentPurchase.vm";
    public static final String FILE_NAME = "paymentPurchase.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(PaymentPurchaseDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public PaymentPurchase findByReferenceEntity(PaymentPurchase t){
        return  dao.findByReference(t.getReference());
    }

    public List<PaymentPurchase> findByPurchaseId(Long id){
        return dao.findByPurchaseId(id);
    }
    public int deleteByPurchaseId(Long id){
        return dao.deleteByPurchaseId(id);
    }
    public List<PaymentPurchase> findByPaymentModeId(Long id){
        return dao.findByPaymentModeId(id);
    }
    public int deleteByPaymentModeId(Long id){
        return dao.deleteByPaymentModeId(id);
    }
    public List<PaymentPurchase> findByPurchasePaymentStatusId(Long id){
        return dao.findByPurchasePaymentStatusId(id);
    }
    public int deleteByPurchasePaymentStatusId(Long id){
        return dao.deleteByPurchasePaymentStatusId(id);
    }




    public void configure() {
        super.configure(PaymentPurchase.class,PaymentPurchaseHistory.class, PaymentPurchaseHistoryCriteria.class, PaymentPurchaseSpecification.class);
    }

    @Autowired
    private PurchaseAdminService purchaseService ;
    @Autowired
    private PaymentModeAdminService paymentModeService ;
    @Autowired
    private PurchasePaymentStatusAdminService purchasePaymentStatusService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public PaymentPurchaseAdminServiceImpl(PaymentPurchaseDao dao, PaymentPurchaseHistoryDao historyDao) {
        super(dao, historyDao);
    }

}