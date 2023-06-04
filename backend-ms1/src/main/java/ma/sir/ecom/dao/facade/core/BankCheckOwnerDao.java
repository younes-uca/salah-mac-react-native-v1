package ma.sir.ecom.dao.facade.core;

import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.BankCheckOwner;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface BankCheckOwnerDao extends AbstractRepository<BankCheckOwner,Long>  {

    List<BankCheckOwner> findByCheckOwnerId(Long id);
    int deleteByCheckOwnerId(Long id);
    List<BankCheckOwner> findByBankId(Long id);
    int deleteByBankId(Long id);

}
