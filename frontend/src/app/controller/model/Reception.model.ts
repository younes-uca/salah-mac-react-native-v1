import {OrderDto} from './Order.model';
import {ReceptionStatusDto} from './ReceptionStatus.model';
import {ReceptionItemDto} from './ReceptionItem.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class ReceptionDto  extends BaseDto{

    public id: number;
    public reference: string;
   public receptionDate: Date;
    public description: string;
    public receptionDateMax: string ;
    public receptionDateMin: string ;
    public order: OrderDto ;
    public receptionStatus: ReceptionStatusDto ;
     public receptionItems: Array<ReceptionItemDto>;

}
