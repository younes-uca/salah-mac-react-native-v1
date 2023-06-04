import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class CorporateTaxRateDto  extends BaseDto{

    public id: number;
    public minimumIncome: number;
    public maximumIncome: number;
   public minApplicationDate: Date;
   public maxApplicationDate: Date;
    public percentage: number;
    public minimumIncomeMax: string ;
    public minimumIncomeMin: string ;
    public maximumIncomeMax: string ;
    public maximumIncomeMin: string ;
    public minApplicationDateMax: string ;
    public minApplicationDateMin: string ;
    public maxApplicationDateMax: string ;
    public maxApplicationDateMin: string ;
    public percentageMax: string ;
    public percentageMin: string ;

}
