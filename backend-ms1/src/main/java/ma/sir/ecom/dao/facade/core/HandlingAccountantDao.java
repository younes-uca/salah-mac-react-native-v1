package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.HandlingAccountant;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.HandlingAccountant;
import java.util.List;


@Repository
public interface HandlingAccountantDao extends AbstractRepository<HandlingAccountant,Long>  {
    HandlingAccountant findByCin(String cin);
    int deleteByCin(String cin);


    @Query("SELECT NEW HandlingAccountant(item.id,item.cin) FROM HandlingAccountant item")
    List<HandlingAccountant> findAllOptimized();
}
