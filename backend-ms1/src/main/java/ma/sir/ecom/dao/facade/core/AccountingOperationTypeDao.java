package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.AccountingOperationType;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.AccountingOperationType;
import java.util.List;


@Repository
public interface AccountingOperationTypeDao extends AbstractRepository<AccountingOperationType,Long>  {
    AccountingOperationType findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW AccountingOperationType(item.id,item.libelle) FROM AccountingOperationType item")
    List<AccountingOperationType> findAllOptimized();
}
