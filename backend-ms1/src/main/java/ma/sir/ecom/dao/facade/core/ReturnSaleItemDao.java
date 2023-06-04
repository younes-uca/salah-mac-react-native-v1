package ma.sir.ecom.dao.facade.core;

import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.ReturnSaleItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ReturnSaleItemDao extends AbstractRepository<ReturnSaleItem,Long>  {

    List<ReturnSaleItem> findByProductId(Long id);
    int deleteByProductId(Long id);
    List<ReturnSaleItem> findByReturnSaleId(Long id);
    int deleteByReturnSaleId(Long id);

}
