import {DemandCriteria} from './DemandCriteria.model';
import {StatusPaymentDemandCriteria} from './StatusPaymentDemandCriteria.model';
import {PaymentModeCriteria} from './PaymentModeCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class DemandPaymentCriteria  extends   BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public paymentDate: Date;
    public paymentDateFrom: Date;
    public paymentDateTo: Date;
     public amount: number;
     public amountMin: number;
     public amountMax: number;
    public description: string;
    public descriptionLike: string;
    public vireCheck: null | boolean;
  public demand: DemandCriteria ;
  public demands: Array<DemandCriteria> ;
  public paymentMode: PaymentModeCriteria ;
  public paymentModes: Array<PaymentModeCriteria> ;
  public statusPaymentDemand: StatusPaymentDemandCriteria ;
  public statusPaymentDemands: Array<StatusPaymentDemandCriteria> ;

}
