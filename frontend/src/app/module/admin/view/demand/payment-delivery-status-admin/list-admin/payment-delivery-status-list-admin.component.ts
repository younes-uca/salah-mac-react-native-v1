import {Component, OnInit} from '@angular/core';
import {PaymentDeliveryStatusService} from 'src/app/controller/service/PaymentDeliveryStatus.service';
import {PaymentDeliveryStatusDto} from 'src/app/controller/model/PaymentDeliveryStatus.model';
import {PaymentDeliveryStatusCriteria} from 'src/app/controller/criteria/PaymentDeliveryStatusCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-payment-delivery-status-list-admin',
  templateUrl: './payment-delivery-status-list-admin.component.html'
})
export class PaymentDeliveryStatusListAdminComponent extends AbstractListController<PaymentDeliveryStatusDto, PaymentDeliveryStatusCriteria, PaymentDeliveryStatusService>  implements OnInit {

    fileName = 'PaymentDeliveryStatus';

  
    constructor(paymentDeliveryStatusService: PaymentDeliveryStatusService) {
        super(paymentDeliveryStatusService);
        this.pdfName='PaymentDeliveryStatus.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadPaymentDeliveryStatuss(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaymentDeliveryStatus', 'list');
        isPermistted ? this.service.findAll().subscribe(paymentDeliveryStatuss => this.items = paymentDeliveryStatuss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'style', header: 'Style'},
        ];
    }



	public initDuplicate(res: PaymentDeliveryStatusDto) {
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
