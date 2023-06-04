package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.BalanceSheetStatus;
import ma.sir.ecom.bean.history.BalanceSheetStatusHistory;
import ma.sir.ecom.dao.criteria.core.BalanceSheetStatusCriteria;
import ma.sir.ecom.dao.criteria.history.BalanceSheetStatusHistoryCriteria;
import ma.sir.ecom.dao.facade.core.BalanceSheetStatusDao;
import ma.sir.ecom.dao.facade.history.BalanceSheetStatusHistoryDao;
import ma.sir.ecom.dao.specification.core.BalanceSheetStatusSpecification;
import ma.sir.ecom.service.facade.admin.BalanceSheetStatusAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.BalanceSheetStatusDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class BalanceSheetStatusAdminServiceImpl extends AbstractServiceImpl<BalanceSheetStatus,BalanceSheetStatusHistory, BalanceSheetStatusCriteria, BalanceSheetStatusHistoryCriteria, BalanceSheetStatusDao,
BalanceSheetStatusHistoryDao> implements BalanceSheetStatusAdminService {
    public static final String TEMPLATE = "template/balanceSheetStatus.vm";
    public static final String FILE_NAME = "balanceSheetStatus.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(BalanceSheetStatusDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public BalanceSheetStatus findByReferenceEntity(BalanceSheetStatus t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(BalanceSheetStatus.class,BalanceSheetStatusHistory.class, BalanceSheetStatusHistoryCriteria.class, BalanceSheetStatusSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public BalanceSheetStatusAdminServiceImpl(BalanceSheetStatusDao dao, BalanceSheetStatusHistoryDao historyDao) {
        super(dao, historyDao);
    }

}