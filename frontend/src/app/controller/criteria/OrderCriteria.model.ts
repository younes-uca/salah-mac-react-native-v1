import {OrderItemCriteria} from './OrderItemCriteria.model';
import {ClientCriteria} from './ClientCriteria.model';
import {OrderStatusCriteria} from './OrderStatusCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class OrderCriteria  extends   BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public orderDate: Date;
    public orderDateFrom: Date;
    public orderDateTo: Date;
     public total: number;
     public totalMin: number;
     public totalMax: number;
     public totalPaid: number;
     public totalPaidMin: number;
     public totalPaidMax: number;
     public totalPaidCheck: number;
     public totalPaidCheckMin: number;
     public totalPaidCheckMax: number;
     public totalPaidCash: number;
     public totalPaidCashMin: number;
     public totalPaidCashMax: number;
  public client: ClientCriteria ;
  public clients: Array<ClientCriteria> ;
  public orderStatus: OrderStatusCriteria ;
  public orderStatuss: Array<OrderStatusCriteria> ;
      public orderItems: Array<OrderItemCriteria>;

}
