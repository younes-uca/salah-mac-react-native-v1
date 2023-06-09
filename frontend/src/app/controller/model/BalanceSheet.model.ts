import {CompanyDto} from './Company.model';
import {BalanceSheetStatusDto} from './BalanceSheetStatus.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class BalanceSheetDto  extends BaseDto{

    public id: number;
    public ref: string;
   public year: number;
    public intangibleAssets: number;
    public tangibleAssets: number;
    public financialAssets: number;
    public totalFixedAssets: number;
    public inventories: number;
    public accountsReceivable: number;
    public totalCurrentAssets: number;
    public bankDeposits: number;
    public cashInHand: number;
    public totalTreasuryAssets: number;
    public totalAssets: number;
    public equity: number;
    public loans: number;
    public profit: number;
    public totalPermanentFinancing: number;
    public accountsPayable: number;
    public otherCurrentLiabilities: number;
    public totalCurrentLiabilities: number;
    public totalLiabilities: number;
    public yearMax: string ;
    public yearMin: string ;
    public intangibleAssetsMax: string ;
    public intangibleAssetsMin: string ;
    public tangibleAssetsMax: string ;
    public tangibleAssetsMin: string ;
    public financialAssetsMax: string ;
    public financialAssetsMin: string ;
    public totalFixedAssetsMax: string ;
    public totalFixedAssetsMin: string ;
    public inventoriesMax: string ;
    public inventoriesMin: string ;
    public accountsReceivableMax: string ;
    public accountsReceivableMin: string ;
    public totalCurrentAssetsMax: string ;
    public totalCurrentAssetsMin: string ;
    public bankDepositsMax: string ;
    public bankDepositsMin: string ;
    public cashInHandMax: string ;
    public cashInHandMin: string ;
    public totalTreasuryAssetsMax: string ;
    public totalTreasuryAssetsMin: string ;
    public totalAssetsMax: string ;
    public totalAssetsMin: string ;
    public equityMax: string ;
    public equityMin: string ;
    public loansMax: string ;
    public loansMin: string ;
    public profitMax: string ;
    public profitMin: string ;
    public totalPermanentFinancingMax: string ;
    public totalPermanentFinancingMin: string ;
    public accountsPayableMax: string ;
    public accountsPayableMin: string ;
    public otherCurrentLiabilitiesMax: string ;
    public otherCurrentLiabilitiesMin: string ;
    public totalCurrentLiabilitiesMax: string ;
    public totalCurrentLiabilitiesMin: string ;
    public totalLiabilitiesMax: string ;
    public totalLiabilitiesMin: string ;
    public company: CompanyDto ;
    public balanceSheetStatus: BalanceSheetStatusDto ;

}
