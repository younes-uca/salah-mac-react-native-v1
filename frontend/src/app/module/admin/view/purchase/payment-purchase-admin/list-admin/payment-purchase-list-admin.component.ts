import {Component, OnInit} from '@angular/core';
import {PaymentPurchaseService} from 'src/app/controller/service/PaymentPurchase.service';
import {PaymentPurchaseDto} from 'src/app/controller/model/PaymentPurchase.model';
import {PaymentPurchaseCriteria} from 'src/app/controller/criteria/PaymentPurchaseCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { PurchaseService } from 'src/app/controller/service/Purchase.service';
import { PaymentModeService } from 'src/app/controller/service/PaymentMode.service';
import { PurchasePaymentStatusService } from 'src/app/controller/service/PurchasePaymentStatus.service';

import {PurchaseDto} from 'src/app/controller/model/Purchase.model';
import {PurchasePaymentStatusDto} from 'src/app/controller/model/PurchasePaymentStatus.model';
import {PaymentModeDto} from 'src/app/controller/model/PaymentMode.model';


@Component({
  selector: 'app-payment-purchase-list-admin',
  templateUrl: './payment-purchase-list-admin.component.html'
})
export class PaymentPurchaseListAdminComponent extends AbstractListController<PaymentPurchaseDto, PaymentPurchaseCriteria, PaymentPurchaseService>  implements OnInit {

    fileName = 'PaymentPurchase';

    purchases :Array<PurchaseDto>;
    paymentModes :Array<PaymentModeDto>;
    purchasePaymentStatuss :Array<PurchasePaymentStatusDto>;
  
    constructor(paymentPurchaseService: PaymentPurchaseService, private purchaseService: PurchaseService, private paymentModeService: PaymentModeService, private purchasePaymentStatusService: PurchasePaymentStatusService) {
        super(paymentPurchaseService);
        this.pdfName='PaymentPurchase.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadPurchase();
      this.loadPaymentMode();
      this.loadPurchasePaymentStatus();
    }

    public async loadPaymentPurchases(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaymentPurchase', 'list');
        isPermistted ? this.service.findAll().subscribe(paymentPurchases => this.items = paymentPurchases,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'paymentDate', header: 'Payment date'},
            {field: 'amount', header: 'Amount'},
            {field: 'purchase?.reference', header: 'Purchase'},
            {field: 'paymentMode?.libelle', header: 'Payment mode'},
            {field: 'purchasePaymentStatus?.libelle', header: 'Purchase payment status'},
        ];
    }


    public async loadPurchase(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaymentPurchase', 'list');
        isPermistted ? this.purchaseService.findAllOptimized().subscribe(purchases => this.purchases = purchases,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadPaymentMode(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaymentPurchase', 'list');
        isPermistted ? this.paymentModeService.findAllOptimized().subscribe(paymentModes => this.paymentModes = paymentModes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadPurchasePaymentStatus(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaymentPurchase', 'list');
        isPermistted ? this.purchasePaymentStatusService.findAllOptimized().subscribe(purchasePaymentStatuss => this.purchasePaymentStatuss = purchasePaymentStatuss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: PaymentPurchaseDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Payment date': this.datePipe.transform(e.paymentDate , 'dd/MM/yyyy hh:mm'),
                 'Amount': e.amount ,
                'Purchase': e.purchase?.reference ,
                'Payment mode': e.paymentMode?.libelle ,
                 'Description': e.description ,
                'Purchase payment status': e.purchasePaymentStatus?.libelle ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Payment date Min': this.criteria.paymentDateFrom ? this.datePipe.transform(this.criteria.paymentDateFrom , this.dateFormat) : environment.emptyForExport ,
            'Payment date Max': this.criteria.paymentDateTo ? this.datePipe.transform(this.criteria.paymentDateTo , this.dateFormat) : environment.emptyForExport ,
            'Amount Min': this.criteria.amountMin ? this.criteria.amountMin : environment.emptyForExport ,
            'Amount Max': this.criteria.amountMax ? this.criteria.amountMax : environment.emptyForExport ,
        //'Purchase': this.criteria.purchase?.reference ? this.criteria.purchase?.reference : environment.emptyForExport ,
        //'Payment mode': this.criteria.paymentMode?.libelle ? this.criteria.paymentMode?.libelle : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        //'Purchase payment status': this.criteria.purchasePaymentStatus?.libelle ? this.criteria.purchasePaymentStatus?.libelle : environment.emptyForExport ,
        }];
      }
}
