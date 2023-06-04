package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.Supplier;
import ma.sir.ecom.dao.criteria.core.SupplierCriteria;
import ma.sir.ecom.dao.criteria.history.SupplierHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.SupplierDto;
import org.springframework.http.HttpEntity;

public interface SupplierAdminService extends  IService<Supplier,SupplierCriteria, SupplierHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(SupplierDto dto) throws Exception;


}
