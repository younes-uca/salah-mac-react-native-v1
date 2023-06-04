import {DemandDto} from './Demand.model';
import {StatusPaymentDemandDto} from './StatusPaymentDemand.model';
import {PaymentModeDto} from './PaymentMode.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class DemandPaymentDto  extends BaseDto{

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
    public demand: DemandDto ;
    public paymentMode: PaymentModeDto ;
    public statusPaymentDemand: StatusPaymentDemandDto ;

}
