package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.Brand;
import ma.sir.ecom.bean.history.BrandHistory;
import ma.sir.ecom.dao.criteria.core.BrandCriteria;
import ma.sir.ecom.dao.criteria.history.BrandHistoryCriteria;
import ma.sir.ecom.dao.facade.core.BrandDao;
import ma.sir.ecom.dao.facade.history.BrandHistoryDao;
import ma.sir.ecom.dao.specification.core.BrandSpecification;
import ma.sir.ecom.service.facade.admin.BrandAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.BrandDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class BrandAdminServiceImpl extends AbstractServiceImpl<Brand,BrandHistory, BrandCriteria, BrandHistoryCriteria, BrandDao,
BrandHistoryDao> implements BrandAdminService {
    public static final String TEMPLATE = "template/brand.vm";
    public static final String FILE_NAME = "brand.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(BrandDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public Brand findByReferenceEntity(Brand t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(Brand.class,BrandHistory.class, BrandHistoryCriteria.class, BrandSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public BrandAdminServiceImpl(BrandDao dao, BrandHistoryDao historyDao) {
        super(dao, historyDao);
    }

}