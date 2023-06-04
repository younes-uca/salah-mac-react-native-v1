import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class LatePaymentRateDto  extends BaseDto{

    public id: number;
   public minApplicationDate: Date;
   public maxApplicationDate: Date;
    public amount: number;
    public minApplicationDateMax: string ;
    public minApplicationDateMin: string ;
    public maxApplicationDateMax: string ;
    public maxApplicationDateMin: string ;
    public amountMax: string ;
    public amountMin: string ;

}
