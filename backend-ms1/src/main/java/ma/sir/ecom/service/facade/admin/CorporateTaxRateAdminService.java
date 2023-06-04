package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.CorporateTaxRate;
import ma.sir.ecom.dao.criteria.core.CorporateTaxRateCriteria;
import ma.sir.ecom.dao.criteria.history.CorporateTaxRateHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.CorporateTaxRateDto;
import org.springframework.http.HttpEntity;

public interface CorporateTaxRateAdminService extends  IService<CorporateTaxRate,CorporateTaxRateCriteria, CorporateTaxRateHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(CorporateTaxRateDto dto) throws Exception;


}
