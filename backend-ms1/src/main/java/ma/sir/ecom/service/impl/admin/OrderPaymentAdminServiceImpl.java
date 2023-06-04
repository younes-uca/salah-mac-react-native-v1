package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.OrderPayment;
import ma.sir.ecom.bean.history.OrderPaymentHistory;
import ma.sir.ecom.dao.criteria.core.OrderPaymentCriteria;
import ma.sir.ecom.dao.criteria.history.OrderPaymentHistoryCriteria;
import ma.sir.ecom.dao.facade.core.OrderPaymentDao;
import ma.sir.ecom.dao.facade.history.OrderPaymentHistoryDao;
import ma.sir.ecom.dao.specification.core.OrderPaymentSpecification;
import ma.sir.ecom.service.facade.admin.OrderPaymentAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.OrderPaymentDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ecom.service.facade.admin.OrderAdminService ;
import ma.sir.ecom.service.facade.admin.PaymentModeAdminService ;
import ma.sir.ecom.service.facade.admin.OrderStatusOrderAdminService ;


import java.util.List;
@Service
public class OrderPaymentAdminServiceImpl extends AbstractServiceImpl<OrderPayment,OrderPaymentHistory, OrderPaymentCriteria, OrderPaymentHistoryCriteria, OrderPaymentDao,
OrderPaymentHistoryDao> implements OrderPaymentAdminService {
    public static final String TEMPLATE = "template/orderPayment.vm";
    public static final String FILE_NAME = "orderPayment.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(OrderPaymentDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public OrderPayment findByReferenceEntity(OrderPayment t){
        return  dao.findByReference(t.getReference());
    }

    public List<OrderPayment> findByOrderId(Long id){
        return dao.findByOrderId(id);
    }
    public int deleteByOrderId(Long id){
        return dao.deleteByOrderId(id);
    }
    public List<OrderPayment> findByPaymentModeId(Long id){
        return dao.findByPaymentModeId(id);
    }
    public int deleteByPaymentModeId(Long id){
        return dao.deleteByPaymentModeId(id);
    }
    public List<OrderPayment> findByOrderStatusOrderId(Long id){
        return dao.findByOrderStatusOrderId(id);
    }
    public int deleteByOrderStatusOrderId(Long id){
        return dao.deleteByOrderStatusOrderId(id);
    }




    public void configure() {
        super.configure(OrderPayment.class,OrderPaymentHistory.class, OrderPaymentHistoryCriteria.class, OrderPaymentSpecification.class);
    }

    @Autowired
    private OrderAdminService orderService ;
    @Autowired
    private PaymentModeAdminService paymentModeService ;
    @Autowired
    private OrderStatusOrderAdminService orderStatusOrderService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public OrderPaymentAdminServiceImpl(OrderPaymentDao dao, OrderPaymentHistoryDao historyDao) {
        super(dao, historyDao);
    }

}