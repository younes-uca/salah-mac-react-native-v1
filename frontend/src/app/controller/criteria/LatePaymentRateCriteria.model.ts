import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class LatePaymentRateCriteria  extends   BaseCriteria  {

    public id: number;
    public minApplicationDate: Date;
    public minApplicationDateFrom: Date;
    public minApplicationDateTo: Date;
    public maxApplicationDate: Date;
    public maxApplicationDateFrom: Date;
    public maxApplicationDateTo: Date;
     public amount: number;
     public amountMin: number;
     public amountMax: number;

}
