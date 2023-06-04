import {StoreCriteria} from './StoreCriteria.model';
import {SubscriberCriteria} from './SubscriberCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class CompanyCriteria  extends   BaseCriteria  {

    public id: number;
    public ice: string;
    public iceLike: string;
    public headquarters: string;
    public headquartersLike: string;
     public lastPaidYearIS: number;
     public lastPaidYearISMin: number;
     public lastPaidYearISMax: number;
     public lastPaidQuarterIS: number;
     public lastPaidQuarterISMin: number;
     public lastPaidQuarterISMax: number;
     public lastPaidYearVAT: number;
     public lastPaidYearVATMin: number;
     public lastPaidYearVATMax: number;
     public lastPaidQuarterVAT: number;
     public lastPaidQuarterVATMin: number;
     public lastPaidQuarterVATMax: number;
    public blocked: null | boolean;
  public subscriber: SubscriberCriteria ;
  public subscribers: Array<SubscriberCriteria> ;
      public stores: Array<StoreCriteria>;

}
