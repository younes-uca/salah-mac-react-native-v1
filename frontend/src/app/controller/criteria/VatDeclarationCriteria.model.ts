import {HandlingAccountantCriteria} from './HandlingAccountantCriteria.model';
import {CompanyCriteria} from './CompanyCriteria.model';
import {LatePaymentRateCriteria} from './LatePaymentRateCriteria.model';
import {ValidationAccountantCriteria} from './ValidationAccountantCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class VatDeclarationCriteria  extends   BaseCriteria  {

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
     public totalCollectedVat: number;
     public totalCollectedVatMin: number;
     public totalCollectedVatMax: number;
     public totalDueVat: number;
     public totalDueVatMin: number;
     public totalDueVatMax: number;
     public vatDifference: number;
     public vatDifferenceMin: number;
     public vatDifferenceMax: number;
     public vatAmount: number;
     public vatAmountMin: number;
     public vatAmountMax: number;
  public company: CompanyCriteria ;
  public companys: Array<CompanyCriteria> ;
  public latePaymentRate: LatePaymentRateCriteria ;
  public latePaymentRates: Array<LatePaymentRateCriteria> ;
  public handlingAccountant: HandlingAccountantCriteria ;
  public handlingAccountants: Array<HandlingAccountantCriteria> ;
  public validationAccountant: ValidationAccountantCriteria ;
  public validationAccountants: Array<ValidationAccountantCriteria> ;

}
