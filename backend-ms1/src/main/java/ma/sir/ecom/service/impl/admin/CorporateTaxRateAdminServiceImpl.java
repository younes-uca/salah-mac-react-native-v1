package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.CorporateTaxRate;
import ma.sir.ecom.bean.history.CorporateTaxRateHistory;
import ma.sir.ecom.dao.criteria.core.CorporateTaxRateCriteria;
import ma.sir.ecom.dao.criteria.history.CorporateTaxRateHistoryCriteria;
import ma.sir.ecom.dao.facade.core.CorporateTaxRateDao;
import ma.sir.ecom.dao.facade.history.CorporateTaxRateHistoryDao;
import ma.sir.ecom.dao.specification.core.CorporateTaxRateSpecification;
import ma.sir.ecom.service.facade.admin.CorporateTaxRateAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.CorporateTaxRateDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class CorporateTaxRateAdminServiceImpl extends AbstractServiceImpl<CorporateTaxRate,CorporateTaxRateHistory, CorporateTaxRateCriteria, CorporateTaxRateHistoryCriteria, CorporateTaxRateDao,
CorporateTaxRateHistoryDao> implements CorporateTaxRateAdminService {
    public static final String TEMPLATE = "template/corporateTaxRate.vm";
    public static final String FILE_NAME = "corporateTaxRate.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(CorporateTaxRateDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }







    public void configure() {
        super.configure(CorporateTaxRate.class,CorporateTaxRateHistory.class, CorporateTaxRateHistoryCriteria.class, CorporateTaxRateSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public CorporateTaxRateAdminServiceImpl(CorporateTaxRateDao dao, CorporateTaxRateHistoryDao historyDao) {
        super(dao, historyDao);
    }

}