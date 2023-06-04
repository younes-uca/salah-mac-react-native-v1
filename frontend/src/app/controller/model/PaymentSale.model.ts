import {SaleDto} from './Sale.model';
import {PaymentStatusDto} from './PaymentStatus.model';
import {PaymentMethodDto} from './PaymentMethod.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class PaymentSaleDto  extends BaseDto{

    public id: number;
    public reference: string;
   public paymentDate: Date;
    public amount: number;
    public description: string;
    public paymentDateMax: string ;
    public paymentDateMin: string ;
    public amountMax: string ;
    public amountMin: string ;
    public sale: SaleDto ;
    public paymentMethod: PaymentMethodDto ;
    public paymentStatus: PaymentStatusDto ;

}
