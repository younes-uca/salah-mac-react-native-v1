import {PurchaseCriteria} from './PurchaseCriteria.model';
import {CreditNotePurchaseStatusCriteria} from './CreditNotePurchaseStatusCriteria.model';
import {CreditNotePurchaseItemCriteria} from './CreditNotePurchaseItemCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class CreditNotePurchaseCriteria  extends   BaseCriteria  {

    public id: number;
    public creditNoteDate: Date;
    public creditNoteDateFrom: Date;
    public creditNoteDateTo: Date;
     public amount: number;
     public amountMin: number;
     public amountMax: number;
  public purchase: PurchaseCriteria ;
  public purchases: Array<PurchaseCriteria> ;
  public creditNotePurchaseStatus: CreditNotePurchaseStatusCriteria ;
  public creditNotePurchaseStatuss: Array<CreditNotePurchaseStatusCriteria> ;
      public creditNotePurchaseItems: Array<CreditNotePurchaseItemCriteria>;

}
