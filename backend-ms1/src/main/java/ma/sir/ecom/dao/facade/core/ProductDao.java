package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.Product;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.Product;
import java.util.List;


@Repository
public interface ProductDao extends AbstractRepository<Product,Long>  {
    Product findByReference(String reference);
    int deleteByReference(String reference);

    List<Product> findByProductCategoryId(Long id);
    int deleteByProductCategoryId(Long id);
    List<Product> findByMeasurementUnitId(Long id);
    int deleteByMeasurementUnitId(Long id);
    List<Product> findByBrandId(Long id);
    int deleteByBrandId(Long id);
    List<Product> findByStoreId(Long id);
    int deleteByStoreId(Long id);

    @Query("SELECT NEW Product(item.id,item.libelle) FROM Product item")
    List<Product> findAllOptimized();
}
