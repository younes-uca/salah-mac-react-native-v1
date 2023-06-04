package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.PaymentMode;
import ma.sir.ecom.bean.history.PaymentModeHistory;
import ma.sir.ecom.dao.criteria.core.PaymentModeCriteria;
import ma.sir.ecom.dao.criteria.history.PaymentModeHistoryCriteria;
import ma.sir.ecom.dao.facade.core.PaymentModeDao;
import ma.sir.ecom.dao.facade.history.PaymentModeHistoryDao;
import ma.sir.ecom.dao.specification.core.PaymentModeSpecification;
import ma.sir.ecom.service.facade.admin.PaymentModeAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.PaymentModeDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class PaymentModeAdminServiceImpl extends AbstractServiceImpl<PaymentMode,PaymentModeHistory, PaymentModeCriteria, PaymentModeHistoryCriteria, PaymentModeDao,
PaymentModeHistoryDao> implements PaymentModeAdminService {
    public static final String TEMPLATE = "template/paymentMode.vm";
    public static final String FILE_NAME = "paymentMode.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(PaymentModeDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public PaymentMode findByReferenceEntity(PaymentMode t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(PaymentMode.class,PaymentModeHistory.class, PaymentModeHistoryCriteria.class, PaymentModeSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public PaymentModeAdminServiceImpl(PaymentModeDao dao, PaymentModeHistoryDao historyDao) {
        super(dao, historyDao);
    }

}