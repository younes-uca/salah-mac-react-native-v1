package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.Subscriber;
import ma.sir.ecom.bean.history.SubscriberHistory;
import ma.sir.ecom.dao.criteria.core.SubscriberCriteria;
import ma.sir.ecom.dao.criteria.history.SubscriberHistoryCriteria;
import ma.sir.ecom.dao.facade.core.SubscriberDao;
import ma.sir.ecom.dao.facade.history.SubscriberHistoryDao;
import ma.sir.ecom.dao.specification.core.SubscriberSpecification;
import ma.sir.ecom.service.facade.admin.SubscriberAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.SubscriberDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.ecom.bean.core.Company;

import ma.sir.ecom.service.facade.admin.CompanyAdminService ;


import java.util.List;
@Service
public class SubscriberAdminServiceImpl extends AbstractServiceImpl<Subscriber,SubscriberHistory, SubscriberCriteria, SubscriberHistoryCriteria, SubscriberDao,
SubscriberHistoryDao> implements SubscriberAdminService {
    public static final String TEMPLATE = "template/subscriber.vm";
    public static final String FILE_NAME = "subscriber.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(SubscriberDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Subscriber create(Subscriber t) {
        super.create(t);
        if (t.getCompanys() != null) {
                t.getCompanys().forEach(element-> {
                    element.setSubscriber(t);
                    companyService.create(element);
            });
        }
        return t;
    }

    public Subscriber findWithAssociatedLists(Long id){
        Subscriber result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setCompanys(companyService.findBySubscriberId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        companyService.deleteBySubscriberId(id);
    }


    public void updateWithAssociatedLists(Subscriber subscriber){
    if(subscriber !=null && subscriber.getId() != null){
            List<List<Company>> resultCompanys= companyService.getToBeSavedAndToBeDeleted(companyService.findBySubscriberId(subscriber.getId()),subscriber.getCompanys());
            companyService.delete(resultCompanys.get(1));
            ListUtil.emptyIfNull(resultCompanys.get(0)).forEach(e -> e.setSubscriber(subscriber));
            companyService.update(resultCompanys.get(0),true);
    }
    }

    public Subscriber findByReferenceEntity(Subscriber t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(Subscriber.class,SubscriberHistory.class, SubscriberHistoryCriteria.class, SubscriberSpecification.class);
    }

    @Autowired
    private CompanyAdminService companyService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public SubscriberAdminServiceImpl(SubscriberDao dao, SubscriberHistoryDao historyDao) {
        super(dao, historyDao);
    }

}