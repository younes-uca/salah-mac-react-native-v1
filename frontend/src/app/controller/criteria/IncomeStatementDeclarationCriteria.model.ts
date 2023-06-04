import {CorporateTaxRateCriteria} from './CorporateTaxRateCriteria.model';
import {HandlingAccountantCriteria} from './HandlingAccountantCriteria.model';
import {CompanyCriteria} from './CompanyCriteria.model';
import {ValidationAccountantCriteria} from './ValidationAccountantCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class IncomeStatementDeclarationCriteria  extends   BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public declarationDate: Date;
    public declarationDateFrom: Date;
    public declarationDateTo: Date;
     public quarter: number;
     public quarterMin: number;
     public quarterMax: number;
     public year: number;
     public yearMin: number;
     public yearMax: number;
     public totalExpense: number;
     public totalExpenseMin: number;
     public totalExpenseMax: number;
     public totalRevenue: number;
     public totalRevenueMin: number;
     public totalRevenueMax: number;
     public incomeBeforeTax: number;
     public incomeBeforeTaxMin: number;
     public incomeBeforeTaxMax: number;
     public taxAmount: number;
     public taxAmountMin: number;
     public taxAmountMax: number;
     public incomeAfterTax: number;
     public incomeAfterTaxMin: number;
     public incomeAfterTaxMax: number;
  public company: CompanyCriteria ;
  public companys: Array<CompanyCriteria> ;
  public corporateTaxRate: CorporateTaxRateCriteria ;
  public corporateTaxRates: Array<CorporateTaxRateCriteria> ;
  public handlingAccountant: HandlingAccountantCriteria ;
  public handlingAccountants: Array<HandlingAccountantCriteria> ;
  public validationAccountant: ValidationAccountantCriteria ;
  public validationAccountants: Array<ValidationAccountantCriteria> ;

}
