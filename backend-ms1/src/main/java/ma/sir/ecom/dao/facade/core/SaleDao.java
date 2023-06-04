package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.Sale;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.Sale;
import java.util.List;


@Repository
public interface SaleDao extends AbstractRepository<Sale,Long>  {
    Sale findByReference(String reference);
    int deleteByReference(String reference);

    List<Sale> findByStoreId(Long id);
    int deleteByStoreId(Long id);
    List<Sale> findByClientId(Long id);
    int deleteByClientId(Long id);
    List<Sale> findBySaleStatusId(Long id);
    int deleteBySaleStatusId(Long id);

    @Query("SELECT NEW Sale(item.id,item.reference) FROM Sale item")
    List<Sale> findAllOptimized();
}
