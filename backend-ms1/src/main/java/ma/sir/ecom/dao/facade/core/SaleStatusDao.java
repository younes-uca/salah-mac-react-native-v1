package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.SaleStatus;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.SaleStatus;
import java.util.List;


@Repository
public interface SaleStatusDao extends AbstractRepository<SaleStatus,Long>  {
    SaleStatus findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW SaleStatus(item.id,item.libelle) FROM SaleStatus item")
    List<SaleStatus> findAllOptimized();
}
