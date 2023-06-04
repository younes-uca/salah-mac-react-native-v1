import {Component, OnInit} from '@angular/core';
import {AccountingOperationService} from 'src/app/controller/service/AccountingOperation.service';
import {AccountingOperationDto} from 'src/app/controller/model/AccountingOperation.model';
import {AccountingOperationCriteria} from 'src/app/controller/criteria/AccountingOperationCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { CompanyService } from 'src/app/controller/service/Company.service';
import { AccountingAccountService } from 'src/app/controller/service/AccountingAccount.service';
import { AccountingOperationTypeService } from 'src/app/controller/service/AccountingOperationType.service';
import { AccountingOperationStatusService } from 'src/app/controller/service/AccountingOperationStatus.service';

import {AccountingOperationTypeDto} from 'src/app/controller/model/AccountingOperationType.model';
import {CompanyDto} from 'src/app/controller/model/Company.model';
import {AccountingOperationStatusDto} from 'src/app/controller/model/AccountingOperationStatus.model';
import {AccountingAccountDto} from 'src/app/controller/model/AccountingAccount.model';


@Component({
  selector: 'app-accounting-operation-list-admin',
  templateUrl: './accounting-operation-list-admin.component.html'
})
export class AccountingOperationListAdminComponent extends AbstractListController<AccountingOperationDto, AccountingOperationCriteria, AccountingOperationService>  implements OnInit {

    fileName = 'AccountingOperation';

    companys :Array<CompanyDto>;
    accountingAccounts :Array<AccountingAccountDto>;
    accountingOperationTypes :Array<AccountingOperationTypeDto>;
    accountingOperationStatuss :Array<AccountingOperationStatusDto>;
  
    constructor(accountingOperationService: AccountingOperationService, private companyService: CompanyService, private accountingAccountService: AccountingAccountService, private accountingOperationTypeService: AccountingOperationTypeService, private accountingOperationStatusService: AccountingOperationStatusService) {
        super(accountingOperationService);
        this.pdfName='AccountingOperation.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadCompany();
      this.loadAccountingAccount();
      this.loadAccountingOperationType();
      this.loadAccountingOperationStatus();
    }

    public async loadAccountingOperations(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('AccountingOperation', 'list');
        isPermistted ? this.service.findAll().subscribe(accountingOperations => this.items = accountingOperations,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'year', header: 'Year'},
            {field: 'month', header: 'Month'},
            {field: 'accountingOperationDate', header: 'Accounting operation date'},
            {field: 'amount', header: 'Amount'},
            {field: 'company?.ice', header: 'Company'},
            {field: 'accountingAccount?.libelle', header: 'Accounting account'},
            {field: 'accountingOperationType?.libelle', header: 'Accounting operation type'},
            {field: 'accountingOperationStatus?.libelle', header: 'Accounting operation status'},
        ];
    }


    public async loadCompany(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('AccountingOperation', 'list');
        isPermistted ? this.companyService.findAllOptimized().subscribe(companys => this.companys = companys,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadAccountingAccount(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('AccountingOperation', 'list');
        isPermistted ? this.accountingAccountService.findAllOptimized().subscribe(accountingAccounts => this.accountingAccounts = accountingAccounts,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadAccountingOperationType(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('AccountingOperation', 'list');
        isPermistted ? this.accountingOperationTypeService.findAllOptimized().subscribe(accountingOperationTypes => this.accountingOperationTypes = accountingOperationTypes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadAccountingOperationStatus(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('AccountingOperation', 'list');
        isPermistted ? this.accountingOperationStatusService.findAllOptimized().subscribe(accountingOperationStatuss => this.accountingOperationStatuss = accountingOperationStatuss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: AccountingOperationDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Libelle': e.libelle ,
                 'Year': e.year ,
                 'Month': e.month ,
                'Accounting operation date': this.datePipe.transform(e.accountingOperationDate , 'dd/MM/yyyy hh:mm'),
                 'Amount': e.amount ,
                'Company': e.company?.ice ,
                'Accounting account': e.accountingAccount?.libelle ,
                'Accounting operation type': e.accountingOperationType?.libelle ,
                'Accounting operation status': e.accountingOperationStatus?.libelle ,
            }
        });

        this.criteriaData = [{
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
            'Year Min': this.criteria.yearMin ? this.criteria.yearMin : environment.emptyForExport ,
            'Year Max': this.criteria.yearMax ? this.criteria.yearMax : environment.emptyForExport ,
            'Month Min': this.criteria.monthMin ? this.criteria.monthMin : environment.emptyForExport ,
            'Month Max': this.criteria.monthMax ? this.criteria.monthMax : environment.emptyForExport ,
            'Accounting operation date Min': this.criteria.accountingOperationDateFrom ? this.datePipe.transform(this.criteria.accountingOperationDateFrom , this.dateFormat) : environment.emptyForExport ,
            'Accounting operation date Max': this.criteria.accountingOperationDateTo ? this.datePipe.transform(this.criteria.accountingOperationDateTo , this.dateFormat) : environment.emptyForExport ,
            'Amount Min': this.criteria.amountMin ? this.criteria.amountMin : environment.emptyForExport ,
            'Amount Max': this.criteria.amountMax ? this.criteria.amountMax : environment.emptyForExport ,
        //'Company': this.criteria.company?.ice ? this.criteria.company?.ice : environment.emptyForExport ,
        //'Accounting account': this.criteria.accountingAccount?.libelle ? this.criteria.accountingAccount?.libelle : environment.emptyForExport ,
        //'Accounting operation type': this.criteria.accountingOperationType?.libelle ? this.criteria.accountingOperationType?.libelle : environment.emptyForExport ,
        //'Accounting operation status': this.criteria.accountingOperationStatus?.libelle ? this.criteria.accountingOperationStatus?.libelle : environment.emptyForExport ,
        }];
      }
}
