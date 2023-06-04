import {OrderItemDto} from './OrderItem.model';
import {ClientDto} from './Client.model';
import {OrderStatusDto} from './OrderStatus.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class OrderDto  extends BaseDto{

    public id: number;
    public reference: string;
   public orderDate: Date;
    public total: number;
    public totalPaid: number;
    public totalPaidCheck: number;
    public totalPaidCash: number;
    public orderDateMax: string ;
    public orderDateMin: string ;
    public totalMax: string ;
    public totalMin: string ;
    public totalPaidMax: string ;
    public totalPaidMin: string ;
    public totalPaidCheckMax: string ;
    public totalPaidCheckMin: string ;
    public totalPaidCashMax: string ;
    public totalPaidCashMin: string ;
    public client: ClientDto ;
    public orderStatus: OrderStatusDto ;
     public orderItems: Array<OrderItemDto>;

}
