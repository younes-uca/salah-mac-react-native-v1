import {Component, OnInit} from '@angular/core';
import {CreditNotePurchaseStatusService} from 'src/app/controller/service/CreditNotePurchaseStatus.service';
import {CreditNotePurchaseStatusDto} from 'src/app/controller/model/CreditNotePurchaseStatus.model';
import {CreditNotePurchaseStatusCriteria} from 'src/app/controller/criteria/CreditNotePurchaseStatusCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-credit-note-purchase-status-list-admin',
  templateUrl: './credit-note-purchase-status-list-admin.component.html'
})
export class CreditNotePurchaseStatusListAdminComponent extends AbstractListController<CreditNotePurchaseStatusDto, CreditNotePurchaseStatusCriteria, CreditNotePurchaseStatusService>  implements OnInit {

    fileName = 'CreditNotePurchaseStatus';

  
    constructor(creditNotePurchaseStatusService: CreditNotePurchaseStatusService) {
        super(creditNotePurchaseStatusService);
        this.pdfName='CreditNotePurchaseStatus.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadCreditNotePurchaseStatuss(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('CreditNotePurchaseStatus', 'list');
        isPermistted ? this.service.findAll().subscribe(creditNotePurchaseStatuss => this.items = creditNotePurchaseStatuss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'style', header: 'Style'},
        ];
    }



	public initDuplicate(res: CreditNotePurchaseStatusDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Libelle': e.libelle ,
                 'Code': e.code ,
                 'Style': e.style ,
            }
        });

        this.criteriaData = [{
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Style': this.criteria.style ? this.criteria.style : environment.emptyForExport ,
        }];
      }
}
