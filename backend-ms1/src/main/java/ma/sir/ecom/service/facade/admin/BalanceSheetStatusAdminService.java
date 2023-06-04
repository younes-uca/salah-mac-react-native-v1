package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.BalanceSheetStatus;
import ma.sir.ecom.dao.criteria.core.BalanceSheetStatusCriteria;
import ma.sir.ecom.dao.criteria.history.BalanceSheetStatusHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.BalanceSheetStatusDto;
import org.springframework.http.HttpEntity;

public interface BalanceSheetStatusAdminService extends  IService<BalanceSheetStatus,BalanceSheetStatusCriteria, BalanceSheetStatusHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(BalanceSheetStatusDto dto) throws Exception;


}
