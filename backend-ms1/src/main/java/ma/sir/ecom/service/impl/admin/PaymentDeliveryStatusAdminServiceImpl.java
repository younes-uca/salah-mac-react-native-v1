package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.PaymentDeliveryStatus;
import ma.sir.ecom.bean.history.PaymentDeliveryStatusHistory;
import ma.sir.ecom.dao.criteria.core.PaymentDeliveryStatusCriteria;
import ma.sir.ecom.dao.criteria.history.PaymentDeliveryStatusHistoryCriteria;
import ma.sir.ecom.dao.facade.core.PaymentDeliveryStatusDao;
import ma.sir.ecom.dao.facade.history.PaymentDeliveryStatusHistoryDao;
import ma.sir.ecom.dao.specification.core.PaymentDeliveryStatusSpecification;
import ma.sir.ecom.service.facade.admin.PaymentDeliveryStatusAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.PaymentDeliveryStatusDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class PaymentDeliveryStatusAdminServiceImpl extends AbstractServiceImpl<PaymentDeliveryStatus,PaymentDeliveryStatusHistory, PaymentDeliveryStatusCriteria, PaymentDeliveryStatusHistoryCriteria, PaymentDeliveryStatusDao,
PaymentDeliveryStatusHistoryDao> implements PaymentDeliveryStatusAdminService {
    public static final String TEMPLATE = "template/paymentDeliveryStatus.vm";
    public static final String FILE_NAME = "paymentDeliveryStatus.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(PaymentDeliveryStatusDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public PaymentDeliveryStatus findByReferenceEntity(PaymentDeliveryStatus t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(PaymentDeliveryStatus.class,PaymentDeliveryStatusHistory.class, PaymentDeliveryStatusHistoryCriteria.class, PaymentDeliveryStatusSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public PaymentDeliveryStatusAdminServiceImpl(PaymentDeliveryStatusDao dao, PaymentDeliveryStatusHistoryDao historyDao) {
        super(dao, historyDao);
    }

}