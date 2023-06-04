import {HandlingAccountantDto} from './HandlingAccountant.model';
import {CompanyDto} from './Company.model';
import {LatePaymentRateDto} from './LatePaymentRate.model';
import {ValidationAccountantDto} from './ValidationAccountant.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class VatDeclarationDto  extends BaseDto{

    public id: number;
    public reference: string;
   public declarationDate: Date;
   public quarter: number;
   public year: number;
    public totalCollectedVat: number;
    public totalDueVat: number;
    public vatDifference: number;
    public vatAmount: number;
    public declarationDateMax: string ;
    public declarationDateMin: string ;
    public quarterMax: string ;
    public quarterMin: string ;
    public yearMax: string ;
    public yearMin: string ;
    public totalCollectedVatMax: string ;
    public totalCollectedVatMin: string ;
    public totalDueVatMax: string ;
    public totalDueVatMin: string ;
    public vatDifferenceMax: string ;
    public vatDifferenceMin: string ;
    public vatAmountMax: string ;
    public vatAmountMin: string ;
    public company: CompanyDto ;
    public latePaymentRate: LatePaymentRateDto ;
    public handlingAccountant: HandlingAccountantDto ;
    public validationAccountant: ValidationAccountantDto ;

}
