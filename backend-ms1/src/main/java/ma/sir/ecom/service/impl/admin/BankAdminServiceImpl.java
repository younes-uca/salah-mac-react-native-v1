package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.Bank;
import ma.sir.ecom.bean.history.BankHistory;
import ma.sir.ecom.dao.criteria.core.BankCriteria;
import ma.sir.ecom.dao.criteria.history.BankHistoryCriteria;
import ma.sir.ecom.dao.facade.core.BankDao;
import ma.sir.ecom.dao.facade.history.BankHistoryDao;
import ma.sir.ecom.dao.specification.core.BankSpecification;
import ma.sir.ecom.service.facade.admin.BankAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.BankDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class BankAdminServiceImpl extends AbstractServiceImpl<Bank,BankHistory, BankCriteria, BankHistoryCriteria, BankDao,
BankHistoryDao> implements BankAdminService {
    public static final String TEMPLATE = "template/bank.vm";
    public static final String FILE_NAME = "bank.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(BankDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public Bank findByReferenceEntity(Bank t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(Bank.class,BankHistory.class, BankHistoryCriteria.class, BankSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public BankAdminServiceImpl(BankDao dao, BankHistoryDao historyDao) {
        super(dao, historyDao);
    }

}