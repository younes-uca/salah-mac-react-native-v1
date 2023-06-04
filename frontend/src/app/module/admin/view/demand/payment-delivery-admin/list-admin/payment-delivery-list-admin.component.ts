import {Component, OnInit} from '@angular/core';
import {PaymentDeliveryService} from 'src/app/controller/service/PaymentDelivery.service';
import {PaymentDeliveryDto} from 'src/app/controller/model/PaymentDelivery.model';
import {PaymentDeliveryCriteria} from 'src/app/controller/criteria/PaymentDeliveryCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { DeliveryService } from 'src/app/controller/service/Delivery.service';
import { SaleService } from 'src/app/controller/service/Sale.service';
import { PaymentMethodService } from 'src/app/controller/service/PaymentMethod.service';
import { PaymentDeliveryStatusService } from 'src/app/controller/service/PaymentDeliveryStatus.service';

import {SaleDto} from 'src/app/controller/model/Sale.model';
import {PaymentMethodDto} from 'src/app/controller/model/PaymentMethod.model';
import {PaymentDeliveryStatusDto} from 'src/app/controller/model/PaymentDeliveryStatus.model';
import {DeliveryDto} from 'src/app/controller/model/Delivery.model';


@Component({
  selector: 'app-payment-delivery-list-admin',
  templateUrl: './payment-delivery-list-admin.component.html'
})
export class PaymentDeliveryListAdminComponent extends AbstractListController<PaymentDeliveryDto, PaymentDeliveryCriteria, PaymentDeliveryService>  implements OnInit {

    fileName = 'PaymentDelivery';

    deliverys :Array<DeliveryDto>;
    sales :Array<SaleDto>;
    paymentMethods :Array<PaymentMethodDto>;
    paymentDeliveryStatuss :Array<PaymentDeliveryStatusDto>;
  
    constructor(paymentDeliveryService: PaymentDeliveryService, private deliveryService: DeliveryService, private saleService: SaleService, private paymentMethodService: PaymentMethodService, private paymentDeliveryStatusService: PaymentDeliveryStatusService) {
        super(paymentDeliveryService);
        this.pdfName='PaymentDelivery.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadDelivery();
      this.loadSale();
      this.loadPaymentMethod();
      this.loadPaymentDeliveryStatus();
    }

    public async loadPaymentDeliverys(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaymentDelivery', 'list');
        isPermistted ? this.service.findAll().subscribe(paymentDeliverys => this.items = paymentDeliverys,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'deliveryDate', header: 'Delivery date'},
            {field: 'amount', header: 'Amount'},
            {field: 'delivery?.id', header: 'Delivery'},
            {field: 'sale?.reference', header: 'Sale'},
            {field: 'paymentMethod?.libelle', header: 'Payment method'},
            {field: 'paymentDeliveryStatus?.libelle', header: 'Payment delivery status'},
        ];
    }


    public async loadDelivery(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaymentDelivery', 'list');
        isPermistted ? this.deliveryService.findAll().subscribe(deliverys => this.deliverys = deliverys,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadSale(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaymentDelivery', 'list');
        isPermistted ? this.saleService.findAllOptimized().subscribe(sales => this.sales = sales,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadPaymentMethod(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaymentDelivery', 'list');
        isPermistted ? this.paymentMethodService.findAllOptimized().subscribe(paymentMethods => this.paymentMethods = paymentMethods,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadPaymentDeliveryStatus(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaymentDelivery', 'list');
        isPermistted ? this.paymentDeliveryStatusService.findAllOptimized().subscribe(paymentDeliveryStatuss => this.paymentDeliveryStatuss = paymentDeliveryStatuss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: PaymentDeliveryDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Delivery date': this.datePipe.transform(e.deliveryDate , 'dd/MM/yyyy hh:mm'),
                 'Amount': e.amount ,
                'Delivery': e.delivery?.id ,
                'Sale': e.sale?.reference ,
                'Payment method': e.paymentMethod?.libelle ,
                 'Description': e.description ,
                'Payment delivery status': e.paymentDeliveryStatus?.libelle ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Delivery date Min': this.criteria.deliveryDateFrom ? this.datePipe.transform(this.criteria.deliveryDateFrom , this.dateFormat) : environment.emptyForExport ,
            'Delivery date Max': this.criteria.deliveryDateTo ? this.datePipe.transform(this.criteria.deliveryDateTo , this.dateFormat) : environment.emptyForExport ,
            'Amount Min': this.criteria.amountMin ? this.criteria.amountMin : environment.emptyForExport ,
            'Amount Max': this.criteria.amountMax ? this.criteria.amountMax : environment.emptyForExport ,
        //'Delivery': this.criteria.delivery?.id ? this.criteria.delivery?.id : environment.emptyForExport ,
        //'Sale': this.criteria.sale?.reference ? this.criteria.sale?.reference : environment.emptyForExport ,
        //'Payment method': this.criteria.paymentMethod?.libelle ? this.criteria.paymentMethod?.libelle : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        //'Payment delivery status': this.criteria.paymentDeliveryStatus?.libelle ? this.criteria.paymentDeliveryStatus?.libelle : environment.emptyForExport ,
        }];
      }
}
