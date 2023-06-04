import {SaleCriteria} from './SaleCriteria.model';
import {PaymentMethodCriteria} from './PaymentMethodCriteria.model';
import {PaymentDeliveryStatusCriteria} from './PaymentDeliveryStatusCriteria.model';
import {DeliveryCriteria} from './DeliveryCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class PaymentDeliveryCriteria  extends   BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public deliveryDate: Date;
    public deliveryDateFrom: Date;
    public deliveryDateTo: Date;
     public amount: number;
     public amountMin: number;
     public amountMax: number;
    public description: string;
    public descriptionLike: string;
  public delivery: DeliveryCriteria ;
  public deliverys: Array<DeliveryCriteria> ;
  public sale: SaleCriteria ;
  public sales: Array<SaleCriteria> ;
  public paymentMethod: PaymentMethodCriteria ;
  public paymentMethods: Array<PaymentMethodCriteria> ;
  public paymentDeliveryStatus: PaymentDeliveryStatusCriteria ;
  public paymentDeliveryStatuss: Array<PaymentDeliveryStatusCriteria> ;

}
