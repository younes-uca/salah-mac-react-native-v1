package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.Demand;
import ma.sir.ecom.bean.history.DemandHistory;
import ma.sir.ecom.dao.criteria.core.DemandCriteria;
import ma.sir.ecom.dao.criteria.history.DemandHistoryCriteria;
import ma.sir.ecom.dao.facade.core.DemandDao;
import ma.sir.ecom.dao.facade.history.DemandHistoryDao;
import ma.sir.ecom.dao.specification.core.DemandSpecification;
import ma.sir.ecom.service.facade.admin.DemandAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.DemandDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.ecom.bean.core.DemandItem;

import ma.sir.ecom.service.facade.admin.ClientAdminService ;
import ma.sir.ecom.service.facade.admin.DemandStatusAdminService ;
import ma.sir.ecom.service.facade.admin.DemandItemAdminService ;


import java.util.List;
@Service
public class DemandAdminServiceImpl extends AbstractServiceImpl<Demand,DemandHistory, DemandCriteria, DemandHistoryCriteria, DemandDao,
DemandHistoryDao> implements DemandAdminService {
    public static final String TEMPLATE = "template/demand.vm";
    public static final String FILE_NAME = "demand.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(DemandDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Demand create(Demand t) {
        super.create(t);
        if (t.getDemandItems() != null) {
                t.getDemandItems().forEach(element-> {
                    element.setDemand(t);
                    demandItemService.create(element);
            });
        }
        return t;
    }

    public Demand findWithAssociatedLists(Long id){
        Demand result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setDemandItems(demandItemService.findByDemandId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        demandItemService.deleteByDemandId(id);
    }


    public void updateWithAssociatedLists(Demand demand){
    if(demand !=null && demand.getId() != null){
            List<List<DemandItem>> resultDemandItems= demandItemService.getToBeSavedAndToBeDeleted(demandItemService.findByDemandId(demand.getId()),demand.getDemandItems());
            demandItemService.delete(resultDemandItems.get(1));
            ListUtil.emptyIfNull(resultDemandItems.get(0)).forEach(e -> e.setDemand(demand));
            demandItemService.update(resultDemandItems.get(0),true);
    }
    }

    public Demand findByReferenceEntity(Demand t){
        return  dao.findByReference(t.getReference());
    }

    public List<Demand> findByClientId(Long id){
        return dao.findByClientId(id);
    }
    public int deleteByClientId(Long id){
        return dao.deleteByClientId(id);
    }
    public List<Demand> findByDemandStatusId(Long id){
        return dao.findByDemandStatusId(id);
    }
    public int deleteByDemandStatusId(Long id){
        return dao.deleteByDemandStatusId(id);
    }




    public void configure() {
        super.configure(Demand.class,DemandHistory.class, DemandHistoryCriteria.class, DemandSpecification.class);
    }

    @Autowired
    private ClientAdminService clientService ;
    @Autowired
    private DemandStatusAdminService demandStatusService ;
    @Autowired
    private DemandItemAdminService demandItemService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public DemandAdminServiceImpl(DemandDao dao, DemandHistoryDao historyDao) {
        super(dao, historyDao);
    }

}