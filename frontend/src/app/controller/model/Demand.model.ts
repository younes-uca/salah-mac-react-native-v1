import {DemandItemDto} from './DemandItem.model';
import {DemandStatusDto} from './DemandStatus.model';
import {ClientDto} from './Client.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class DemandDto  extends BaseDto{

    public id: number;
    public reference: string;
   public demandDate: Date;
    public totalCheck: number;
    public totalCash: number;
    public total: number;
    public totalPaid: number;
    public demandDateMax: string ;
    public demandDateMin: string ;
    public totalCheckMax: string ;
    public totalCheckMin: string ;
    public totalCashMax: string ;
    public totalCashMin: string ;
    public totalMax: string ;
    public totalMin: string ;
    public totalPaidMax: string ;
    public totalPaidMin: string ;
    public client: ClientDto ;
    public demandStatus: DemandStatusDto ;
     public demandItems: Array<DemandItemDto>;

}
