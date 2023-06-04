import {Component, OnInit} from '@angular/core';
import {AccountingOperationStatusService} from 'src/app/controller/service/AccountingOperationStatus.service';
import {AccountingOperationStatusDto} from 'src/app/controller/model/AccountingOperationStatus.model';
import {AccountingOperationStatusCriteria} from 'src/app/controller/criteria/AccountingOperationStatusCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-accounting-operation-status-list-admin',
  templateUrl: './accounting-operation-status-list-admin.component.html'
})
export class AccountingOperationStatusListAdminComponent extends AbstractListController<AccountingOperationStatusDto, AccountingOperationStatusCriteria, AccountingOperationStatusService>  implements OnInit {

    fileName = 'AccountingOperationStatus';

  
    constructor(accountingOperationStatusService: AccountingOperationStatusService) {
        super(accountingOperationStatusService);
        this.pdfName='AccountingOperationStatus.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadAccountingOperationStatuss(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('AccountingOperationStatus', 'list');
        isPermistted ? this.service.findAll().subscribe(accountingOperationStatuss => this.items = accountingOperationStatuss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
        ];
    }



	public initDuplicate(res: AccountingOperationStatusDto) {
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
