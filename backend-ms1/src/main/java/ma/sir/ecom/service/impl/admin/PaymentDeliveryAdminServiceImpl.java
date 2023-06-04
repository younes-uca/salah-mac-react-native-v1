package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.PaymentDelivery;
import ma.sir.ecom.bean.history.PaymentDeliveryHistory;
import ma.sir.ecom.dao.criteria.core.PaymentDeliveryCriteria;
import ma.sir.ecom.dao.criteria.history.PaymentDeliveryHistoryCriteria;
import ma.sir.ecom.dao.facade.core.PaymentDeliveryDao;
import ma.sir.ecom.dao.facade.history.PaymentDeliveryHistoryDao;
import ma.sir.ecom.dao.specification.core.PaymentDeliverySpecification;
import ma.sir.ecom.service.facade.admin.PaymentDeliveryAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.PaymentDeliveryDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ecom.service.facade.admin.SaleAdminService ;
import ma.sir.ecom.service.facade.admin.PaymentMethodAdminService ;
import ma.sir.ecom.service.facade.admin.DeliveryAdminService ;
import ma.sir.ecom.service.facade.admin.PaymentDeliveryStatusAdminService ;


import java.util.List;
@Service
public class PaymentDeliveryAdminServiceImpl extends AbstractServiceImpl<PaymentDelivery,PaymentDeliveryHistory, PaymentDeliveryCriteria, PaymentDeliveryHistoryCriteria, PaymentDeliveryDao,
PaymentDeliveryHistoryDao> implements PaymentDeliveryAdminService {
    public static final String TEMPLATE = "template/paymentDelivery.vm";
    public static final String FILE_NAME = "paymentDelivery.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(PaymentDeliveryDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public PaymentDelivery findByReferenceEntity(PaymentDelivery t){
        return  dao.findByReference(t.getReference());
    }

    public List<PaymentDelivery> findByDeliveryId(Long id){
        return dao.findByDeliveryId(id);
    }
    public int deleteByDeliveryId(Long id){
        return dao.deleteByDeliveryId(id);
    }
    public List<PaymentDelivery> findBySaleId(Long id){
        return dao.findBySaleId(id);
    }
    public int deleteBySaleId(Long id){
        return dao.deleteBySaleId(id);
    }
    public List<PaymentDelivery> findByPaymentMethodId(Long id){
        return dao.findByPaymentMethodId(id);
    }
    public int deleteByPaymentMethodId(Long id){
        return dao.deleteByPaymentMethodId(id);
    }
    public List<PaymentDelivery> findByPaymentDeliveryStatusId(Long id){
        return dao.findByPaymentDeliveryStatusId(id);
    }
    public int deleteByPaymentDeliveryStatusId(Long id){
        return dao.deleteByPaymentDeliveryStatusId(id);
    }




    public void configure() {
        super.configure(PaymentDelivery.class,PaymentDeliveryHistory.class, PaymentDeliveryHistoryCriteria.class, PaymentDeliverySpecification.class);
    }

    @Autowired
    private SaleAdminService saleService ;
    @Autowired
    private PaymentMethodAdminService paymentMethodService ;
    @Autowired
    private DeliveryAdminService deliveryService ;
    @Autowired
    private PaymentDeliveryStatusAdminService paymentDeliveryStatusService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public PaymentDeliveryAdminServiceImpl(PaymentDeliveryDao dao, PaymentDeliveryHistoryDao historyDao) {
        super(dao, historyDao);
    }

}