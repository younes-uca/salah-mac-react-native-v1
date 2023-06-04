package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.Company;
import ma.sir.ecom.dao.criteria.core.CompanyCriteria;
import ma.sir.ecom.dao.criteria.history.CompanyHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.CompanyDto;
import org.springframework.http.HttpEntity;

public interface CompanyAdminService extends  IService<Company,CompanyCriteria, CompanyHistoryCriteria>  {

    List<Company> findBySubscriberId(Long id);
    int deleteBySubscriberId(Long id);

    HttpEntity<byte[]> createPdf(CompanyDto dto) throws Exception;


}
