package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.Shop;
import ma.sir.ecom.dao.criteria.core.ShopCriteria;
import ma.sir.ecom.dao.criteria.history.ShopHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.ShopDto;
import org.springframework.http.HttpEntity;

public interface ShopAdminService extends  IService<Shop,ShopCriteria, ShopHistoryCriteria>  {

    List<Shop> findByStoreId(Long id);
    int deleteByStoreId(Long id);

    HttpEntity<byte[]> createPdf(ShopDto dto) throws Exception;


}
