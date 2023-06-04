package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.AccountingClass;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.AccountingClass;
import java.util.List;


@Repository
public interface AccountingClassDao extends AbstractRepository<AccountingClass,Long>  {
    AccountingClass findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW AccountingClass(item.id,item.libelle) FROM AccountingClass item")
    List<AccountingClass> findAllOptimized();
}
