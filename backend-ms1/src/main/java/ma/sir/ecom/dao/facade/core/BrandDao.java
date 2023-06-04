package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.Brand;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.Brand;
import java.util.List;


@Repository
public interface BrandDao extends AbstractRepository<Brand,Long>  {
    Brand findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW Brand(item.id,item.libelle) FROM Brand item")
    List<Brand> findAllOptimized();
}
