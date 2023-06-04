import {Component, OnInit} from '@angular/core';
import {AccountingOperationTypeService} from 'src/app/controller/service/AccountingOperationType.service';
import {AccountingOperationTypeDto} from 'src/app/controller/model/AccountingOperationType.model';
import {AccountingOperationTypeCriteria} from 'src/app/controller/criteria/AccountingOperationTypeCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-accounting-operation-type-list-admin',
  templateUrl: './accounting-operation-type-list-admin.component.html'
})
export class AccountingOperationTypeListAdminComponent extends AbstractListController<AccountingOperationTypeDto, AccountingOperationTypeCriteria, AccountingOperationTypeService>  implements OnInit {

    fileName = 'AccountingOperationType';

  
    constructor(accountingOperationTypeService: AccountingOperationTypeService) {
        super(accountingOperationTypeService);
        this.pdfName='AccountingOperationType.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadAccountingOperationTypes(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('AccountingOperationType', 'list');
        isPermistted ? this.service.findAll().subscribe(accountingOperationTypes => this.items = accountingOperationTypes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
        ];
    }



	public initDuplicate(res: AccountingOperationTypeDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Libelle': e.libelle ,
                 'Code': e.code ,
            }
        });

        this.criteriaData = [{
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
        }];
      }
}
