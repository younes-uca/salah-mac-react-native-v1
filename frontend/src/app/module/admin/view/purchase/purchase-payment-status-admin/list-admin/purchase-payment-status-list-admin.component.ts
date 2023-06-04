import {Component, OnInit} from '@angular/core';
import {PurchasePaymentStatusService} from 'src/app/controller/service/PurchasePaymentStatus.service';
import {PurchasePaymentStatusDto} from 'src/app/controller/model/PurchasePaymentStatus.model';
import {PurchasePaymentStatusCriteria} from 'src/app/controller/criteria/PurchasePaymentStatusCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-purchase-payment-status-list-admin',
  templateUrl: './purchase-payment-status-list-admin.component.html'
})
export class PurchasePaymentStatusListAdminComponent extends AbstractListController<PurchasePaymentStatusDto, PurchasePaymentStatusCriteria, PurchasePaymentStatusService>  implements OnInit {

    fileName = 'PurchasePaymentStatus';

  
    constructor(purchasePaymentStatusService: PurchasePaymentStatusService) {
        super(purchasePaymentStatusService);
        this.pdfName='PurchasePaymentStatus.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadPurchasePaymentStatuss(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PurchasePaymentStatus', 'list');
        isPermistted ? this.service.findAll().subscribe(purchasePaymentStatuss => this.items = purchasePaymentStatuss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'style', header: 'Style'},
        ];
    }



	public initDuplicate(res: PurchasePaymentStatusDto) {
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
