package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.DemandPayment;
import ma.sir.ecom.bean.history.DemandPaymentHistory;
import ma.sir.ecom.dao.criteria.core.DemandPaymentCriteria;
import ma.sir.ecom.dao.criteria.history.DemandPaymentHistoryCriteria;
import ma.sir.ecom.dao.facade.core.DemandPaymentDao;
import ma.sir.ecom.dao.facade.history.DemandPaymentHistoryDao;
import ma.sir.ecom.dao.specification.core.DemandPaymentSpecification;
import ma.sir.ecom.service.facade.admin.DemandPaymentAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.DemandPaymentDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ecom.service.facade.admin.StatusPaymentDemandAdminService ;
import ma.sir.ecom.service.facade.admin.PaymentModeAdminService ;
import ma.sir.ecom.service.facade.admin.DemandAdminService ;


import java.util.List;
@Service
public class DemandPaymentAdminServiceImpl extends AbstractServiceImpl<DemandPayment,DemandPaymentHistory, DemandPaymentCriteria, DemandPaymentHistoryCriteria, DemandPaymentDao,
DemandPaymentHistoryDao> implements DemandPaymentAdminService {
    public static final String TEMPLATE = "template/demandPayment.vm";
    public static final String FILE_NAME = "demandPayment.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(DemandPaymentDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public DemandPayment findByReferenceEntity(DemandPayment t){
        return  dao.findByReference(t.getReference());
    }

    public List<DemandPayment> findByDemandId(Long id){
        return dao.findByDemandId(id);
    }
    public int deleteByDemandId(Long id){
        return dao.deleteByDemandId(id);
    }
    public List<DemandPayment> findByPaymentModeId(Long id){
        return dao.findByPaymentModeId(id);
    }
    public int deleteByPaymentModeId(Long id){
        return dao.deleteByPaymentModeId(id);
    }
    public List<DemandPayment> findByStatusPaymentDemandId(Long id){
        return dao.findByStatusPaymentDemandId(id);
    }
    public int deleteByStatusPaymentDemandId(Long id){
        return dao.deleteByStatusPaymentDemandId(id);
    }




    public void configure() {
        super.configure(DemandPayment.class,DemandPaymentHistory.class, DemandPaymentHistoryCriteria.class, DemandPaymentSpecification.class);
    }

    @Autowired
    private StatusPaymentDemandAdminService statusPaymentDemandService ;
    @Autowired
    private PaymentModeAdminService paymentModeService ;
    @Autowired
    private DemandAdminService demandService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public DemandPaymentAdminServiceImpl(DemandPaymentDao dao, DemandPaymentHistoryDao historyDao) {
        super(dao, historyDao);
    }

}