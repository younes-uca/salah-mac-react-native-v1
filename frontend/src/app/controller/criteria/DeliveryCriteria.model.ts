import {DemandCriteria} from './DemandCriteria.model';
import {DeliveryItemCriteria} from './DeliveryItemCriteria.model';
import {DeliveryStatusCriteria} from './DeliveryStatusCriteria.model';
import {ClientCriteria} from './ClientCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class DeliveryCriteria  extends   BaseCriteria  {

    public id: number;
    public deliveryDate: Date;
    public deliveryDateFrom: Date;
    public deliveryDateTo: Date;
  public demand: DemandCriteria ;
  public demands: Array<DemandCriteria> ;
  public deliveryStatus: DeliveryStatusCriteria ;
  public deliveryStatuss: Array<DeliveryStatusCriteria> ;
  public client: ClientCriteria ;
  public clients: Array<ClientCriteria> ;
      public deliveryItems: Array<DeliveryItemCriteria>;

}
