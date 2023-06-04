import {SaleItemCriteria} from './SaleItemCriteria.model';
import {StoreCriteria} from './StoreCriteria.model';
import {SaleStatusCriteria} from './SaleStatusCriteria.model';
import {ClientCriteria} from './ClientCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class SaleCriteria  extends   BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public saleDate: Date;
    public saleDateFrom: Date;
    public saleDateTo: Date;
     public total: number;
     public totalMin: number;
     public totalMax: number;
     public totalPaid: number;
     public totalPaidMin: number;
     public totalPaidMax: number;
    public description: string;
    public descriptionLike: string;
  public store: StoreCriteria ;
  public stores: Array<StoreCriteria> ;
  public client: ClientCriteria ;
  public clients: Array<ClientCriteria> ;
  public saleStatus: SaleStatusCriteria ;
  public saleStatuss: Array<SaleStatusCriteria> ;
      public saleItems: Array<SaleItemCriteria>;

}
