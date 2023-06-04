package ma.sir.ecom.dao.facade.core;

import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.SaleItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface SaleItemDao extends AbstractRepository<SaleItem,Long>  {

    List<SaleItem> findByProductId(Long id);
    int deleteByProductId(Long id);
    List<SaleItem> findBySaleId(Long id);
    int deleteBySaleId(Long id);

}
