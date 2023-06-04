package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.VatDeclarationHistoryCriteria;
import ma.sir.ecom.bean.history.VatDeclarationHistory;


public class VatDeclarationHistorySpecification extends AbstractHistorySpecification<VatDeclarationHistoryCriteria, VatDeclarationHistory> {

    public VatDeclarationHistorySpecification(VatDeclarationHistoryCriteria criteria) {
        super(criteria);
    }

    public VatDeclarationHistorySpecification(VatDeclarationHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
