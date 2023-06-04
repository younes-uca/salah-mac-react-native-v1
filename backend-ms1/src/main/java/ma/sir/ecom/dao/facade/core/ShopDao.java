package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.Shop;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.Shop;
import java.util.List;


@Repository
public interface ShopDao extends AbstractRepository<Shop,Long>  {
    Shop findByReference(String reference);
    int deleteByReference(String reference);

    List<Shop> findByStoreId(Long id);
    int deleteByStoreId(Long id);

    @Query("SELECT NEW Shop(item.id,item.reference) FROM Shop item")
    List<Shop> findAllOptimized();
}
