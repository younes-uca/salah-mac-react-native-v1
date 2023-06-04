package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.SaleStatus;
import ma.sir.ecom.bean.history.SaleStatusHistory;
import ma.sir.ecom.dao.criteria.core.SaleStatusCriteria;
import ma.sir.ecom.dao.criteria.history.SaleStatusHistoryCriteria;
import ma.sir.ecom.dao.facade.core.SaleStatusDao;
import ma.sir.ecom.dao.facade.history.SaleStatusHistoryDao;
import ma.sir.ecom.dao.specification.core.SaleStatusSpecification;
import ma.sir.ecom.service.facade.admin.SaleStatusAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.SaleStatusDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class SaleStatusAdminServiceImpl extends AbstractServiceImpl<SaleStatus,SaleStatusHistory, SaleStatusCriteria, SaleStatusHistoryCriteria, SaleStatusDao,
SaleStatusHistoryDao> implements SaleStatusAdminService {
    public static final String TEMPLATE = "template/saleStatus.vm";
    public static final String FILE_NAME = "saleStatus.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(SaleStatusDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public SaleStatus findByReferenceEntity(SaleStatus t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(SaleStatus.class,SaleStatusHistory.class, SaleStatusHistoryCriteria.class, SaleStatusSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public SaleStatusAdminServiceImpl(SaleStatusDao dao, SaleStatusHistoryDao historyDao) {
        super(dao, historyDao);
    }

}