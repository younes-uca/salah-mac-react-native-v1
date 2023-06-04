package ma.sir.ecom.dao.facade.core;

import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.SupplierQuoteItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface SupplierQuoteItemDao extends AbstractRepository<SupplierQuoteItem,Long>  {

    List<SupplierQuoteItem> findByProductId(Long id);
    int deleteByProductId(Long id);
    List<SupplierQuoteItem> findBySupplierQuoteId(Long id);
    int deleteBySupplierQuoteId(Long id);

}
