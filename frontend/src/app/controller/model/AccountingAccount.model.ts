import {SubAccountingClassDto} from './SubAccountingClass.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class AccountingAccountDto  extends BaseDto{

    public id: number;
    public libelle: string;
    public code: string;
    public subAccountingClass: SubAccountingClassDto ;

}
