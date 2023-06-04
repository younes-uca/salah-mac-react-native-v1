import {Component, OnInit} from '@angular/core';
import {PaymentStatusService} from 'src/app/controller/service/PaymentStatus.service';
import {PaymentStatusDto} from 'src/app/controller/model/PaymentStatus.model';
import {PaymentStatusCriteria} from 'src/app/controller/criteria/PaymentStatusCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-payment-status-list-admin',
  templateUrl: './payment-status-list-admin.component.html'
})
export class PaymentStatusListAdminComponent extends AbstractListController<PaymentStatusDto, PaymentStatusCriteria, PaymentStatusService>  implements OnInit {

    fileName = 'PaymentStatus';

  
    constructor(paymentStatusService: PaymentStatusService) {
        super(paymentStatusService);
        this.pdfName='PaymentStatus.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadPaymentStatuss(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaymentStatus', 'list');
        isPermistted ? this.service.findAll().subscribe(paymentStatuss => this.items = paymentStatuss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'style', header: 'Style'},
        ];
    }



	public initDuplicate(res: PaymentStatusDto) {
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
