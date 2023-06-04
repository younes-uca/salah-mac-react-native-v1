package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.ReturnStatus;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.ReturnStatus;
import java.util.List;


@Repository
public interface ReturnStatusDao extends AbstractRepository<ReturnStatus,Long>  {
    ReturnStatus findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW ReturnStatus(item.id,item.libelle) FROM ReturnStatus item")
    List<ReturnStatus> findAllOptimized();
}
