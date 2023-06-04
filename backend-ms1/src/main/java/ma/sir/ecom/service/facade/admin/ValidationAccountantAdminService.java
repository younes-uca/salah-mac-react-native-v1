package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.ValidationAccountant;
import ma.sir.ecom.dao.criteria.core.ValidationAccountantCriteria;
import ma.sir.ecom.dao.criteria.history.ValidationAccountantHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.ValidationAccountantDto;
import org.springframework.http.HttpEntity;

public interface ValidationAccountantAdminService extends  IService<ValidationAccountant,ValidationAccountantCriteria, ValidationAccountantHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(ValidationAccountantDto dto) throws Exception;


}
