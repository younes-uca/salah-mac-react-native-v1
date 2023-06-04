package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.ValidationAccountant;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.ValidationAccountant;
import java.util.List;


@Repository
public interface ValidationAccountantDao extends AbstractRepository<ValidationAccountant,Long>  {
    ValidationAccountant findByCin(String cin);
    int deleteByCin(String cin);


    @Query("SELECT NEW ValidationAccountant(item.id,item.cin) FROM ValidationAccountant item")
    List<ValidationAccountant> findAllOptimized();
}
