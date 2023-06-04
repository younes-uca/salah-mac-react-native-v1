import {OrderCriteria} from './OrderCriteria.model';
import {ReceptionStatusCriteria} from './ReceptionStatusCriteria.model';
import {ReceptionItemCriteria} from './ReceptionItemCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class ReceptionCriteria  extends   BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public receptionDate: Date;
    public receptionDateFrom: Date;
    public receptionDateTo: Date;
    public description: string;
    public descriptionLike: string;
  public order: OrderCriteria ;
  public orders: Array<OrderCriteria> ;
  public receptionStatus: ReceptionStatusCriteria ;
  public receptionStatuss: Array<ReceptionStatusCriteria> ;
      public receptionItems: Array<ReceptionItemCriteria>;

}
