import {Component, OnInit} from '@angular/core';
import {PaymentModeService} from 'src/app/controller/service/PaymentMode.service';
import {PaymentModeDto} from 'src/app/controller/model/PaymentMode.model';
import {PaymentModeCriteria} from 'src/app/controller/criteria/PaymentModeCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-payment-mode-list-admin',
  templateUrl: './payment-mode-list-admin.component.html'
})
export class PaymentModeListAdminComponent extends AbstractListController<PaymentModeDto, PaymentModeCriteria, PaymentModeService>  implements OnInit {

    fileName = 'PaymentMode';

  
    constructor(paymentModeService: PaymentModeService) {
        super(paymentModeService);
        this.pdfName='PaymentMode.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadPaymentModes(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaymentMode', 'list');
        isPermistted ? this.service.findAll().subscribe(paymentModes => this.items = paymentModes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'style', header: 'Style'},
        ];
    }



	public initDuplicate(res: PaymentModeDto) {
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
