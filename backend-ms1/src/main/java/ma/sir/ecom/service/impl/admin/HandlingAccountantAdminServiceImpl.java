package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.HandlingAccountant;
import ma.sir.ecom.bean.history.HandlingAccountantHistory;
import ma.sir.ecom.dao.criteria.core.HandlingAccountantCriteria;
import ma.sir.ecom.dao.criteria.history.HandlingAccountantHistoryCriteria;
import ma.sir.ecom.dao.facade.core.HandlingAccountantDao;
import ma.sir.ecom.dao.facade.history.HandlingAccountantHistoryDao;
import ma.sir.ecom.dao.specification.core.HandlingAccountantSpecification;
import ma.sir.ecom.service.facade.admin.HandlingAccountantAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.HandlingAccountantDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class HandlingAccountantAdminServiceImpl extends AbstractServiceImpl<HandlingAccountant,HandlingAccountantHistory, HandlingAccountantCriteria, HandlingAccountantHistoryCriteria, HandlingAccountantDao,
HandlingAccountantHistoryDao> implements HandlingAccountantAdminService {
    public static final String TEMPLATE = "template/handlingAccountant.vm";
    public static final String FILE_NAME = "handlingAccountant.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(HandlingAccountantDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public HandlingAccountant findByReferenceEntity(HandlingAccountant t){
        return  dao.findByCin(t.getCin());
    }





    public void configure() {
        super.configure(HandlingAccountant.class,HandlingAccountantHistory.class, HandlingAccountantHistoryCriteria.class, HandlingAccountantSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public HandlingAccountantAdminServiceImpl(HandlingAccountantDao dao, HandlingAccountantHistoryDao historyDao) {
        super(dao, historyDao);
    }

}