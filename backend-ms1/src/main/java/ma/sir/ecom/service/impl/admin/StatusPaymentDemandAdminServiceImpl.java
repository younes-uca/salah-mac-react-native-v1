package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.StatusPaymentDemand;
import ma.sir.ecom.bean.history.StatusPaymentDemandHistory;
import ma.sir.ecom.dao.criteria.core.StatusPaymentDemandCriteria;
import ma.sir.ecom.dao.criteria.history.StatusPaymentDemandHistoryCriteria;
import ma.sir.ecom.dao.facade.core.StatusPaymentDemandDao;
import ma.sir.ecom.dao.facade.history.StatusPaymentDemandHistoryDao;
import ma.sir.ecom.dao.specification.core.StatusPaymentDemandSpecification;
import ma.sir.ecom.service.facade.admin.StatusPaymentDemandAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.StatusPaymentDemandDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class StatusPaymentDemandAdminServiceImpl extends AbstractServiceImpl<StatusPaymentDemand,StatusPaymentDemandHistory, StatusPaymentDemandCriteria, StatusPaymentDemandHistoryCriteria, StatusPaymentDemandDao,
StatusPaymentDemandHistoryDao> implements StatusPaymentDemandAdminService {
    public static final String TEMPLATE = "template/statusPaymentDemand.vm";
    public static final String FILE_NAME = "statusPaymentDemand.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(StatusPaymentDemandDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public StatusPaymentDemand findByReferenceEntity(StatusPaymentDemand t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(StatusPaymentDemand.class,StatusPaymentDemandHistory.class, StatusPaymentDemandHistoryCriteria.class, StatusPaymentDemandSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public StatusPaymentDemandAdminServiceImpl(StatusPaymentDemandDao dao, StatusPaymentDemandHistoryDao historyDao) {
        super(dao, historyDao);
    }

}