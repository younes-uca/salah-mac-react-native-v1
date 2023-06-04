import {CorporateTaxRateDto} from './CorporateTaxRate.model';
import {HandlingAccountantDto} from './HandlingAccountant.model';
import {CompanyDto} from './Company.model';
import {ValidationAccountantDto} from './ValidationAccountant.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class IncomeStatementDeclarationDto  extends BaseDto{

    public id: number;
    public reference: string;
   public declarationDate: Date;
   public quarter: number;
   public year: number;
    public totalExpense: number;
    public totalRevenue: number;
    public incomeBeforeTax: number;
    public taxAmount: number;
    public incomeAfterTax: number;
    public declarationDateMax: string ;
    public declarationDateMin: string ;
    public quarterMax: string ;
    public quarterMin: string ;
    public yearMax: string ;
    public yearMin: string ;
    public totalExpenseMax: string ;
    public totalExpenseMin: string ;
    public totalRevenueMax: string ;
    public totalRevenueMin: string ;
    public incomeBeforeTaxMax: string ;
    public incomeBeforeTaxMin: string ;
    public taxAmountMax: string ;
    public taxAmountMin: string ;
    public incomeAfterTaxMax: string ;
    public incomeAfterTaxMin: string ;
    public company: CompanyDto ;
    public corporateTaxRate: CorporateTaxRateDto ;
    public handlingAccountant: HandlingAccountantDto ;
    public validationAccountant: ValidationAccountantDto ;

}
