import {Component, OnInit} from '@angular/core';
import {PaymentMethodService} from 'src/app/controller/service/PaymentMethod.service';
import {PaymentMethodDto} from 'src/app/controller/model/PaymentMethod.model';
import {PaymentMethodCriteria} from 'src/app/controller/criteria/PaymentMethodCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-payment-method-list-admin',
  templateUrl: './payment-method-list-admin.component.html'
})
export class PaymentMethodListAdminComponent extends AbstractListController<PaymentMethodDto, PaymentMethodCriteria, PaymentMethodService>  implements OnInit {

    fileName = 'PaymentMethod';

  
    constructor(paymentMethodService: PaymentMethodService) {
        super(paymentMethodService);
        this.pdfName='PaymentMethod.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadPaymentMethods(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaymentMethod', 'list');
        isPermistted ? this.service.findAll().subscribe(paymentMethods => this.items = paymentMethods,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'style', header: 'Style'},
        ];
    }



	public initDuplicate(res: PaymentMethodDto) {
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
