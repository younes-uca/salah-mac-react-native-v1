import {DemandDto} from './Demand.model';
import {DeliveryItemDto} from './DeliveryItem.model';
import {DeliveryStatusDto} from './DeliveryStatus.model';
import {ClientDto} from './Client.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class DeliveryDto  extends BaseDto{

    public id: number;
   public deliveryDate: Date;
    public deliveryDateMax: string ;
    public deliveryDateMin: string ;
    public demand: DemandDto ;
    public deliveryStatus: DeliveryStatusDto ;
    public client: ClientDto ;
     public deliveryItems: Array<DeliveryItemDto>;

}
