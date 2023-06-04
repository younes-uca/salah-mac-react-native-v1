package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.DemandItem;
import ma.sir.ecom.bean.history.DemandItemHistory;
import ma.sir.ecom.dao.criteria.core.DemandItemCriteria;
import ma.sir.ecom.dao.criteria.history.DemandItemHistoryCriteria;
import ma.sir.ecom.dao.facade.core.DemandItemDao;
import ma.sir.ecom.dao.facade.history.DemandItemHistoryDao;
import ma.sir.ecom.dao.specification.core.DemandItemSpecification;
import ma.sir.ecom.service.facade.admin.DemandItemAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.DemandItemDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ecom.service.facade.admin.ProductAdminService ;
import ma.sir.ecom.service.facade.admin.DemandAdminService ;


import java.util.List;
@Service
public class DemandItemAdminServiceImpl extends AbstractServiceImpl<DemandItem,DemandItemHistory, DemandItemCriteria, DemandItemHistoryCriteria, DemandItemDao,
DemandItemHistoryDao> implements DemandItemAdminService {
    public static final String TEMPLATE = "template/demandItem.vm";
    public static final String FILE_NAME = "demandItem.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(DemandItemDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }



    public List<DemandItem> findByProductId(Long id){
        return dao.findByProductId(id);
    }
    public int deleteByProductId(Long id){
        return dao.deleteByProductId(id);
    }
    public List<DemandItem> findByDemandId(Long id){
        return dao.findByDemandId(id);
    }
    public int deleteByDemandId(Long id){
        return dao.deleteByDemandId(id);
    }




    public void configure() {
        super.configure(DemandItem.class,DemandItemHistory.class, DemandItemHistoryCriteria.class, DemandItemSpecification.class);
    }

    @Autowired
    private ProductAdminService productService ;
    @Autowired
    private DemandAdminService demandService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public DemandItemAdminServiceImpl(DemandItemDao dao, DemandItemHistoryDao historyDao) {
        super(dao, historyDao);
    }

}