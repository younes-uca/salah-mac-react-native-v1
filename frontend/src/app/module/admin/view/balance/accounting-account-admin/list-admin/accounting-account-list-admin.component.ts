import {Component, OnInit} from '@angular/core';
import {AccountingAccountService} from 'src/app/controller/service/AccountingAccount.service';
import {AccountingAccountDto} from 'src/app/controller/model/AccountingAccount.model';
import {AccountingAccountCriteria} from 'src/app/controller/criteria/AccountingAccountCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { SubAccountingClassService } from 'src/app/controller/service/SubAccountingClass.service';

import {SubAccountingClassDto} from 'src/app/controller/model/SubAccountingClass.model';


@Component({
  selector: 'app-accounting-account-list-admin',
  templateUrl: './accounting-account-list-admin.component.html'
})
export class AccountingAccountListAdminComponent extends AbstractListController<AccountingAccountDto, AccountingAccountCriteria, AccountingAccountService>  implements OnInit {

    fileName = 'AccountingAccount';

    subAccountingClasss :Array<SubAccountingClassDto>;
  
    constructor(accountingAccountService: AccountingAccountService, private subAccountingClassService: SubAccountingClassService) {
        super(accountingAccountService);
        this.pdfName='AccountingAccount.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadSubAccountingClass();
    }

    public async loadAccountingAccounts(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('AccountingAccount', 'list');
        isPermistted ? this.service.findAll().subscribe(accountingAccounts => this.items = accountingAccounts,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'subAccountingClass?.libelle', header: 'Sub accounting class'},
        ];
    }


    public async loadSubAccountingClass(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('AccountingAccount', 'list');
        isPermistted ? this.subAccountingClassService.findAllOptimized().subscribe(subAccountingClasss => this.subAccountingClasss = subAccountingClasss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: AccountingAccountDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Libelle': e.libelle ,
                 'Code': e.code ,
                'Sub accounting class': e.subAccountingClass?.libelle ,
            }
        });

        this.criteriaData = [{
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
        //'Sub accounting class': this.criteria.subAccountingClass?.libelle ? this.criteria.subAccountingClass?.libelle : environment.emptyForExport ,
        }];
      }
}
