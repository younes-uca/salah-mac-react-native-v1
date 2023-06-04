package ma.sir.ecom.dao.facade.core;

import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.ProductStock;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ProductStockDao extends AbstractRepository<ProductStock,Long>  {

    List<ProductStock> findByShopId(Long id);
    int deleteByShopId(Long id);
    List<ProductStock> findByProductId(Long id);
    int deleteByProductId(Long id);

}
