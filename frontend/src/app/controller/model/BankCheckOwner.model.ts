import {BankDto} from './Bank.model';
import {CheckOwnerDto} from './CheckOwner.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class BankCheckOwnerDto  extends BaseDto{

    public id: number;
    public checkOwner: CheckOwnerDto ;
    public bank: BankDto ;

}
