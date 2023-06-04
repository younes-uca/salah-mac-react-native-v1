import {PurchaseStatusCriteria} from './PurchaseStatusCriteria.model';
import {StoreCriteria} from './StoreCriteria.model';
import {PurchaseItemCriteria} from './PurchaseItemCriteria.model';
import {SupplierCriteria} from './SupplierCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class PurchaseCriteria  extends   BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public purchaseDate: Date;
    public purchaseDateFrom: Date;
    public purchaseDateTo: Date;
     public total: number;
     public totalMin: number;
     public totalMax: number;
     public totalPaid: number;
     public totalPaidMin: number;
     public totalPaidMax: number;
    public description: string;
    public descriptionLike: string;
  public supplier: SupplierCriteria ;
  public suppliers: Array<SupplierCriteria> ;
  public store: StoreCriteria ;
  public stores: Array<StoreCriteria> ;
  public purchaseStatus: PurchaseStatusCriteria ;
  public purchaseStatuss: Array<PurchaseStatusCriteria> ;
      public purchaseItems: Array<PurchaseItemCriteria>;

}
