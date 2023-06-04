package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.ProductCategory;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.ProductCategory;
import java.util.List;


@Repository
public interface ProductCategoryDao extends AbstractRepository<ProductCategory,Long>  {
    ProductCategory findByReference(String reference);
    int deleteByReference(String reference);


    @Query("SELECT NEW ProductCategory(item.id,item.libelle) FROM ProductCategory item")
    List<ProductCategory> findAllOptimized();
}
