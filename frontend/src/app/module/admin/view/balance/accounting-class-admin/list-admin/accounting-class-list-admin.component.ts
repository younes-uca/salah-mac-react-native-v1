import {Component, OnInit} from '@angular/core';
import {AccountingClassService} from 'src/app/controller/service/AccountingClass.service';
import {AccountingClassDto} from 'src/app/controller/model/AccountingClass.model';
import {AccountingClassCriteria} from 'src/app/controller/criteria/AccountingClassCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-accounting-class-list-admin',
  templateUrl: './accounting-class-list-admin.component.html'
})
export class AccountingClassListAdminComponent extends AbstractListController<AccountingClassDto, AccountingClassCriteria, AccountingClassService>  implements OnInit {

    fileName = 'AccountingClass';

  
    constructor(accountingClassService: AccountingClassService) {
        super(accountingClassService);
        this.pdfName='AccountingClass.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadAccountingClasss(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('AccountingClass', 'list');
        isPermistted ? this.service.findAll().subscribe(accountingClasss => this.items = accountingClasss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
        ];
    }



	public initDuplicate(res: AccountingClassDto) {
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
