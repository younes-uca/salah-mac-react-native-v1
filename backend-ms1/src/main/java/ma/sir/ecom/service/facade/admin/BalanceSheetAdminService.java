package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.BalanceSheet;
import ma.sir.ecom.dao.criteria.core.BalanceSheetCriteria;
import ma.sir.ecom.dao.criteria.history.BalanceSheetHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.BalanceSheetDto;
import org.springframework.http.HttpEntity;

public interface BalanceSheetAdminService extends  IService<BalanceSheet,BalanceSheetCriteria, BalanceSheetHistoryCriteria>  {

    List<BalanceSheet> findByCompanyId(Long id);
    int deleteByCompanyId(Long id);
    List<BalanceSheet> findByBalanceSheetStatusId(Long id);
    int deleteByBalanceSheetStatusId(Long id);

    HttpEntity<byte[]> createPdf(BalanceSheetDto dto) throws Exception;


}
