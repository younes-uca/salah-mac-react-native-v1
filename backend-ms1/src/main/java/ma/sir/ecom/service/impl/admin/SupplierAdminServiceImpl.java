package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.Supplier;
import ma.sir.ecom.bean.history.SupplierHistory;
import ma.sir.ecom.dao.criteria.core.SupplierCriteria;
import ma.sir.ecom.dao.criteria.history.SupplierHistoryCriteria;
import ma.sir.ecom.dao.facade.core.SupplierDao;
import ma.sir.ecom.dao.facade.history.SupplierHistoryDao;
import ma.sir.ecom.dao.specification.core.SupplierSpecification;
import ma.sir.ecom.service.facade.admin.SupplierAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.SupplierDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class SupplierAdminServiceImpl extends AbstractServiceImpl<Supplier,SupplierHistory, SupplierCriteria, SupplierHistoryCriteria, SupplierDao,
SupplierHistoryDao> implements SupplierAdminService {
    public static final String TEMPLATE = "template/supplier.vm";
    public static final String FILE_NAME = "supplier.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(SupplierDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public Supplier findByReferenceEntity(Supplier t){
        return  dao.findByIce(t.getIce());
    }





    public void configure() {
        super.configure(Supplier.class,SupplierHistory.class, SupplierHistoryCriteria.class, SupplierSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public SupplierAdminServiceImpl(SupplierDao dao, SupplierHistoryDao historyDao) {
        super(dao, historyDao);
    }

}