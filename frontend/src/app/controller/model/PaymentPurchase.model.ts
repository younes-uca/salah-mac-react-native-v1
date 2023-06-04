import {PurchaseDto} from './Purchase.model';
import {PurchasePaymentStatusDto} from './PurchasePaymentStatus.model';
import {PaymentModeDto} from './PaymentMode.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class PaymentPurchaseDto  extends BaseDto{

    public id: number;
    public reference: string;
   public paymentDate: Date;
    public amount: number;
    public description: string;
    public paymentDateMax: string ;
    public paymentDateMin: string ;
    public amountMax: string ;
    public amountMin: string ;
    public purchase: PurchaseDto ;
    public paymentMode: PaymentModeDto ;
    public purchasePaymentStatus: PurchasePaymentStatusDto ;

}
