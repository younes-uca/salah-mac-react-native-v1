import {SaleDto} from './Sale.model';
import {PaymentMethodDto} from './PaymentMethod.model';
import {PaymentDeliveryStatusDto} from './PaymentDeliveryStatus.model';
import {DeliveryDto} from './Delivery.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class PaymentDeliveryDto  extends BaseDto{

    public id: number;
    public reference: string;
   public deliveryDate: Date;
    public amount: number;
    public description: string;
    public deliveryDateMax: string ;
    public deliveryDateMin: string ;
    public amountMax: string ;
    public amountMin: string ;
    public delivery: DeliveryDto ;
    public sale: SaleDto ;
    public paymentMethod: PaymentMethodDto ;
    public paymentDeliveryStatus: PaymentDeliveryStatusDto ;

}
