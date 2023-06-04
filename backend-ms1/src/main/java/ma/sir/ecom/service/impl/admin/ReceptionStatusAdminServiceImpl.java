package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.ReceptionStatus;
import ma.sir.ecom.bean.history.ReceptionStatusHistory;
import ma.sir.ecom.dao.criteria.core.ReceptionStatusCriteria;
import ma.sir.ecom.dao.criteria.history.ReceptionStatusHistoryCriteria;
import ma.sir.ecom.dao.facade.core.ReceptionStatusDao;
import ma.sir.ecom.dao.facade.history.ReceptionStatusHistoryDao;
import ma.sir.ecom.dao.specification.core.ReceptionStatusSpecification;
import ma.sir.ecom.service.facade.admin.ReceptionStatusAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.ReceptionStatusDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class ReceptionStatusAdminServiceImpl extends AbstractServiceImpl<ReceptionStatus,ReceptionStatusHistory, ReceptionStatusCriteria, ReceptionStatusHistoryCriteria, ReceptionStatusDao,
ReceptionStatusHistoryDao> implements ReceptionStatusAdminService {
    public static final String TEMPLATE = "template/receptionStatus.vm";
    public static final String FILE_NAME = "receptionStatus.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(ReceptionStatusDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public ReceptionStatus findByReferenceEntity(ReceptionStatus t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(ReceptionStatus.class,ReceptionStatusHistory.class, ReceptionStatusHistoryCriteria.class, ReceptionStatusSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public ReceptionStatusAdminServiceImpl(ReceptionStatusDao dao, ReceptionStatusHistoryDao historyDao) {
        super(dao, historyDao);
    }

}