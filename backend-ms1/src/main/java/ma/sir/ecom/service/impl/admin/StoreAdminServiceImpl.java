package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.Store;
import ma.sir.ecom.bean.history.StoreHistory;
import ma.sir.ecom.dao.criteria.core.StoreCriteria;
import ma.sir.ecom.dao.criteria.history.StoreHistoryCriteria;
import ma.sir.ecom.dao.facade.core.StoreDao;
import ma.sir.ecom.dao.facade.history.StoreHistoryDao;
import ma.sir.ecom.dao.specification.core.StoreSpecification;
import ma.sir.ecom.service.facade.admin.StoreAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.StoreDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ecom.service.facade.admin.CompanyAdminService ;


import java.util.List;
@Service
public class StoreAdminServiceImpl extends AbstractServiceImpl<Store,StoreHistory, StoreCriteria, StoreHistoryCriteria, StoreDao,
StoreHistoryDao> implements StoreAdminService {
    public static final String TEMPLATE = "template/store.vm";
    public static final String FILE_NAME = "store.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(StoreDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public Store findByReferenceEntity(Store t){
        return  dao.findByReference(t.getReference());
    }

    public List<Store> findByCompanyId(Long id){
        return dao.findByCompanyId(id);
    }
    public int deleteByCompanyId(Long id){
        return dao.deleteByCompanyId(id);
    }




    public void configure() {
        super.configure(Store.class,StoreHistory.class, StoreHistoryCriteria.class, StoreSpecification.class);
    }

    @Autowired
    private CompanyAdminService companyService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public StoreAdminServiceImpl(StoreDao dao, StoreHistoryDao historyDao) {
        super(dao, historyDao);
    }

}