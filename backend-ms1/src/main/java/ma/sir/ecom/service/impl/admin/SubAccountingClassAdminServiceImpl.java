package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.SubAccountingClass;
import ma.sir.ecom.bean.history.SubAccountingClassHistory;
import ma.sir.ecom.dao.criteria.core.SubAccountingClassCriteria;
import ma.sir.ecom.dao.criteria.history.SubAccountingClassHistoryCriteria;
import ma.sir.ecom.dao.facade.core.SubAccountingClassDao;
import ma.sir.ecom.dao.facade.history.SubAccountingClassHistoryDao;
import ma.sir.ecom.dao.specification.core.SubAccountingClassSpecification;
import ma.sir.ecom.service.facade.admin.SubAccountingClassAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.SubAccountingClassDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ecom.service.facade.admin.AccountingClassAdminService ;


import java.util.List;
@Service
public class SubAccountingClassAdminServiceImpl extends AbstractServiceImpl<SubAccountingClass,SubAccountingClassHistory, SubAccountingClassCriteria, SubAccountingClassHistoryCriteria, SubAccountingClassDao,
SubAccountingClassHistoryDao> implements SubAccountingClassAdminService {
    public static final String TEMPLATE = "template/subAccountingClass.vm";
    public static final String FILE_NAME = "subAccountingClass.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(SubAccountingClassDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public SubAccountingClass findByReferenceEntity(SubAccountingClass t){
        return  dao.findByCode(t.getCode());
    }

    public List<SubAccountingClass> findByAccountingClassId(Long id){
        return dao.findByAccountingClassId(id);
    }
    public int deleteByAccountingClassId(Long id){
        return dao.deleteByAccountingClassId(id);
    }




    public void configure() {
        super.configure(SubAccountingClass.class,SubAccountingClassHistory.class, SubAccountingClassHistoryCriteria.class, SubAccountingClassSpecification.class);
    }

    @Autowired
    private AccountingClassAdminService accountingClassService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public SubAccountingClassAdminServiceImpl(SubAccountingClassDao dao, SubAccountingClassHistoryDao historyDao) {
        super(dao, historyDao);
    }

}