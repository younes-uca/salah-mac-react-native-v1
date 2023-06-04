package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.Reception;
import ma.sir.ecom.bean.history.ReceptionHistory;
import ma.sir.ecom.dao.criteria.core.ReceptionCriteria;
import ma.sir.ecom.dao.criteria.history.ReceptionHistoryCriteria;
import ma.sir.ecom.dao.facade.core.ReceptionDao;
import ma.sir.ecom.dao.facade.history.ReceptionHistoryDao;
import ma.sir.ecom.dao.specification.core.ReceptionSpecification;
import ma.sir.ecom.service.facade.admin.ReceptionAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.ReceptionDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.ecom.bean.core.ReceptionItem;

import ma.sir.ecom.service.facade.admin.ReceptionStatusAdminService ;
import ma.sir.ecom.service.facade.admin.OrderAdminService ;
import ma.sir.ecom.service.facade.admin.ReceptionItemAdminService ;


import java.util.List;
@Service
public class ReceptionAdminServiceImpl extends AbstractServiceImpl<Reception,ReceptionHistory, ReceptionCriteria, ReceptionHistoryCriteria, ReceptionDao,
ReceptionHistoryDao> implements ReceptionAdminService {
    public static final String TEMPLATE = "template/reception.vm";
    public static final String FILE_NAME = "reception.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(ReceptionDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Reception create(Reception t) {
        super.create(t);
        if (t.getReceptionItems() != null) {
                t.getReceptionItems().forEach(element-> {
                    element.setReception(t);
                    receptionItemService.create(element);
            });
        }
        return t;
    }

    public Reception findWithAssociatedLists(Long id){
        Reception result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setReceptionItems(receptionItemService.findByReceptionId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        receptionItemService.deleteByReceptionId(id);
    }


    public void updateWithAssociatedLists(Reception reception){
    if(reception !=null && reception.getId() != null){
            List<List<ReceptionItem>> resultReceptionItems= receptionItemService.getToBeSavedAndToBeDeleted(receptionItemService.findByReceptionId(reception.getId()),reception.getReceptionItems());
            receptionItemService.delete(resultReceptionItems.get(1));
            ListUtil.emptyIfNull(resultReceptionItems.get(0)).forEach(e -> e.setReception(reception));
            receptionItemService.update(resultReceptionItems.get(0),true);
    }
    }

    public Reception findByReferenceEntity(Reception t){
        return  dao.findByReference(t.getReference());
    }

    public List<Reception> findByOrderId(Long id){
        return dao.findByOrderId(id);
    }
    public int deleteByOrderId(Long id){
        return dao.deleteByOrderId(id);
    }
    public List<Reception> findByReceptionStatusId(Long id){
        return dao.findByReceptionStatusId(id);
    }
    public int deleteByReceptionStatusId(Long id){
        return dao.deleteByReceptionStatusId(id);
    }




    public void configure() {
        super.configure(Reception.class,ReceptionHistory.class, ReceptionHistoryCriteria.class, ReceptionSpecification.class);
    }

    @Autowired
    private ReceptionStatusAdminService receptionStatusService ;
    @Autowired
    private OrderAdminService orderService ;
    @Autowired
    private ReceptionItemAdminService receptionItemService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public ReceptionAdminServiceImpl(ReceptionDao dao, ReceptionHistoryDao historyDao) {
        super(dao, historyDao);
    }

}