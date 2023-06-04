package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.CompanyCriteria;
import ma.sir.ecom.bean.core.Company;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CompanySpecification extends  AbstractSpecification<CompanyCriteria, Company>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ice", criteria.getIce(),criteria.getIceLike());
        addPredicate("headquarters", criteria.getHeadquarters(),criteria.getHeadquartersLike());
        addPredicateInt("lastPaidYearIS", criteria.getLastPaidYearIS(), criteria.getLastPaidYearISMin(), criteria.getLastPaidYearISMax());
        addPredicateInt("lastPaidQuarterIS", criteria.getLastPaidQuarterIS(), criteria.getLastPaidQuarterISMin(), criteria.getLastPaidQuarterISMax());
        addPredicateInt("lastPaidYearVAT", criteria.getLastPaidYearVAT(), criteria.getLastPaidYearVATMin(), criteria.getLastPaidYearVATMax());
        addPredicateInt("lastPaidQuarterVAT", criteria.getLastPaidQuarterVAT(), criteria.getLastPaidQuarterVATMin(), criteria.getLastPaidQuarterVATMax());
        addPredicateBool("blocked", criteria.getBlocked());
        addPredicateFk("subscriber","id", criteria.getSubscriber()==null?null:criteria.getSubscriber().getId());
        addPredicateFk("subscriber","id", criteria.getSubscribers());
        addPredicateFk("subscriber","code", criteria.getSubscriber()==null?null:criteria.getSubscriber().getCode());
    }

    public CompanySpecification(CompanyCriteria criteria) {
        super(criteria);
    }

    public CompanySpecification(CompanyCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
