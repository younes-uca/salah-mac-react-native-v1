package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.Brand;
import ma.sir.ecom.dao.criteria.core.BrandCriteria;
import ma.sir.ecom.dao.criteria.history.BrandHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.BrandDto;
import org.springframework.http.HttpEntity;

public interface BrandAdminService extends  IService<Brand,BrandCriteria, BrandHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(BrandDto dto) throws Exception;


}
