package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.SaleStatus;
import ma.sir.ecom.dao.criteria.core.SaleStatusCriteria;
import ma.sir.ecom.dao.criteria.history.SaleStatusHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.SaleStatusDto;
import org.springframework.http.HttpEntity;

public interface SaleStatusAdminService extends  IService<SaleStatus,SaleStatusCriteria, SaleStatusHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(SaleStatusDto dto) throws Exception;


}
