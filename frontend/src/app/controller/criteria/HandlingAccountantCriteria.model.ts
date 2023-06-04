import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class HandlingAccountantCriteria  extends   BaseCriteria  {

    public id: number;
    public cin: string;
    public cinLike: string;
    public lastName: string;
    public lastNameLike: string;
    public firstName: string;
    public firstNameLike: string;

}
