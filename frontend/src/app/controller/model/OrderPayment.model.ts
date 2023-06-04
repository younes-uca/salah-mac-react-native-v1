import {OrderDto} from './Order.model';
import {OrderStatusOrderDto} from './OrderStatusOrder.model';
import {PaymentModeDto} from './PaymentMode.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class OrderPaymentDto  extends BaseDto{

    public id: number;
    public reference: string;
   public paymentDate: Date;
    public amount: number;
    public description: string;
   public vireCheck: null | boolean;
    public paymentDateMax: string ;
    public paymentDateMin: string ;
    public amountMax: string ;
    public amountMin: string ;
    public order: OrderDto ;
    public paymentMode: PaymentModeDto ;
    public orderStatusOrder: OrderStatusOrderDto ;

}
