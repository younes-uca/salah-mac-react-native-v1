package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.DeliveryStatus;
import ma.sir.ecom.bean.history.DeliveryStatusHistory;
import ma.sir.ecom.dao.criteria.core.DeliveryStatusCriteria;
import ma.sir.ecom.dao.criteria.history.DeliveryStatusHistoryCriteria;
import ma.sir.ecom.dao.facade.core.DeliveryStatusDao;
import ma.sir.ecom.dao.facade.history.DeliveryStatusHistoryDao;
import ma.sir.ecom.dao.specification.core.DeliveryStatusSpecification;
import ma.sir.ecom.service.facade.admin.DeliveryStatusAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.DeliveryStatusDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class DeliveryStatusAdminServiceImpl extends AbstractServiceImpl<DeliveryStatus,DeliveryStatusHistory, DeliveryStatusCriteria, DeliveryStatusHistoryCriteria, DeliveryStatusDao,
DeliveryStatusHistoryDao> implements DeliveryStatusAdminService {
    public static final String TEMPLATE = "template/deliveryStatus.vm";
    public static final String FILE_NAME = "deliveryStatus.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(DeliveryStatusDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public DeliveryStatus findByReferenceEntity(DeliveryStatus t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(DeliveryStatus.class,DeliveryStatusHistory.class, DeliveryStatusHistoryCriteria.class, DeliveryStatusSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public DeliveryStatusAdminServiceImpl(DeliveryStatusDao dao, DeliveryStatusHistoryDao historyDao) {
        super(dao, historyDao);
    }

}