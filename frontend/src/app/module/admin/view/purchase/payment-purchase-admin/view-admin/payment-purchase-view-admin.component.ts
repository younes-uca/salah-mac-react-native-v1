import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {PaymentPurchaseService} from 'src/app/controller/service/PaymentPurchase.service';
import {PaymentPurchaseDto} from 'src/app/controller/model/PaymentPurchase.model';
import {PaymentPurchaseCriteria} from 'src/app/controller/criteria/PaymentPurchaseCriteria.model';

import {PurchaseDto} from 'src/app/controller/model/Purchase.model';
import {PurchaseService} from 'src/app/controller/service/Purchase.service';
import {PaymentModeDto} from 'src/app/controller/model/PaymentMode.model';
import {PaymentModeService} from 'src/app/controller/service/PaymentMode.service';
import {PurchasePaymentStatusDto} from 'src/app/controller/model/PurchasePaymentStatus.model';
import {PurchasePaymentStatusService} from 'src/app/controller/service/PurchasePaymentStatus.service';
@Component({
  selector: 'app-payment-purchase-view-admin',
  templateUrl: './payment-purchase-view-admin.component.html'
})
export class PaymentPurchaseViewAdminComponent extends AbstractViewController<PaymentPurchaseDto, PaymentPurchaseCriteria, PaymentPurchaseService> implements OnInit {


    constructor(private paymentPurchaseService: PaymentPurchaseService, private purchaseService: PurchaseService, private paymentModeService: PaymentModeService, private purchasePaymentStatusService: PurchasePaymentStatusService){
        super(paymentPurchaseService);
    }

    ngOnInit(): void {
        this.purchase = new PurchaseDto();
        this.purchaseService.findAll().subscribe((data) => this.purchases = data);
        this.paymentMode = new PaymentModeDto();
        this.paymentModeService.findAll().subscribe((data) => this.paymentModes = data);
        this.purchasePaymentStatus = new PurchasePaymentStatusDto();
        this.purchasePaymentStatusService.findAll().subscribe((data) => this.purchasePaymentStatuss = data);
    }


    get paymentMode(): PaymentModeDto {
       return this.paymentModeService.item;
    }
    set paymentMode(value: PaymentModeDto) {
        this.paymentModeService.item = value;
    }
    get paymentModes():Array<PaymentModeDto> {
       return this.paymentModeService.items;
    }
    set paymentModes(value: Array<PaymentModeDto>) {
        this.paymentModeService.items = value;
    }
    get purchase(): PurchaseDto {
       return this.purchaseService.item;
    }
    set purchase(value: PurchaseDto) {
        this.purchaseService.item = value;
    }
    get purchases():Array<PurchaseDto> {
       return this.purchaseService.items;
    }
    set purchases(value: Array<PurchaseDto>) {
        this.purchaseService.items = value;
    }
    get purchasePaymentStatus(): PurchasePaymentStatusDto {
       return this.purchasePaymentStatusService.item;
    }
    set purchasePaymentStatus(value: PurchasePaymentStatusDto) {
        this.purchasePaymentStatusService.item = value;
    }
    get purchasePaymentStatuss():Array<PurchasePaymentStatusDto> {
       return this.purchasePaymentStatusService.items;
    }
    set purchasePaymentStatuss(value: Array<PurchasePaymentStatusDto>) {
        this.purchasePaymentStatusService.items = value;
    }


}
