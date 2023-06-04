package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.CheckOwner;
import ma.sir.ecom.bean.history.CheckOwnerHistory;
import ma.sir.ecom.dao.criteria.core.CheckOwnerCriteria;
import ma.sir.ecom.dao.criteria.history.CheckOwnerHistoryCriteria;
import ma.sir.ecom.dao.facade.core.CheckOwnerDao;
import ma.sir.ecom.dao.facade.history.CheckOwnerHistoryDao;
import ma.sir.ecom.dao.specification.core.CheckOwnerSpecification;
import ma.sir.ecom.service.facade.admin.CheckOwnerAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.CheckOwnerDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class CheckOwnerAdminServiceImpl extends AbstractServiceImpl<CheckOwner,CheckOwnerHistory, CheckOwnerCriteria, CheckOwnerHistoryCriteria, CheckOwnerDao,
CheckOwnerHistoryDao> implements CheckOwnerAdminService {
    public static final String TEMPLATE = "template/checkOwner.vm";
    public static final String FILE_NAME = "checkOwner.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(CheckOwnerDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public CheckOwner findByReferenceEntity(CheckOwner t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(CheckOwner.class,CheckOwnerHistory.class, CheckOwnerHistoryCriteria.class, CheckOwnerSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public CheckOwnerAdminServiceImpl(CheckOwnerDao dao, CheckOwnerHistoryDao historyDao) {
        super(dao, historyDao);
    }

}