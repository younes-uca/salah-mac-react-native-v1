import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

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
  selector: 'app-payment-purchase-edit-admin',
  templateUrl: './payment-purchase-edit-admin.component.html'
})
export class PaymentPurchaseEditAdminComponent extends AbstractEditController<PaymentPurchaseDto, PaymentPurchaseCriteria, PaymentPurchaseService>   implements OnInit {






    constructor( private paymentPurchaseService: PaymentPurchaseService , private purchaseService: PurchaseService, private paymentModeService: PaymentModeService, private purchasePaymentStatusService: PurchasePaymentStatusService) {
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
    public prepareEdit() {
        this.item.paymentDate = this.paymentPurchaseService.format(this.item.paymentDate);
    }



    public setValidation(value : boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



   public async openCreatePurchase(purchase: string) {
        const isPermistted = await this.roleService.isPermitted('Purchase', 'edit');
        if(isPermistted) {
             this.purchase = new PurchaseDto();
             this.createPurchaseDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }
   public async openCreatePurchasePaymentStatus(purchasePaymentStatus: string) {
        const isPermistted = await this.roleService.isPermitted('PurchasePaymentStatus', 'edit');
        if(isPermistted) {
             this.purchasePaymentStatus = new PurchasePaymentStatusDto();
             this.createPurchasePaymentStatusDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get paymentMode(): PaymentModeDto {
       return this.paymentModeService.item;
   }
  set paymentMode(value: PaymentModeDto) {
        this.paymentModeService.item = value;
   }
   get paymentModes(): Array<PaymentModeDto> {
        return this.paymentModeService.items;
   }
   set paymentModes(value: Array<PaymentModeDto>) {
        this.paymentModeService.items = value;
   }
   get createPaymentModeDialog(): boolean {
       return this.paymentModeService.createDialog;
   }
  set createPaymentModeDialog(value: boolean) {
       this.paymentModeService.createDialog= value;
   }
   get purchase(): PurchaseDto {
       return this.purchaseService.item;
   }
  set purchase(value: PurchaseDto) {
        this.purchaseService.item = value;
   }
   get purchases(): Array<PurchaseDto> {
        return this.purchaseService.items;
   }
   set purchases(value: Array<PurchaseDto>) {
        this.purchaseService.items = value;
   }
   get createPurchaseDialog(): boolean {
       return this.purchaseService.createDialog;
   }
  set createPurchaseDialog(value: boolean) {
       this.purchaseService.createDialog= value;
   }
   get purchasePaymentStatus(): PurchasePaymentStatusDto {
       return this.purchasePaymentStatusService.item;
   }
  set purchasePaymentStatus(value: PurchasePaymentStatusDto) {
        this.purchasePaymentStatusService.item = value;
   }
   get purchasePaymentStatuss(): Array<PurchasePaymentStatusDto> {
        return this.purchasePaymentStatusService.items;
   }
   set purchasePaymentStatuss(value: Array<PurchasePaymentStatusDto>) {
        this.purchasePaymentStatusService.items = value;
   }
   get createPurchasePaymentStatusDialog(): boolean {
       return this.purchasePaymentStatusService.createDialog;
   }
  set createPurchasePaymentStatusDialog(value: boolean) {
       this.purchasePaymentStatusService.createDialog= value;
   }



}
