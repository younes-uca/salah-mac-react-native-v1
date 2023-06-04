package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.LatePaymentRate;
import ma.sir.ecom.bean.history.LatePaymentRateHistory;
import ma.sir.ecom.dao.criteria.core.LatePaymentRateCriteria;
import ma.sir.ecom.dao.criteria.history.LatePaymentRateHistoryCriteria;
import ma.sir.ecom.dao.facade.core.LatePaymentRateDao;
import ma.sir.ecom.dao.facade.history.LatePaymentRateHistoryDao;
import ma.sir.ecom.dao.specification.core.LatePaymentRateSpecification;
import ma.sir.ecom.service.facade.admin.LatePaymentRateAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.LatePaymentRateDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class LatePaymentRateAdminServiceImpl extends AbstractServiceImpl<LatePaymentRate,LatePaymentRateHistory, LatePaymentRateCriteria, LatePaymentRateHistoryCriteria, LatePaymentRateDao,
LatePaymentRateHistoryDao> implements LatePaymentRateAdminService {
    public static final String TEMPLATE = "template/latePaymentRate.vm";
    public static final String FILE_NAME = "latePaymentRate.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(LatePaymentRateDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }







    public void configure() {
        super.configure(LatePaymentRate.class,LatePaymentRateHistory.class, LatePaymentRateHistoryCriteria.class, LatePaymentRateSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public LatePaymentRateAdminServiceImpl(LatePaymentRateDao dao, LatePaymentRateHistoryDao historyDao) {
        super(dao, historyDao);
    }

}