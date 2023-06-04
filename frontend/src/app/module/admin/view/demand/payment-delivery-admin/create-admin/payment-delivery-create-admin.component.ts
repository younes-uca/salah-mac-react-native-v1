import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {PaymentDeliveryService} from 'src/app/controller/service/PaymentDelivery.service';
import {PaymentDeliveryDto} from 'src/app/controller/model/PaymentDelivery.model';
import {PaymentDeliveryCriteria} from 'src/app/controller/criteria/PaymentDeliveryCriteria.model';
import {SaleDto} from 'src/app/controller/model/Sale.model';
import {SaleService} from 'src/app/controller/service/Sale.service';
import {PaymentMethodDto} from 'src/app/controller/model/PaymentMethod.model';
import {PaymentMethodService} from 'src/app/controller/service/PaymentMethod.service';
import {DeliveryDto} from 'src/app/controller/model/Delivery.model';
import {DeliveryService} from 'src/app/controller/service/Delivery.service';
import {PaymentDeliveryStatusDto} from 'src/app/controller/model/PaymentDeliveryStatus.model';
import {PaymentDeliveryStatusService} from 'src/app/controller/service/PaymentDeliveryStatus.service';
@Component({
  selector: 'app-payment-delivery-create-admin',
  templateUrl: './payment-delivery-create-admin.component.html'
})
export class PaymentDeliveryCreateAdminComponent extends AbstractCreateController<PaymentDeliveryDto, PaymentDeliveryCriteria, PaymentDeliveryService>  implements OnInit {




    constructor( private paymentDeliveryService: PaymentDeliveryService , private saleService: SaleService, private paymentMethodService: PaymentMethodService, private deliveryService: DeliveryService, private paymentDeliveryStatusService: PaymentDeliveryStatusService) {
        super(paymentDeliveryService);
    }

    ngOnInit(): void {
    this.delivery = new DeliveryDto();
    this.deliveryService.findAll().subscribe((data) => this.deliverys = data);
    this.sale = new SaleDto();
    this.saleService.findAll().subscribe((data) => this.sales = data);
    this.paymentMethod = new PaymentMethodDto();
    this.paymentMethodService.findAll().subscribe((data) => this.paymentMethods = data);
    this.paymentDeliveryStatus = new PaymentDeliveryStatusDto();
    this.paymentDeliveryStatusService.findAll().subscribe((data) => this.paymentDeliveryStatuss = data);
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



    public async openCreatePaymentDeliveryStatus(paymentDeliveryStatus: string) {
    const isPermistted = await this.roleService.isPermitted('PaymentDeliveryStatus', 'add');
    if(isPermistted) {
         this.paymentDeliveryStatus = new PaymentDeliveryStatusDto();
         this.createPaymentDeliveryStatusDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }
    public async openCreateDelivery(delivery: string) {
    const isPermistted = await this.roleService.isPermitted('Delivery', 'add');
    if(isPermistted) {
         this.delivery = new DeliveryDto();
         this.createDeliveryDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }

    get paymentDeliveryStatus(): PaymentDeliveryStatusDto {
        return this.paymentDeliveryStatusService.item;
    }
    set paymentDeliveryStatus(value: PaymentDeliveryStatusDto) {
        this.paymentDeliveryStatusService.item = value;
    }
    get paymentDeliveryStatuss(): Array<PaymentDeliveryStatusDto> {
        return this.paymentDeliveryStatusService.items;
    }
    set paymentDeliveryStatuss(value: Array<PaymentDeliveryStatusDto>) {
        this.paymentDeliveryStatusService.items = value;
    }
    get createPaymentDeliveryStatusDialog(): boolean {
       return this.paymentDeliveryStatusService.createDialog;
    }
    set createPaymentDeliveryStatusDialog(value: boolean) {
        this.paymentDeliveryStatusService.createDialog= value;
    }
    get sale(): SaleDto {
        return this.saleService.item;
    }
    set sale(value: SaleDto) {
        this.saleService.item = value;
    }
    get sales(): Array<SaleDto> {
        return this.saleService.items;
    }
    set sales(value: Array<SaleDto>) {
        this.saleService.items = value;
    }
    get createSaleDialog(): boolean {
       return this.saleService.createDialog;
    }
    set createSaleDialog(value: boolean) {
        this.saleService.createDialog= value;
    }
    get paymentMethod(): PaymentMethodDto {
        return this.paymentMethodService.item;
    }
    set paymentMethod(value: PaymentMethodDto) {
        this.paymentMethodService.item = value;
    }
    get paymentMethods(): Array<PaymentMethodDto> {
        return this.paymentMethodService.items;
    }
    set paymentMethods(value: Array<PaymentMethodDto>) {
        this.paymentMethodService.items = value;
    }
    get createPaymentMethodDialog(): boolean {
       return this.paymentMethodService.createDialog;
    }
    set createPaymentMethodDialog(value: boolean) {
        this.paymentMethodService.createDialog= value;
    }
    get delivery(): DeliveryDto {
        return this.deliveryService.item;
    }
    set delivery(value: DeliveryDto) {
        this.deliveryService.item = value;
    }
    get deliverys(): Array<DeliveryDto> {
        return this.deliveryService.items;
    }
    set deliverys(value: Array<DeliveryDto>) {
        this.deliveryService.items = value;
    }
    get createDeliveryDialog(): boolean {
       return this.deliveryService.createDialog;
    }
    set createDeliveryDialog(value: boolean) {
        this.deliveryService.createDialog= value;
    }






}
