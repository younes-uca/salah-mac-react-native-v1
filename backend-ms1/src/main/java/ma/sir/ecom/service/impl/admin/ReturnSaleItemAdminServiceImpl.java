package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.ReturnSaleItem;
import ma.sir.ecom.bean.history.ReturnSaleItemHistory;
import ma.sir.ecom.dao.criteria.core.ReturnSaleItemCriteria;
import ma.sir.ecom.dao.criteria.history.ReturnSaleItemHistoryCriteria;
import ma.sir.ecom.dao.facade.core.ReturnSaleItemDao;
import ma.sir.ecom.dao.facade.history.ReturnSaleItemHistoryDao;
import ma.sir.ecom.dao.specification.core.ReturnSaleItemSpecification;
import ma.sir.ecom.service.facade.admin.ReturnSaleItemAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.ReturnSaleItemDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ecom.service.facade.admin.ProductAdminService ;
import ma.sir.ecom.service.facade.admin.ReturnSaleAdminService ;


import java.util.List;
@Service
public class ReturnSaleItemAdminServiceImpl extends AbstractServiceImpl<ReturnSaleItem,ReturnSaleItemHistory, ReturnSaleItemCriteria, ReturnSaleItemHistoryCriteria, ReturnSaleItemDao,
ReturnSaleItemHistoryDao> implements ReturnSaleItemAdminService {
    public static final String TEMPLATE = "template/returnSaleItem.vm";
    public static final String FILE_NAME = "returnSaleItem.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(ReturnSaleItemDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }



    public List<ReturnSaleItem> findByProductId(Long id){
        return dao.findByProductId(id);
    }
    public int deleteByProductId(Long id){
        return dao.deleteByProductId(id);
    }
    public List<ReturnSaleItem> findByReturnSaleId(Long id){
        return dao.findByReturnSaleId(id);
    }
    public int deleteByReturnSaleId(Long id){
        return dao.deleteByReturnSaleId(id);
    }




    public void configure() {
        super.configure(ReturnSaleItem.class,ReturnSaleItemHistory.class, ReturnSaleItemHistoryCriteria.class, ReturnSaleItemSpecification.class);
    }

    @Autowired
    private ProductAdminService productService ;
    @Autowired
    private ReturnSaleAdminService returnSaleService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public ReturnSaleItemAdminServiceImpl(ReturnSaleItemDao dao, ReturnSaleItemHistoryDao historyDao) {
        super(dao, historyDao);
    }

}