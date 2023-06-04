import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class SupplierDto  extends BaseDto{

    public id: number;
    public ice: string;
    public name: string;
    public tel: string;
    public email: string;
    public address: string;
    public description: string;
    public debt: number;
    public debtMax: string ;
    public debtMin: string ;

}
