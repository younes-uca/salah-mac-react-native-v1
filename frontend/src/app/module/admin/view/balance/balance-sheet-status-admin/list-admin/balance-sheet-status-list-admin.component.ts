import {Component, OnInit} from '@angular/core';
import {BalanceSheetStatusService} from 'src/app/controller/service/BalanceSheetStatus.service';
import {BalanceSheetStatusDto} from 'src/app/controller/model/BalanceSheetStatus.model';
import {BalanceSheetStatusCriteria} from 'src/app/controller/criteria/BalanceSheetStatusCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-balance-sheet-status-list-admin',
  templateUrl: './balance-sheet-status-list-admin.component.html'
})
export class BalanceSheetStatusListAdminComponent extends AbstractListController<BalanceSheetStatusDto, BalanceSheetStatusCriteria, BalanceSheetStatusService>  implements OnInit {

    fileName = 'BalanceSheetStatus';

  
    constructor(balanceSheetStatusService: BalanceSheetStatusService) {
        super(balanceSheetStatusService);
        this.pdfName='BalanceSheetStatus.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadBalanceSheetStatuss(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('BalanceSheetStatus', 'list');
        isPermistted ? this.service.findAll().subscribe(balanceSheetStatuss => this.items = balanceSheetStatuss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
        ];
    }



	public initDuplicate(res: BalanceSheetStatusDto) {
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
