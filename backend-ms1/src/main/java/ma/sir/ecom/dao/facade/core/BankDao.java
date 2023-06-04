package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.Bank;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.Bank;
import java.util.List;


@Repository
public interface BankDao extends AbstractRepository<Bank,Long>  {
    Bank findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW Bank(item.id,item.libelle) FROM Bank item")
    List<Bank> findAllOptimized();
}
