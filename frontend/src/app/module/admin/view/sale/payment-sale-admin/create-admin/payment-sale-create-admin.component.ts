import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

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
  selector: 'app-payment-sale-create-admin',
  templateUrl: './payment-sale-create-admin.component.html'
})
export class PaymentSaleCreateAdminComponent extends AbstractCreateController<PaymentSaleDto, PaymentSaleCriteria, PaymentSaleService>  implements OnInit {




    constructor( private paymentSaleService: PaymentSaleService , private saleService: SaleService, private paymentMethodService: PaymentMethodService, private paymentStatusService: PaymentStatusService) {
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





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



    public async openCreateSale(sale: string) {
    const isPermistted = await this.roleService.isPermitted('Sale', 'add');
    if(isPermistted) {
         this.sale = new SaleDto();
         this.createSaleDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }
    public async openCreatePaymentStatus(paymentStatus: string) {
    const isPermistted = await this.roleService.isPermitted('PaymentStatus', 'add');
    if(isPermistted) {
         this.paymentStatus = new PaymentStatusDto();
         this.createPaymentStatusDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
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
    get paymentStatus(): PaymentStatusDto {
        return this.paymentStatusService.item;
    }
    set paymentStatus(value: PaymentStatusDto) {
        this.paymentStatusService.item = value;
    }
    get paymentStatuss(): Array<PaymentStatusDto> {
        return this.paymentStatusService.items;
    }
    set paymentStatuss(value: Array<PaymentStatusDto>) {
        this.paymentStatusService.items = value;
    }
    get createPaymentStatusDialog(): boolean {
       return this.paymentStatusService.createDialog;
    }
    set createPaymentStatusDialog(value: boolean) {
        this.paymentStatusService.createDialog= value;
    }






}
