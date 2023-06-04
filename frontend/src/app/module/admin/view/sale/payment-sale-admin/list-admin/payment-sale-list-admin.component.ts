import {Component, OnInit} from '@angular/core';
import {PaymentSaleService} from 'src/app/controller/service/PaymentSale.service';
import {PaymentSaleDto} from 'src/app/controller/model/PaymentSale.model';
import {PaymentSaleCriteria} from 'src/app/controller/criteria/PaymentSaleCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { SaleService } from 'src/app/controller/service/Sale.service';
import { PaymentMethodService } from 'src/app/controller/service/PaymentMethod.service';
import { PaymentStatusService } from 'src/app/controller/service/PaymentStatus.service';

import {SaleDto} from 'src/app/controller/model/Sale.model';
import {PaymentStatusDto} from 'src/app/controller/model/PaymentStatus.model';
import {PaymentMethodDto} from 'src/app/controller/model/PaymentMethod.model';


@Component({
  selector: 'app-payment-sale-list-admin',
  templateUrl: './payment-sale-list-admin.component.html'
})
export class PaymentSaleListAdminComponent extends AbstractListController<PaymentSaleDto, PaymentSaleCriteria, PaymentSaleService>  implements OnInit {

    fileName = 'PaymentSale';

    sales :Array<SaleDto>;
    paymentMethods :Array<PaymentMethodDto>;
    paymentStatuss :Array<PaymentStatusDto>;
  
    constructor(paymentSaleService: PaymentSaleService, private saleService: SaleService, private paymentMethodService: PaymentMethodService, private paymentStatusService: PaymentStatusService) {
        super(paymentSaleService);
        this.pdfName='PaymentSale.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadSale();
      this.loadPaymentMethod();
      this.loadPaymentStatus();
    }

    public async loadPaymentSales(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaymentSale', 'list');
        isPermistted ? this.service.findAll().subscribe(paymentSales => this.items = paymentSales,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'paymentDate', header: 'Payment date'},
            {field: 'amount', header: 'Amount'},
            {field: 'sale?.reference', header: 'Sale'},
            {field: 'paymentMethod?.libelle', header: 'Payment method'},
            {field: 'paymentStatus?.libelle', header: 'Payment status'},
        ];
    }


    public async loadSale(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaymentSale', 'list');
        isPermistted ? this.saleService.findAllOptimized().subscribe(sales => this.sales = sales,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadPaymentMethod(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaymentSale', 'list');
        isPermistted ? this.paymentMethodService.findAllOptimized().subscribe(paymentMethods => this.paymentMethods = paymentMethods,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadPaymentStatus(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('PaymentSale', 'list');
        isPermistted ? this.paymentStatusService.findAllOptimized().subscribe(paymentStatuss => this.paymentStatuss = paymentStatuss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: PaymentSaleDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Payment date': this.datePipe.transform(e.paymentDate , 'dd/MM/yyyy hh:mm'),
                 'Amount': e.amount ,
                'Sale': e.sale?.reference ,
                'Payment method': e.paymentMethod?.libelle ,
                 'Description': e.description ,
                'Payment status': e.paymentStatus?.libelle ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Payment date Min': this.criteria.paymentDateFrom ? this.datePipe.transform(this.criteria.paymentDateFrom , this.dateFormat) : environment.emptyForExport ,
            'Payment date Max': this.criteria.paymentDateTo ? this.datePipe.transform(this.criteria.paymentDateTo , this.dateFormat) : environment.emptyForExport ,
            'Amount Min': this.criteria.amountMin ? this.criteria.amountMin : environment.emptyForExport ,
            'Amount Max': this.criteria.amountMax ? this.criteria.amountMax : environment.emptyForExport ,
        //'Sale': this.criteria.sale?.reference ? this.criteria.sale?.reference : environment.emptyForExport ,
        //'Payment method': this.criteria.paymentMethod?.libelle ? this.criteria.paymentMethod?.libelle : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        //'Payment status': this.criteria.paymentStatus?.libelle ? this.criteria.paymentStatus?.libelle : environment.emptyForExport ,
        }];
      }
}
