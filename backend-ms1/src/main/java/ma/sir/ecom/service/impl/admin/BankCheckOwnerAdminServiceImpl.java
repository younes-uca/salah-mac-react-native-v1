package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.BankCheckOwner;
import ma.sir.ecom.bean.history.BankCheckOwnerHistory;
import ma.sir.ecom.dao.criteria.core.BankCheckOwnerCriteria;
import ma.sir.ecom.dao.criteria.history.BankCheckOwnerHistoryCriteria;
import ma.sir.ecom.dao.facade.core.BankCheckOwnerDao;
import ma.sir.ecom.dao.facade.history.BankCheckOwnerHistoryDao;
import ma.sir.ecom.dao.specification.core.BankCheckOwnerSpecification;
import ma.sir.ecom.service.facade.admin.BankCheckOwnerAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.BankCheckOwnerDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ecom.service.facade.admin.CheckOwnerAdminService ;
import ma.sir.ecom.service.facade.admin.BankAdminService ;


import java.util.List;
@Service
public class BankCheckOwnerAdminServiceImpl extends AbstractServiceImpl<BankCheckOwner,BankCheckOwnerHistory, BankCheckOwnerCriteria, BankCheckOwnerHistoryCriteria, BankCheckOwnerDao,
BankCheckOwnerHistoryDao> implements BankCheckOwnerAdminService {
    public static final String TEMPLATE = "template/bankCheckOwner.vm";
    public static final String FILE_NAME = "bankCheckOwner.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(BankCheckOwnerDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }



    public List<BankCheckOwner> findByCheckOwnerId(Long id){
        return dao.findByCheckOwnerId(id);
    }
    public int deleteByCheckOwnerId(Long id){
        return dao.deleteByCheckOwnerId(id);
    }
    public List<BankCheckOwner> findByBankId(Long id){
        return dao.findByBankId(id);
    }
    public int deleteByBankId(Long id){
        return dao.deleteByBankId(id);
    }




    public void configure() {
        super.configure(BankCheckOwner.class,BankCheckOwnerHistory.class, BankCheckOwnerHistoryCriteria.class, BankCheckOwnerSpecification.class);
    }

    @Autowired
    private CheckOwnerAdminService checkOwnerService ;
    @Autowired
    private BankAdminService bankService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public BankCheckOwnerAdminServiceImpl(BankCheckOwnerDao dao, BankCheckOwnerHistoryDao historyDao) {
        super(dao, historyDao);
    }

}