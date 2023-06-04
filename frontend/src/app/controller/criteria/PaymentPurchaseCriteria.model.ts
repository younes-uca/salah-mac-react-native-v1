import {PurchaseCriteria} from './PurchaseCriteria.model';
import {PurchasePaymentStatusCriteria} from './PurchasePaymentStatusCriteria.model';
import {PaymentModeCriteria} from './PaymentModeCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class PaymentPurchaseCriteria  extends   BaseCriteria  {

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
  public purchase: PurchaseCriteria ;
  public purchases: Array<PurchaseCriteria> ;
  public paymentMode: PaymentModeCriteria ;
  public paymentModes: Array<PaymentModeCriteria> ;
  public purchasePaymentStatus: PurchasePaymentStatusCriteria ;
  public purchasePaymentStatuss: Array<PurchasePaymentStatusCriteria> ;

}
