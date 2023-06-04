import {Component, OnInit} from '@angular/core';
import {SubAccountingClassService} from 'src/app/controller/service/SubAccountingClass.service';
import {SubAccountingClassDto} from 'src/app/controller/model/SubAccountingClass.model';
import {SubAccountingClassCriteria} from 'src/app/controller/criteria/SubAccountingClassCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { AccountingClassService } from 'src/app/controller/service/AccountingClass.service';

import {AccountingClassDto} from 'src/app/controller/model/AccountingClass.model';


@Component({
  selector: 'app-sub-accounting-class-list-admin',
  templateUrl: './sub-accounting-class-list-admin.component.html'
})
export class SubAccountingClassListAdminComponent extends AbstractListController<SubAccountingClassDto, SubAccountingClassCriteria, SubAccountingClassService>  implements OnInit {

    fileName = 'SubAccountingClass';

    accountingClasss :Array<AccountingClassDto>;
  
    constructor(subAccountingClassService: SubAccountingClassService, private accountingClassService: AccountingClassService) {
        super(subAccountingClassService);
        this.pdfName='SubAccountingClass.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadAccountingClass();
    }

    public async loadSubAccountingClasss(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('SubAccountingClass', 'list');
        isPermistted ? this.service.findAll().subscribe(subAccountingClasss => this.items = subAccountingClasss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'accountingClass?.libelle', header: 'Accounting class'},
        ];
    }


    public async loadAccountingClass(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('SubAccountingClass', 'list');
        isPermistted ? this.accountingClassService.findAllOptimized().subscribe(accountingClasss => this.accountingClasss = accountingClasss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: SubAccountingClassDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Libelle': e.libelle ,
                 'Code': e.code ,
                'Accounting class': e.accountingClass?.libelle ,
            }
        });

        this.criteriaData = [{
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
        //'Accounting class': this.criteria.accountingClass?.libelle ? this.criteria.accountingClass?.libelle : environment.emptyForExport ,
        }];
      }
}
