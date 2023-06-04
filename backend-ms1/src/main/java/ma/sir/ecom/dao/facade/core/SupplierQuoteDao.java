package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.SupplierQuote;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.SupplierQuote;
import java.util.List;


@Repository
public interface SupplierQuoteDao extends AbstractRepository<SupplierQuote,Long>  {
    SupplierQuote findByReference(String reference);
    int deleteByReference(String reference);

    List<SupplierQuote> findBySupplierId(Long id);
    int deleteBySupplierId(Long id);

    @Query("SELECT NEW SupplierQuote(item.id,item.reference) FROM SupplierQuote item")
    List<SupplierQuote> findAllOptimized();
}
