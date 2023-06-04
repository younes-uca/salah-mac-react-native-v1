import {PurchaseStatusDto} from './PurchaseStatus.model';
import {StoreDto} from './Store.model';
import {PurchaseItemDto} from './PurchaseItem.model';
import {SupplierDto} from './Supplier.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class PurchaseDto  extends BaseDto{

    public id: number;
    public reference: string;
   public purchaseDate: Date;
    public total: number;
    public totalPaid: number;
    public description: string;
    public purchaseDateMax: string ;
    public purchaseDateMin: string ;
    public totalMax: string ;
    public totalMin: string ;
    public totalPaidMax: string ;
    public totalPaidMin: string ;
    public supplier: SupplierDto ;
    public store: StoreDto ;
    public purchaseStatus: PurchaseStatusDto ;
     public purchaseItems: Array<PurchaseItemDto>;

}
