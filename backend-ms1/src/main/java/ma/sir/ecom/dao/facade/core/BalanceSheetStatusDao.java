package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.BalanceSheetStatus;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.BalanceSheetStatus;
import java.util.List;


@Repository
public interface BalanceSheetStatusDao extends AbstractRepository<BalanceSheetStatus,Long>  {
    BalanceSheetStatus findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW BalanceSheetStatus(item.id,item.libelle) FROM BalanceSheetStatus item")
    List<BalanceSheetStatus> findAllOptimized();
}
