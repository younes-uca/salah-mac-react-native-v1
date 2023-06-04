package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.ReturnStatus;
import ma.sir.ecom.bean.history.ReturnStatusHistory;
import ma.sir.ecom.dao.criteria.core.ReturnStatusCriteria;
import ma.sir.ecom.dao.criteria.history.ReturnStatusHistoryCriteria;
import ma.sir.ecom.dao.facade.core.ReturnStatusDao;
import ma.sir.ecom.dao.facade.history.ReturnStatusHistoryDao;
import ma.sir.ecom.dao.specification.core.ReturnStatusSpecification;
import ma.sir.ecom.service.facade.admin.ReturnStatusAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.ReturnStatusDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class ReturnStatusAdminServiceImpl extends AbstractServiceImpl<ReturnStatus,ReturnStatusHistory, ReturnStatusCriteria, ReturnStatusHistoryCriteria, ReturnStatusDao,
ReturnStatusHistoryDao> implements ReturnStatusAdminService {
    public static final String TEMPLATE = "template/returnStatus.vm";
    public static final String FILE_NAME = "returnStatus.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(ReturnStatusDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public ReturnStatus findByReferenceEntity(ReturnStatus t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(ReturnStatus.class,ReturnStatusHistory.class, ReturnStatusHistoryCriteria.class, ReturnStatusSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public ReturnStatusAdminServiceImpl(ReturnStatusDao dao, ReturnStatusHistoryDao historyDao) {
        super(dao, historyDao);
    }

}