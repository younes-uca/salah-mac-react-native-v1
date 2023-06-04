package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.BalanceSheet;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.BalanceSheet;
import java.util.List;


@Repository
public interface BalanceSheetDao extends AbstractRepository<BalanceSheet,Long>  {
    BalanceSheet findByRef(String ref);
    int deleteByRef(String ref);

    List<BalanceSheet> findByCompanyId(Long id);
    int deleteByCompanyId(Long id);
    List<BalanceSheet> findByBalanceSheetStatusId(Long id);
    int deleteByBalanceSheetStatusId(Long id);

    @Query("SELECT NEW BalanceSheet(item.id,item.ref) FROM BalanceSheet item")
    List<BalanceSheet> findAllOptimized();
}
