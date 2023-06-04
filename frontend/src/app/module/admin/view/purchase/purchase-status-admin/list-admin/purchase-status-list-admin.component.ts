import {Component, OnInit} from '@angular/core';
import {PurchaseStatusService} from 'src/app/controller/service/PurchaseStatus.service';
import {PurchaseStatusDto} from 'src/app/controller/model/PurchaseStatus.model';
import {PurchaseStatusCriteria} from 'src/app/controller/criteria/PurchaseStatusCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-purchase-status-list-admin',
  templateUrl: './purchase-status-list-admin.component.html'
})
export class PurchaseStatusListAdminComponent extends AbstractListController<PurchaseStatusDto, PurchaseStatusCriteria, PurchaseStatusService>  implements OnInit {

    fileName = 'PurchaseStatus';

  
    constructor(purchaseStatusService: PurchaseStatusService) {
        super(purchaseStatusService);
        this.pdfName='PurchaseStatus.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadPurchaseStatuss(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PurchaseStatus', 'list');
        isPermistted ? this.service.findAll().subscribe(purchaseStatuss => this.items = purchaseStatuss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'style', header: 'Style'},
        ];
    }



	public initDuplicate(res: PurchaseStatusDto) {
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
