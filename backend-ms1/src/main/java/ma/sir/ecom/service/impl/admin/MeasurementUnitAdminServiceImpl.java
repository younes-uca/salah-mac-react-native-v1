package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.MeasurementUnit;
import ma.sir.ecom.bean.history.MeasurementUnitHistory;
import ma.sir.ecom.dao.criteria.core.MeasurementUnitCriteria;
import ma.sir.ecom.dao.criteria.history.MeasurementUnitHistoryCriteria;
import ma.sir.ecom.dao.facade.core.MeasurementUnitDao;
import ma.sir.ecom.dao.facade.history.MeasurementUnitHistoryDao;
import ma.sir.ecom.dao.specification.core.MeasurementUnitSpecification;
import ma.sir.ecom.service.facade.admin.MeasurementUnitAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.MeasurementUnitDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class MeasurementUnitAdminServiceImpl extends AbstractServiceImpl<MeasurementUnit,MeasurementUnitHistory, MeasurementUnitCriteria, MeasurementUnitHistoryCriteria, MeasurementUnitDao,
MeasurementUnitHistoryDao> implements MeasurementUnitAdminService {
    public static final String TEMPLATE = "template/measurementUnit.vm";
    public static final String FILE_NAME = "measurementUnit.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(MeasurementUnitDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public MeasurementUnit findByReferenceEntity(MeasurementUnit t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(MeasurementUnit.class,MeasurementUnitHistory.class, MeasurementUnitHistoryCriteria.class, MeasurementUnitSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public MeasurementUnitAdminServiceImpl(MeasurementUnitDao dao, MeasurementUnitHistoryDao historyDao) {
        super(dao, historyDao);
    }

}