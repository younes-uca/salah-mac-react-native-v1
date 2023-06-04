package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.DemandStatus;
import ma.sir.ecom.bean.history.DemandStatusHistory;
import ma.sir.ecom.dao.criteria.core.DemandStatusCriteria;
import ma.sir.ecom.dao.criteria.history.DemandStatusHistoryCriteria;
import ma.sir.ecom.dao.facade.core.DemandStatusDao;
import ma.sir.ecom.dao.facade.history.DemandStatusHistoryDao;
import ma.sir.ecom.dao.specification.core.DemandStatusSpecification;
import ma.sir.ecom.service.facade.admin.DemandStatusAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.DemandStatusDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class DemandStatusAdminServiceImpl extends AbstractServiceImpl<DemandStatus,DemandStatusHistory, DemandStatusCriteria, DemandStatusHistoryCriteria, DemandStatusDao,
DemandStatusHistoryDao> implements DemandStatusAdminService {
    public static final String TEMPLATE = "template/demandStatus.vm";
    public static final String FILE_NAME = "demandStatus.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(DemandStatusDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public DemandStatus findByReferenceEntity(DemandStatus t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(DemandStatus.class,DemandStatusHistory.class, DemandStatusHistoryCriteria.class, DemandStatusSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public DemandStatusAdminServiceImpl(DemandStatusDao dao, DemandStatusHistoryDao historyDao) {
        super(dao, historyDao);
    }

}