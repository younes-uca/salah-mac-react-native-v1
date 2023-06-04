import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {CreditNotePurchaseService} from 'src/app/controller/service/CreditNotePurchase.service';
import {CreditNotePurchaseDto} from 'src/app/controller/model/CreditNotePurchase.model';
import {CreditNotePurchaseCriteria} from 'src/app/controller/criteria/CreditNotePurchaseCriteria.model';
import {CreditNotePurchaseStatusDto} from 'src/app/controller/model/CreditNotePurchaseStatus.model';
import {CreditNotePurchaseStatusService} from 'src/app/controller/service/CreditNotePurchaseStatus.service';
import {PurchaseDto} from 'src/app/controller/model/Purchase.model';
import {PurchaseService} from 'src/app/controller/service/Purchase.service';
import {CreditNotePurchaseItemDto} from 'src/app/controller/model/CreditNotePurchaseItem.model';
import {CreditNotePurchaseItemService} from 'src/app/controller/service/CreditNotePurchaseItem.service';
import {ProductDto} from 'src/app/controller/model/Product.model';
import {ProductService} from 'src/app/controller/service/Product.service';
@Component({
  selector: 'app-credit-note-purchase-create-admin',
  templateUrl: './credit-note-purchase-create-admin.component.html'
})
export class CreditNotePurchaseCreateAdminComponent extends AbstractCreateController<CreditNotePurchaseDto, CreditNotePurchaseCriteria, CreditNotePurchaseService>  implements OnInit {

    private _creditNotePurchaseItemsElement = new CreditNotePurchaseItemDto();



    constructor( private creditNotePurchaseService: CreditNotePurchaseService , private creditNotePurchaseStatusService: CreditNotePurchaseStatusService, private purchaseService: PurchaseService, private creditNotePurchaseItemService: CreditNotePurchaseItemService, private productService: ProductService) {
        super(creditNotePurchaseService);
    }

    ngOnInit(): void {
        this.creditNotePurchaseItemsElement.product = new ProductDto();
        this.productService.findAll().subscribe((data) => this.products = data);
    this.purchase = new PurchaseDto();
    this.purchaseService.findAll().subscribe((data) => this.purchases = data);
    this.creditNotePurchaseStatus = new CreditNotePurchaseStatusDto();
    this.creditNotePurchaseStatusService.findAll().subscribe((data) => this.creditNotePurchaseStatuss = data);
}



    validateCreditNotePurchaseItems(){
        this.errorMessages = new Array();
    }


    public setValidation(value: boolean){
    }

    public addCreditNotePurchaseItems() {
        if( this.item.creditNotePurchaseItems == null )
            this.item.creditNotePurchaseItems = new Array<CreditNotePurchaseItemDto>();
       this.validateCreditNotePurchaseItems();
       if (this.errorMessages.length === 0) {
              this.item.creditNotePurchaseItems.push({... this.creditNotePurchaseItemsElement});
              this.creditNotePurchaseItemsElement = new CreditNotePurchaseItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deleteCreditNotePurchaseItem(p: CreditNotePurchaseItemDto) {
        this.item.creditNotePurchaseItems.forEach((element, index) => {
            if (element === p) { this.item.creditNotePurchaseItems.splice(index, 1); }
        });
    }

    public editCreditNotePurchaseItem(p: CreditNotePurchaseItemDto) {
        this.creditNotePurchaseItemsElement = {... p};
        this.activeTab = 0;
    }


    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



    public async openCreateCreditNotePurchaseStatus(creditNotePurchaseStatus: string) {
    const isPermistted = await this.roleService.isPermitted('CreditNotePurchaseStatus', 'add');
    if(isPermistted) {
         this.creditNotePurchaseStatus = new CreditNotePurchaseStatusDto();
         this.createCreditNotePurchaseStatusDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }
    public async openCreatePurchase(purchase: string) {
    const isPermistted = await this.roleService.isPermitted('Purchase', 'add');
    if(isPermistted) {
         this.purchase = new PurchaseDto();
         this.createPurchaseDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }

    get product(): ProductDto {
        return this.productService.item;
    }
    set product(value: ProductDto) {
        this.productService.item = value;
    }
    get products(): Array<ProductDto> {
        return this.productService.items;
    }
    set products(value: Array<ProductDto>) {
        this.productService.items = value;
    }
    get createProductDialog(): boolean {
       return this.productService.createDialog;
    }
    set createProductDialog(value: boolean) {
        this.productService.createDialog= value;
    }
    get creditNotePurchaseStatus(): CreditNotePurchaseStatusDto {
        return this.creditNotePurchaseStatusService.item;
    }
    set creditNotePurchaseStatus(value: CreditNotePurchaseStatusDto) {
        this.creditNotePurchaseStatusService.item = value;
    }
    get creditNotePurchaseStatuss(): Array<CreditNotePurchaseStatusDto> {
        return this.creditNotePurchaseStatusService.items;
    }
    set creditNotePurchaseStatuss(value: Array<CreditNotePurchaseStatusDto>) {
        this.creditNotePurchaseStatusService.items = value;
    }
    get createCreditNotePurchaseStatusDialog(): boolean {
       return this.creditNotePurchaseStatusService.createDialog;
    }
    set createCreditNotePurchaseStatusDialog(value: boolean) {
        this.creditNotePurchaseStatusService.createDialog= value;
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





    get creditNotePurchaseItemsElement(): CreditNotePurchaseItemDto {
        if( this._creditNotePurchaseItemsElement == null )
            this._creditNotePurchaseItemsElement = new CreditNotePurchaseItemDto();
        return this._creditNotePurchaseItemsElement;
    }

    set creditNotePurchaseItemsElement(value: CreditNotePurchaseItemDto) {
        this._creditNotePurchaseItemsElement = value;
    }

}
