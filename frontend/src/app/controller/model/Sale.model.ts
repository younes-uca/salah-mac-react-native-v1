import {SaleItemDto} from './SaleItem.model';
import {StoreDto} from './Store.model';
import {SaleStatusDto} from './SaleStatus.model';
import {ClientDto} from './Client.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class SaleDto  extends BaseDto{

    public id: number;
    public reference: string;
   public saleDate: Date;
    public total: number;
    public totalPaid: number;
    public description: string;
    public saleDateMax: string ;
    public saleDateMin: string ;
    public totalMax: string ;
    public totalMin: string ;
    public totalPaidMax: string ;
    public totalPaidMin: string ;
    public store: StoreDto ;
    public client: ClientDto ;
    public saleStatus: SaleStatusDto ;
     public saleItems: Array<SaleItemDto>;

}
