import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {PaymentSaleService} from 'src/app/controller/service/PaymentSale.service';
import {PaymentSaleDto} from 'src/app/controller/model/PaymentSale.model';
import {PaymentSaleCriteria} from 'src/app/controller/criteria/PaymentSaleCriteria.model';

import {SaleDto} from 'src/app/controller/model/Sale.model';
import {SaleService} from 'src/app/controller/service/Sale.service';
import {PaymentMethodDto} from 'src/app/controller/model/PaymentMethod.model';
import {PaymentMethodService} from 'src/app/controller/service/PaymentMethod.service';
import {PaymentStatusDto} from 'src/app/controller/model/PaymentStatus.model';
import {PaymentStatusService} from 'src/app/controller/service/PaymentStatus.service';
@Component({
  selector: 'app-payment-sale-view-admin',
  templateUrl: './payment-sale-view-admin.component.html'
})
export class PaymentSaleViewAdminComponent extends AbstractViewController<PaymentSaleDto, PaymentSaleCriteria, PaymentSaleService> implements OnInit {


    constructor(private paymentSaleService: PaymentSaleService, private saleService: SaleService, private paymentMethodService: PaymentMethodService, private paymentStatusService: PaymentStatusService){
        super(paymentSaleService);
    }

    ngOnInit(): void {
        this.sale = new SaleDto();
        this.saleService.findAll().subscribe((data) => this.sales = data);
        this.paymentMethod = new PaymentMethodDto();
        this.paymentMethodService.findAll().subscribe((data) => this.paymentMethods = data);
        this.paymentStatus = new PaymentStatusDto();
        this.paymentStatusService.findAll().subscribe((data) => this.paymentStatuss = data);
    }


    get sale(): SaleDto {
       return this.saleService.item;
    }
    set sale(value: SaleDto) {
        this.saleService.item = value;
    }
    get sales():Array<SaleDto> {
       return this.saleService.items;
    }
    set sales(value: Array<SaleDto>) {
        this.saleService.items = value;
    }
    get paymentMethod(): PaymentMethodDto {
       return this.paymentMethodService.item;
    }
    set paymentMethod(value: PaymentMethodDto) {
        this.paymentMethodService.item = value;
    }
    get paymentMethods():Array<PaymentMethodDto> {
       return this.paymentMethodService.items;
    }
    set paymentMethods(value: Array<PaymentMethodDto>) {
        this.paymentMethodService.items = value;
    }
    get paymentStatus(): PaymentStatusDto {
       return this.paymentStatusService.item;
    }
    set paymentStatus(value: PaymentStatusDto) {
        this.paymentStatusService.item = value;
    }
    get paymentStatuss():Array<PaymentStatusDto> {
       return this.paymentStatusService.items;
    }
    set paymentStatuss(value: Array<PaymentStatusDto>) {
        this.paymentStatusService.items = value;
    }


}
