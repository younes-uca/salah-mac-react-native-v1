package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.CheckOwner;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.CheckOwner;
import java.util.List;


@Repository
public interface CheckOwnerDao extends AbstractRepository<CheckOwner,Long>  {
    CheckOwner findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW CheckOwner(item.id,item.name) FROM CheckOwner item")
    List<CheckOwner> findAllOptimized();
}
