package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.Shop;
import ma.sir.ecom.bean.history.ShopHistory;
import ma.sir.ecom.dao.criteria.core.ShopCriteria;
import ma.sir.ecom.dao.criteria.history.ShopHistoryCriteria;
import ma.sir.ecom.dao.facade.core.ShopDao;
import ma.sir.ecom.dao.facade.history.ShopHistoryDao;
import ma.sir.ecom.dao.specification.core.ShopSpecification;
import ma.sir.ecom.service.facade.admin.ShopAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.ShopDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ecom.service.facade.admin.StoreAdminService ;


import java.util.List;
@Service
public class ShopAdminServiceImpl extends AbstractServiceImpl<Shop,ShopHistory, ShopCriteria, ShopHistoryCriteria, ShopDao,
ShopHistoryDao> implements ShopAdminService {
    public static final String TEMPLATE = "template/shop.vm";
    public static final String FILE_NAME = "shop.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(ShopDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public Shop findByReferenceEntity(Shop t){
        return  dao.findByReference(t.getReference());
    }

    public List<Shop> findByStoreId(Long id){
        return dao.findByStoreId(id);
    }
    public int deleteByStoreId(Long id){
        return dao.deleteByStoreId(id);
    }




    public void configure() {
        super.configure(Shop.class,ShopHistory.class, ShopHistoryCriteria.class, ShopSpecification.class);
    }

    @Autowired
    private StoreAdminService storeService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public ShopAdminServiceImpl(ShopDao dao, ShopHistoryDao historyDao) {
        super(dao, historyDao);
    }

}