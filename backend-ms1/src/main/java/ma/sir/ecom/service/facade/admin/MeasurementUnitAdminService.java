package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.MeasurementUnit;
import ma.sir.ecom.dao.criteria.core.MeasurementUnitCriteria;
import ma.sir.ecom.dao.criteria.history.MeasurementUnitHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.MeasurementUnitDto;
import org.springframework.http.HttpEntity;

public interface MeasurementUnitAdminService extends  IService<MeasurementUnit,MeasurementUnitCriteria, MeasurementUnitHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(MeasurementUnitDto dto) throws Exception;


}
