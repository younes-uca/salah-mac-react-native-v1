package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.HandlingAccountant;
import ma.sir.ecom.dao.criteria.core.HandlingAccountantCriteria;
import ma.sir.ecom.dao.criteria.history.HandlingAccountantHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.HandlingAccountantDto;
import org.springframework.http.HttpEntity;

public interface HandlingAccountantAdminService extends  IService<HandlingAccountant,HandlingAccountantCriteria, HandlingAccountantHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(HandlingAccountantDto dto) throws Exception;


}
