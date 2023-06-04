package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.AccountingOperationStatus;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.AccountingOperationStatus;
import java.util.List;


@Repository
public interface AccountingOperationStatusDao extends AbstractRepository<AccountingOperationStatus,Long>  {
    AccountingOperationStatus findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW AccountingOperationStatus(item.id,item.libelle) FROM AccountingOperationStatus item")
    List<AccountingOperationStatus> findAllOptimized();
}
