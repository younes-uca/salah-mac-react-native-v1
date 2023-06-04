package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.PaymentSale;
import ma.sir.ecom.bean.history.PaymentSaleHistory;
import ma.sir.ecom.dao.criteria.core.PaymentSaleCriteria;
import ma.sir.ecom.dao.criteria.history.PaymentSaleHistoryCriteria;
import ma.sir.ecom.dao.facade.core.PaymentSaleDao;
import ma.sir.ecom.dao.facade.history.PaymentSaleHistoryDao;
import ma.sir.ecom.dao.specification.core.PaymentSaleSpecification;
import ma.sir.ecom.service.facade.admin.PaymentSaleAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.PaymentSaleDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ecom.service.facade.admin.SaleAdminService ;
import ma.sir.ecom.service.facade.admin.PaymentMethodAdminService ;
import ma.sir.ecom.service.facade.admin.PaymentStatusAdminService ;


import java.util.List;
@Service
public class PaymentSaleAdminServiceImpl extends AbstractServiceImpl<PaymentSale,PaymentSaleHistory, PaymentSaleCriteria, PaymentSaleHistoryCriteria, PaymentSaleDao,
PaymentSaleHistoryDao> implements PaymentSaleAdminService {
    public static final String TEMPLATE = "template/paymentSale.vm";
    public static final String FILE_NAME = "paymentSale.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(PaymentSaleDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public PaymentSale findByReferenceEntity(PaymentSale t){
        return  dao.findByReference(t.getReference());
    }

    public List<PaymentSale> findBySaleId(Long id){
        return dao.findBySaleId(id);
    }
    public int deleteBySaleId(Long id){
        return dao.deleteBySaleId(id);
    }
    public List<PaymentSale> findByPaymentMethodId(Long id){
        return dao.findByPaymentMethodId(id);
    }
    public int deleteByPaymentMethodId(Long id){
        return dao.deleteByPaymentMethodId(id);
    }
    public List<PaymentSale> findByPaymentStatusId(Long id){
        return dao.findByPaymentStatusId(id);
    }
    public int deleteByPaymentStatusId(Long id){
        return dao.deleteByPaymentStatusId(id);
    }




    public void configure() {
        super.configure(PaymentSale.class,PaymentSaleHistory.class, PaymentSaleHistoryCriteria.class, PaymentSaleSpecification.class);
    }

    @Autowired
    private SaleAdminService saleService ;
    @Autowired
    private PaymentMethodAdminService paymentMethodService ;
    @Autowired
    private PaymentStatusAdminService paymentStatusService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public PaymentSaleAdminServiceImpl(PaymentSaleDao dao, PaymentSaleHistoryDao historyDao) {
        super(dao, historyDao);
    }

}