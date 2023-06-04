package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.AccountingOperation;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AccountingOperationDao extends AbstractRepository<AccountingOperation,Long>  {

    List<AccountingOperation> findByCompanyId(Long id);
    int deleteByCompanyId(Long id);
    List<AccountingOperation> findByAccountingAccountId(Long id);
    int deleteByAccountingAccountId(Long id);
    List<AccountingOperation> findByAccountingOperationTypeId(Long id);
    int deleteByAccountingOperationTypeId(Long id);
    List<AccountingOperation> findByAccountingOperationStatusId(Long id);
    int deleteByAccountingOperationStatusId(Long id);

    @Query("SELECT NEW AccountingOperation(item.id,item.libelle) FROM AccountingOperation item")
    List<AccountingOperation> findAllOptimized();
}
