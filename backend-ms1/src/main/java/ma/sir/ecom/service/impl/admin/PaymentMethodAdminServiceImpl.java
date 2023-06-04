package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.PaymentMethod;
import ma.sir.ecom.bean.history.PaymentMethodHistory;
import ma.sir.ecom.dao.criteria.core.PaymentMethodCriteria;
import ma.sir.ecom.dao.criteria.history.PaymentMethodHistoryCriteria;
import ma.sir.ecom.dao.facade.core.PaymentMethodDao;
import ma.sir.ecom.dao.facade.history.PaymentMethodHistoryDao;
import ma.sir.ecom.dao.specification.core.PaymentMethodSpecification;
import ma.sir.ecom.service.facade.admin.PaymentMethodAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.PaymentMethodDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class PaymentMethodAdminServiceImpl extends AbstractServiceImpl<PaymentMethod,PaymentMethodHistory, PaymentMethodCriteria, PaymentMethodHistoryCriteria, PaymentMethodDao,
PaymentMethodHistoryDao> implements PaymentMethodAdminService {
    public static final String TEMPLATE = "template/paymentMethod.vm";
    public static final String FILE_NAME = "paymentMethod.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(PaymentMethodDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public PaymentMethod findByReferenceEntity(PaymentMethod t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(PaymentMethod.class,PaymentMethodHistory.class, PaymentMethodHistoryCriteria.class, PaymentMethodSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public PaymentMethodAdminServiceImpl(PaymentMethodDao dao, PaymentMethodHistoryDao historyDao) {
        super(dao, historyDao);
    }

}