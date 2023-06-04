package ma.sir.ecom.dao.facade.core;

import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.ReceptionItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ReceptionItemDao extends AbstractRepository<ReceptionItem,Long>  {

    List<ReceptionItem> findByProductId(Long id);
    int deleteByProductId(Long id);
    List<ReceptionItem> findByStoreId(Long id);
    int deleteByStoreId(Long id);
    List<ReceptionItem> findByReceptionId(Long id);
    int deleteByReceptionId(Long id);

}
