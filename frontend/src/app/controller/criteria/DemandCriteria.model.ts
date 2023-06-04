import {DemandItemCriteria} from './DemandItemCriteria.model';
import {DemandStatusCriteria} from './DemandStatusCriteria.model';
import {ClientCriteria} from './ClientCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class DemandCriteria  extends   BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public demandDate: Date;
    public demandDateFrom: Date;
    public demandDateTo: Date;
     public totalCheck: number;
     public totalCheckMin: number;
     public totalCheckMax: number;
     public totalCash: number;
     public totalCashMin: number;
     public totalCashMax: number;
     public total: number;
     public totalMin: number;
     public totalMax: number;
     public totalPaid: number;
     public totalPaidMin: number;
     public totalPaidMax: number;
  public client: ClientCriteria ;
  public clients: Array<ClientCriteria> ;
  public demandStatus: DemandStatusCriteria ;
  public demandStatuss: Array<DemandStatusCriteria> ;
      public demandItems: Array<DemandItemCriteria>;

}
