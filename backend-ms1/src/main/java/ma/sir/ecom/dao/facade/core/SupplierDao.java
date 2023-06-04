package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.Supplier;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.Supplier;
import java.util.List;


@Repository
public interface SupplierDao extends AbstractRepository<Supplier,Long>  {
    Supplier findByIce(String ice);
    int deleteByIce(String ice);


    @Query("SELECT NEW Supplier(item.id,item.name) FROM Supplier item")
    List<Supplier> findAllOptimized();
}
