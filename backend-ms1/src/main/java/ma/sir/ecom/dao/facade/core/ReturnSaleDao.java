package ma.sir.ecom.dao.facade.core;

import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.ReturnSale;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ReturnSaleDao extends AbstractRepository<ReturnSale,Long>  {

    List<ReturnSale> findBySaleId(Long id);
    int deleteBySaleId(Long id);
    List<ReturnSale> findByReturnStatusId(Long id);
    int deleteByReturnStatusId(Long id);

}
