package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.AccountingAccount;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.AccountingAccount;
import java.util.List;


@Repository
public interface AccountingAccountDao extends AbstractRepository<AccountingAccount,Long>  {
    AccountingAccount findByCode(String code);
    int deleteByCode(String code);

    List<AccountingAccount> findBySubAccountingClassId(Long id);
    int deleteBySubAccountingClassId(Long id);

    @Query("SELECT NEW AccountingAccount(item.id,item.libelle) FROM AccountingAccount item")
    List<AccountingAccount> findAllOptimized();
}
