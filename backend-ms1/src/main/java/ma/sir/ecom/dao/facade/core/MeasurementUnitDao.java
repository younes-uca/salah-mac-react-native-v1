package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.MeasurementUnit;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.MeasurementUnit;
import java.util.List;


@Repository
public interface MeasurementUnitDao extends AbstractRepository<MeasurementUnit,Long>  {
    MeasurementUnit findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW MeasurementUnit(item.id,item.libelle) FROM MeasurementUnit item")
    List<MeasurementUnit> findAllOptimized();
}
