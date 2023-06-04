import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class SupplierCriteria  extends   BaseCriteria  {

    public id: number;
    public ice: string;
    public iceLike: string;
    public name: string;
    public nameLike: string;
    public tel: string;
    public telLike: string;
    public email: string;
    public emailLike: string;
    public address: string;
    public addressLike: string;
    public description: string;
    public descriptionLike: string;
     public debt: number;
     public debtMin: number;
     public debtMax: number;

}
