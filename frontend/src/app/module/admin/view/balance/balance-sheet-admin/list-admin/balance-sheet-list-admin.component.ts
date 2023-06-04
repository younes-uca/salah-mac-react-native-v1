import {Component, OnInit} from '@angular/core';
import {BalanceSheetService} from 'src/app/controller/service/BalanceSheet.service';
import {BalanceSheetDto} from 'src/app/controller/model/BalanceSheet.model';
import {BalanceSheetCriteria} from 'src/app/controller/criteria/BalanceSheetCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { CompanyService } from 'src/app/controller/service/Company.service';
import { BalanceSheetStatusService } from 'src/app/controller/service/BalanceSheetStatus.service';

import {CompanyDto} from 'src/app/controller/model/Company.model';
import {BalanceSheetStatusDto} from 'src/app/controller/model/BalanceSheetStatus.model';


@Component({
  selector: 'app-balance-sheet-list-admin',
  templateUrl: './balance-sheet-list-admin.component.html'
})
export class BalanceSheetListAdminComponent extends AbstractListController<BalanceSheetDto, BalanceSheetCriteria, BalanceSheetService>  implements OnInit {

    fileName = 'BalanceSheet';

    companys :Array<CompanyDto>;
    balanceSheetStatuss :Array<BalanceSheetStatusDto>;
  
    constructor(balanceSheetService: BalanceSheetService, private companyService: CompanyService, private balanceSheetStatusService: BalanceSheetStatusService) {
        super(balanceSheetService);
        this.pdfName='BalanceSheet.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadCompany();
      this.loadBalanceSheetStatus();
    }

    public async loadBalanceSheets(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('BalanceSheet', 'list');
        isPermistted ? this.service.findAll().subscribe(balanceSheets => this.items = balanceSheets,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'ref', header: 'Ref'},
            {field: 'year', header: 'Year'},
            {field: 'company?.ice', header: 'Company'},
            {field: 'intangibleAssets', header: 'Intangible assets'},
            {field: 'tangibleAssets', header: 'Tangible assets'},
            {field: 'financialAssets', header: 'Financial assets'},
            {field: 'totalFixedAssets', header: 'Total fixed assets'},
            {field: 'inventories', header: 'Inventories'},
            {field: 'accountsReceivable', header: 'Accounts receivable'},
            {field: 'totalCurrentAssets', header: 'Total current assets'},
            {field: 'bankDeposits', header: 'Bank deposits'},
            {field: 'cashInHand', header: 'Cash in hand'},
            {field: 'totalTreasuryAssets', header: 'Total treasury assets'},
            {field: 'totalAssets', header: 'Total assets'},
            {field: 'equity', header: 'Equity'},
            {field: 'loans', header: 'Loans'},
            {field: 'profit', header: 'Profit'},
            {field: 'totalPermanentFinancing', header: 'Total permanent financing'},
            {field: 'accountsPayable', header: 'Accounts payable'},
            {field: 'otherCurrentLiabilities', header: 'Other current liabilities'},
            {field: 'totalCurrentLiabilities', header: 'Total current liabilities'},
            {field: 'totalLiabilities', header: 'Total liabilities'},
            {field: 'balanceSheetStatus?.libelle', header: 'Balance sheet status'},
        ];
    }


    public async loadCompany(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('BalanceSheet', 'list');
        isPermistted ? this.companyService.findAllOptimized().subscribe(companys => this.companys = companys,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadBalanceSheetStatus(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('BalanceSheet', 'list');
        isPermistted ? this.balanceSheetStatusService.findAllOptimized().subscribe(balanceSheetStatuss => this.balanceSheetStatuss = balanceSheetStatuss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: BalanceSheetDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Ref': e.ref ,
                 'Year': e.year ,
                'Company': e.company?.ice ,
                 'Intangible assets': e.intangibleAssets ,
                 'Tangible assets': e.tangibleAssets ,
                 'Financial assets': e.financialAssets ,
                 'Total fixed assets': e.totalFixedAssets ,
                 'Inventories': e.inventories ,
                 'Accounts receivable': e.accountsReceivable ,
                 'Total current assets': e.totalCurrentAssets ,
                 'Bank deposits': e.bankDeposits ,
                 'Cash in hand': e.cashInHand ,
                 'Total treasury assets': e.totalTreasuryAssets ,
                 'Total assets': e.totalAssets ,
                 'Equity': e.equity ,
                 'Loans': e.loans ,
                 'Profit': e.profit ,
                 'Total permanent financing': e.totalPermanentFinancing ,
                 'Accounts payable': e.accountsPayable ,
                 'Other current liabilities': e.otherCurrentLiabilities ,
                 'Total current liabilities': e.totalCurrentLiabilities ,
                 'Total liabilities': e.totalLiabilities ,
                'Balance sheet status': e.balanceSheetStatus?.libelle ,
            }
        });

        this.criteriaData = [{
            'Ref': this.criteria.ref ? this.criteria.ref : environment.emptyForExport ,
            'Year Min': this.criteria.yearMin ? this.criteria.yearMin : environment.emptyForExport ,
            'Year Max': this.criteria.yearMax ? this.criteria.yearMax : environment.emptyForExport ,
        //'Company': this.criteria.company?.ice ? this.criteria.company?.ice : environment.emptyForExport ,
            'Intangible assets Min': this.criteria.intangibleAssetsMin ? this.criteria.intangibleAssetsMin : environment.emptyForExport ,
            'Intangible assets Max': this.criteria.intangibleAssetsMax ? this.criteria.intangibleAssetsMax : environment.emptyForExport ,
            'Tangible assets Min': this.criteria.tangibleAssetsMin ? this.criteria.tangibleAssetsMin : environment.emptyForExport ,
            'Tangible assets Max': this.criteria.tangibleAssetsMax ? this.criteria.tangibleAssetsMax : environment.emptyForExport ,
            'Financial assets Min': this.criteria.financialAssetsMin ? this.criteria.financialAssetsMin : environment.emptyForExport ,
            'Financial assets Max': this.criteria.financialAssetsMax ? this.criteria.financialAssetsMax : environment.emptyForExport ,
            'Total fixed assets Min': this.criteria.totalFixedAssetsMin ? this.criteria.totalFixedAssetsMin : environment.emptyForExport ,
            'Total fixed assets Max': this.criteria.totalFixedAssetsMax ? this.criteria.totalFixedAssetsMax : environment.emptyForExport ,
            'Inventories Min': this.criteria.inventoriesMin ? this.criteria.inventoriesMin : environment.emptyForExport ,
            'Inventories Max': this.criteria.inventoriesMax ? this.criteria.inventoriesMax : environment.emptyForExport ,
            'Accounts receivable Min': this.criteria.accountsReceivableMin ? this.criteria.accountsReceivableMin : environment.emptyForExport ,
            'Accounts receivable Max': this.criteria.accountsReceivableMax ? this.criteria.accountsReceivableMax : environment.emptyForExport ,
            'Total current assets Min': this.criteria.totalCurrentAssetsMin ? this.criteria.totalCurrentAssetsMin : environment.emptyForExport ,
            'Total current assets Max': this.criteria.totalCurrentAssetsMax ? this.criteria.totalCurrentAssetsMax : environment.emptyForExport ,
            'Bank deposits Min': this.criteria.bankDepositsMin ? this.criteria.bankDepositsMin : environment.emptyForExport ,
            'Bank deposits Max': this.criteria.bankDepositsMax ? this.criteria.bankDepositsMax : environment.emptyForExport ,
            'Cash in hand Min': this.criteria.cashInHandMin ? this.criteria.cashInHandMin : environment.emptyForExport ,
            'Cash in hand Max': this.criteria.cashInHandMax ? this.criteria.cashInHandMax : environment.emptyForExport ,
            'Total treasury assets Min': this.criteria.totalTreasuryAssetsMin ? this.criteria.totalTreasuryAssetsMin : environment.emptyForExport ,
            'Total treasury assets Max': this.criteria.totalTreasuryAssetsMax ? this.criteria.totalTreasuryAssetsMax : environment.emptyForExport ,
            'Total assets Min': this.criteria.totalAssetsMin ? this.criteria.totalAssetsMin : environment.emptyForExport ,
            'Total assets Max': this.criteria.totalAssetsMax ? this.criteria.totalAssetsMax : environment.emptyForExport ,
            'Equity Min': this.criteria.equityMin ? this.criteria.equityMin : environment.emptyForExport ,
            'Equity Max': this.criteria.equityMax ? this.criteria.equityMax : environment.emptyForExport ,
            'Loans Min': this.criteria.loansMin ? this.criteria.loansMin : environment.emptyForExport ,
            'Loans Max': this.criteria.loansMax ? this.criteria.loansMax : environment.emptyForExport ,
            'Profit Min': this.criteria.profitMin ? this.criteria.profitMin : environment.emptyForExport ,
            'Profit Max': this.criteria.profitMax ? this.criteria.profitMax : environment.emptyForExport ,
            'Total permanent financing Min': this.criteria.totalPermanentFinancingMin ? this.criteria.totalPermanentFinancingMin : environment.emptyForExport ,
            'Total permanent financing Max': this.criteria.totalPermanentFinancingMax ? this.criteria.totalPermanentFinancingMax : environment.emptyForExport ,
            'Accounts payable Min': this.criteria.accountsPayableMin ? this.criteria.accountsPayableMin : environment.emptyForExport ,
            'Accounts payable Max': this.criteria.accountsPayableMax ? this.criteria.accountsPayableMax : environment.emptyForExport ,
            'Other current liabilities Min': this.criteria.otherCurrentLiabilitiesMin ? this.criteria.otherCurrentLiabilitiesMin : environment.emptyForExport ,
            'Other current liabilities Max': this.criteria.otherCurrentLiabilitiesMax ? this.criteria.otherCurrentLiabilitiesMax : environment.emptyForExport ,
            'Total current liabilities Min': this.criteria.totalCurrentLiabilitiesMin ? this.criteria.totalCurrentLiabilitiesMin : environment.emptyForExport ,
            'Total current liabilities Max': this.criteria.totalCurrentLiabilitiesMax ? this.criteria.totalCurrentLiabilitiesMax : environment.emptyForExport ,
            'Total liabilities Min': this.criteria.totalLiabilitiesMin ? this.criteria.totalLiabilitiesMin : environment.emptyForExport ,
            'Total liabilities Max': this.criteria.totalLiabilitiesMax ? this.criteria.totalLiabilitiesMax : environment.emptyForExport ,
        //'Balance sheet status': this.criteria.balanceSheetStatus?.libelle ? this.criteria.balanceSheetStatus?.libelle : environment.emptyForExport ,
        }];
      }
}
