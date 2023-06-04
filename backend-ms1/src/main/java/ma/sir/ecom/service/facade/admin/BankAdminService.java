package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.Bank;
import ma.sir.ecom.dao.criteria.core.BankCriteria;
import ma.sir.ecom.dao.criteria.history.BankHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.BankDto;
import org.springframework.http.HttpEntity;

public interface BankAdminService extends  IService<Bank,BankCriteria, BankHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(BankDto dto) throws Exception;


}
