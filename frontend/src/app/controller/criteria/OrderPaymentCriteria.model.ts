import {OrderCriteria} from './OrderCriteria.model';
import {OrderStatusOrderCriteria} from './OrderStatusOrderCriteria.model';
import {PaymentModeCriteria} from './PaymentModeCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class OrderPaymentCriteria  extends   BaseCriteria  {

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
  public order: OrderCriteria ;
  public orders: Array<OrderCriteria> ;
  public paymentMode: PaymentModeCriteria ;
  public paymentModes: Array<PaymentModeCriteria> ;
  public orderStatusOrder: OrderStatusOrderCriteria ;
  public orderStatusOrders: Array<OrderStatusOrderCriteria> ;

}
