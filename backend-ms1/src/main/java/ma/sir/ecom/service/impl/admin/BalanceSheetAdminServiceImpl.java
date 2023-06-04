package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.BalanceSheet;
import ma.sir.ecom.bean.history.BalanceSheetHistory;
import ma.sir.ecom.dao.criteria.core.BalanceSheetCriteria;
import ma.sir.ecom.dao.criteria.history.BalanceSheetHistoryCriteria;
import ma.sir.ecom.dao.facade.core.BalanceSheetDao;
import ma.sir.ecom.dao.facade.history.BalanceSheetHistoryDao;
import ma.sir.ecom.dao.specification.core.BalanceSheetSpecification;
import ma.sir.ecom.service.facade.admin.BalanceSheetAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.service.Attribute;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.BalanceSheetDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ecom.service.facade.admin.CompanyAdminService ;
import ma.sir.ecom.service.facade.admin.BalanceSheetStatusAdminService ;


import java.util.List;
@Service
public class BalanceSheetAdminServiceImpl extends AbstractServiceImpl<BalanceSheet,BalanceSheetHistory, BalanceSheetCriteria, BalanceSheetHistoryCriteria, BalanceSheetDao,
BalanceSheetHistoryDao> implements BalanceSheetAdminService {
    public static final String TEMPLATE = "template/balanceSheet.vm";
    public static final String FILE_NAME = "balanceSheet.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList<>();
    static{
    ATTRIBUTES.add(new Attribute("id","Long"));
    ATTRIBUTES.add(new Attribute("ref"));
    ATTRIBUTES.add(new Attribute("year","Integer"));
    ATTRIBUTES.add(new Attribute("intangibleAssets","BigDecimal"));
    ATTRIBUTES.add(new Attribute("tangibleAssets","BigDecimal"));
    ATTRIBUTES.add(new Attribute("financialAssets","BigDecimal"));
    ATTRIBUTES.add(new Attribute("totalFixedAssets","BigDecimal"));
    ATTRIBUTES.add(new Attribute("inventories","BigDecimal"));
    ATTRIBUTES.add(new Attribute("accountsReceivable","BigDecimal"));
    ATTRIBUTES.add(new Attribute("totalCurrentAssets","BigDecimal"));
    ATTRIBUTES.add(new Attribute("bankDeposits","BigDecimal"));
    ATTRIBUTES.add(new Attribute("cashInHand","BigDecimal"));
    ATTRIBUTES.add(new Attribute("totalTreasuryAssets","BigDecimal"));
    ATTRIBUTES.add(new Attribute("totalAssets","BigDecimal"));
    ATTRIBUTES.add(new Attribute("equity","BigDecimal"));
    ATTRIBUTES.add(new Attribute("loans","BigDecimal"));
    ATTRIBUTES.add(new Attribute("profit","BigDecimal"));
    ATTRIBUTES.add(new Attribute("totalPermanentFinancing","BigDecimal"));
    ATTRIBUTES.add(new Attribute("accountsPayable","BigDecimal"));
    ATTRIBUTES.add(new Attribute("otherCurrentLiabilities","BigDecimal"));
    ATTRIBUTES.add(new Attribute("totalCurrentLiabilities","BigDecimal"));
    ATTRIBUTES.add(new Attribute("totalLiabilities","BigDecimal"));
    }

    @Override
    public HttpEntity<byte[]> createPdf(BalanceSheetDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public BalanceSheet findByReferenceEntity(BalanceSheet t){
        return  dao.findByRef(t.getRef());
    }

    public List<BalanceSheet> findByCompanyId(Long id){
        return dao.findByCompanyId(id);
    }
    public int deleteByCompanyId(Long id){
        return dao.deleteByCompanyId(id);
    }
    public List<BalanceSheet> findByBalanceSheetStatusId(Long id){
        return dao.findByBalanceSheetStatusId(id);
    }
    public int deleteByBalanceSheetStatusId(Long id){
        return dao.deleteByBalanceSheetStatusId(id);
    }


    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }


    public void configure() {
        super.configure(BalanceSheet.class,BalanceSheetHistory.class, BalanceSheetHistoryCriteria.class, BalanceSheetSpecification.class);
    }

    @Autowired
    private CompanyAdminService companyService ;
    @Autowired
    private BalanceSheetStatusAdminService balanceSheetStatusService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public BalanceSheetAdminServiceImpl(BalanceSheetDao dao, BalanceSheetHistoryDao historyDao) {
        super(dao, historyDao);
    }

}