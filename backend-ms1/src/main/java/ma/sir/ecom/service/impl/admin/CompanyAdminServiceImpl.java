package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.Company;
import ma.sir.ecom.bean.history.CompanyHistory;
import ma.sir.ecom.dao.criteria.core.CompanyCriteria;
import ma.sir.ecom.dao.criteria.history.CompanyHistoryCriteria;
import ma.sir.ecom.dao.facade.core.CompanyDao;
import ma.sir.ecom.dao.facade.history.CompanyHistoryDao;
import ma.sir.ecom.dao.specification.core.CompanySpecification;
import ma.sir.ecom.service.facade.admin.CompanyAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.CompanyDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.ecom.bean.core.Store;

import ma.sir.ecom.service.facade.admin.StoreAdminService ;
import ma.sir.ecom.service.facade.admin.SubscriberAdminService ;


import java.util.List;
@Service
public class CompanyAdminServiceImpl extends AbstractServiceImpl<Company,CompanyHistory, CompanyCriteria, CompanyHistoryCriteria, CompanyDao,
CompanyHistoryDao> implements CompanyAdminService {
    public static final String TEMPLATE = "template/company.vm";
    public static final String FILE_NAME = "company.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(CompanyDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Company create(Company t) {
        super.create(t);
        if (t.getStores() != null) {
                t.getStores().forEach(element-> {
                    element.setCompany(t);
                    storeService.create(element);
            });
        }
        return t;
    }

    public Company findWithAssociatedLists(Long id){
        Company result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setStores(storeService.findByCompanyId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        storeService.deleteByCompanyId(id);
    }


    public void updateWithAssociatedLists(Company company){
    if(company !=null && company.getId() != null){
            List<List<Store>> resultStores= storeService.getToBeSavedAndToBeDeleted(storeService.findByCompanyId(company.getId()),company.getStores());
            storeService.delete(resultStores.get(1));
            ListUtil.emptyIfNull(resultStores.get(0)).forEach(e -> e.setCompany(company));
            storeService.update(resultStores.get(0),true);
    }
    }

    public Company findByReferenceEntity(Company t){
        return  dao.findByIce(t.getIce());
    }

    public List<Company> findBySubscriberId(Long id){
        return dao.findBySubscriberId(id);
    }
    public int deleteBySubscriberId(Long id){
        return dao.deleteBySubscriberId(id);
    }




    public void configure() {
        super.configure(Company.class,CompanyHistory.class, CompanyHistoryCriteria.class, CompanySpecification.class);
    }

    @Autowired
    private StoreAdminService storeService ;
    @Autowired
    private SubscriberAdminService subscriberService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public CompanyAdminServiceImpl(CompanyDao dao, CompanyHistoryDao historyDao) {
        super(dao, historyDao);
    }

}