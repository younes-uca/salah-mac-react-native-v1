import {AccountingClassDto} from './AccountingClass.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class SubAccountingClassDto  extends BaseDto{

    public id: number;
    public libelle: string;
    public code: string;
    public accountingClass: AccountingClassDto ;

}
