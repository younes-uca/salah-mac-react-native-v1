package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.PaymentStatus;
import ma.sir.ecom.bean.history.PaymentStatusHistory;
import ma.sir.ecom.dao.criteria.core.PaymentStatusCriteria;
import ma.sir.ecom.dao.criteria.history.PaymentStatusHistoryCriteria;
import ma.sir.ecom.dao.facade.core.PaymentStatusDao;
import ma.sir.ecom.dao.facade.history.PaymentStatusHistoryDao;
import ma.sir.ecom.dao.specification.core.PaymentStatusSpecification;
import ma.sir.ecom.service.facade.admin.PaymentStatusAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.PaymentStatusDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class PaymentStatusAdminServiceImpl extends AbstractServiceImpl<PaymentStatus,PaymentStatusHistory, PaymentStatusCriteria, PaymentStatusHistoryCriteria, PaymentStatusDao,
PaymentStatusHistoryDao> implements PaymentStatusAdminService {
    public static final String TEMPLATE = "template/paymentStatus.vm";
    public static final String FILE_NAME = "paymentStatus.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(PaymentStatusDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public PaymentStatus findByReferenceEntity(PaymentStatus t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(PaymentStatus.class,PaymentStatusHistory.class, PaymentStatusHistoryCriteria.class, PaymentStatusSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public PaymentStatusAdminServiceImpl(PaymentStatusDao dao, PaymentStatusHistoryDao historyDao) {
        super(dao, historyDao);
    }

}