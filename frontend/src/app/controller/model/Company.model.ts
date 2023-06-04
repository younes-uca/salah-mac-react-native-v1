import {StoreDto} from './Store.model';
import {SubscriberDto} from './Subscriber.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class CompanyDto  extends BaseDto{

    public id: number;
    public ice: string;
    public headquarters: string;
   public lastPaidYearIS: number;
   public lastPaidQuarterIS: number;
   public lastPaidYearVAT: number;
   public lastPaidQuarterVAT: number;
   public blocked: null | boolean;
    public lastPaidYearISMax: string ;
    public lastPaidYearISMin: string ;
    public lastPaidQuarterISMax: string ;
    public lastPaidQuarterISMin: string ;
    public lastPaidYearVATMax: string ;
    public lastPaidYearVATMin: string ;
    public lastPaidQuarterVATMax: string ;
    public lastPaidQuarterVATMin: string ;
    public subscriber: SubscriberDto ;
     public stores: Array<StoreDto>;

}
