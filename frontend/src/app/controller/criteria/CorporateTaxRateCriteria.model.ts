import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class CorporateTaxRateCriteria  extends   BaseCriteria  {

    public id: number;
     public minimumIncome: number;
     public minimumIncomeMin: number;
     public minimumIncomeMax: number;
     public maximumIncome: number;
     public maximumIncomeMin: number;
     public maximumIncomeMax: number;
    public minApplicationDate: Date;
    public minApplicationDateFrom: Date;
    public minApplicationDateTo: Date;
    public maxApplicationDate: Date;
    public maxApplicationDateFrom: Date;
    public maxApplicationDateTo: Date;
     public percentage: number;
     public percentageMin: number;
     public percentageMax: number;

}
