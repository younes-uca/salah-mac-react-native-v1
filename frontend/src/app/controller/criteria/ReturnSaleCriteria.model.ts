import {SaleCriteria} from './SaleCriteria.model';
import {ReturnSaleItemCriteria} from './ReturnSaleItemCriteria.model';
import {ReturnStatusCriteria} from './ReturnStatusCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class ReturnSaleCriteria  extends   BaseCriteria  {

    public id: number;
    public returnDate: Date;
    public returnDateFrom: Date;
    public returnDateTo: Date;
     public amount: number;
     public amountMin: number;
     public amountMax: number;
  public sale: SaleCriteria ;
  public sales: Array<SaleCriteria> ;
  public returnStatus: ReturnStatusCriteria ;
  public returnStatuss: Array<ReturnStatusCriteria> ;
      public returnSaleItems: Array<ReturnSaleItemCriteria>;

}
