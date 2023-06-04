package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.Reception;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.Reception;
import java.util.List;


@Repository
public interface ReceptionDao extends AbstractRepository<Reception,Long>  {
    Reception findByReference(String reference);
    int deleteByReference(String reference);

    List<Reception> findByOrderId(Long id);
    int deleteByOrderId(Long id);
    List<Reception> findByReceptionStatusId(Long id);
    int deleteByReceptionStatusId(Long id);

    @Query("SELECT NEW Reception(item.id,item.reference) FROM Reception item")
    List<Reception> findAllOptimized();
}
