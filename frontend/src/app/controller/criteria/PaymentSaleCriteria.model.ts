import {SaleCriteria} from './SaleCriteria.model';
import {PaymentStatusCriteria} from './PaymentStatusCriteria.model';
import {PaymentMethodCriteria} from './PaymentMethodCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class PaymentSaleCriteria  extends   BaseCriteria  {

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
  public sale: SaleCriteria ;
  public sales: Array<SaleCriteria> ;
  public paymentMethod: PaymentMethodCriteria ;
  public paymentMethods: Array<PaymentMethodCriteria> ;
  public paymentStatus: PaymentStatusCriteria ;
  public paymentStatuss: Array<PaymentStatusCriteria> ;

}
