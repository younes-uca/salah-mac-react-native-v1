import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {PurchaseService} from 'src/app/controller/service/Purchase.service';
import {PurchaseDto} from 'src/app/controller/model/Purchase.model';
import {PurchaseCriteria} from 'src/app/controller/criteria/PurchaseCriteria.model';


import {StoreDto} from 'src/app/controller/model/Store.model';
import {StoreService} from 'src/app/controller/service/Store.service';
import {SupplierDto} from 'src/app/controller/model/Supplier.model';
import {SupplierService} from 'src/app/controller/service/Supplier.service';
import {PurchaseItemDto} from 'src/app/controller/model/PurchaseItem.model';
import {PurchaseItemService} from 'src/app/controller/service/PurchaseItem.service';
import {ProductDto} from 'src/app/controller/model/Product.model';
import {ProductService} from 'src/app/controller/service/Product.service';
import {PurchaseStatusDto} from 'src/app/controller/model/PurchaseStatus.model';
import {PurchaseStatusService} from 'src/app/controller/service/PurchaseStatus.service';

@Component({
  selector: 'app-purchase-edit-admin',
  templateUrl: './purchase-edit-admin.component.html'
})
export class PurchaseEditAdminComponent extends AbstractEditController<PurchaseDto, PurchaseCriteria, PurchaseService>   implements OnInit {

    private _purchaseItemsElement = new PurchaseItemDto();





    constructor( private purchaseService: PurchaseService , private storeService: StoreService, private supplierService: SupplierService, private purchaseItemService: PurchaseItemService, private productService: ProductService, private purchaseStatusService: PurchaseStatusService) {
        super(purchaseService);
    }

    ngOnInit(): void {
        this.purchaseItemsElement.product = new ProductDto();
        this.productService.findAll().subscribe((data) => this.products = data);

    this.supplier = new SupplierDto();
    this.supplierService.findAll().subscribe((data) => this.suppliers = data);
    this.store = new StoreDto();
    this.storeService.findAll().subscribe((data) => this.stores = data);
    this.purchaseStatus = new PurchaseStatusDto();
    this.purchaseStatusService.findAll().subscribe((data) => this.purchaseStatuss = data);
}
    public prepareEdit() {
        this.item.purchaseDate = this.purchaseService.format(this.item.purchaseDate);
    }



    public validatePurchaseItems(){
        this.errorMessages = new Array();
    }
    public setValidation(value : boolean){
        }
   public addPurchaseItems() {
        if( this.item.purchaseItems == null )
            this.item.purchaseItems = new Array<PurchaseItemDto>();
       this.validatePurchaseItems();
       if (this.errorMessages.length === 0) {
            if(this.purchaseItemsElement.id == null){
                this.item.purchaseItems.push(this.purchaseItemsElement);
            }else{
                const index = this.item.purchaseItems.findIndex(e => e.id == this.purchaseItemsElement.id);
                this.item.purchaseItems[index] = this.purchaseItemsElement;
            }
          this.purchaseItemsElement = new PurchaseItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deletePurchaseItem(p: PurchaseItemDto) {
        this.item.purchaseItems.forEach((element, index) => {
            if (element === p) { this.item.purchaseItems.splice(index, 1); }
        });
    }

    public editPurchaseItem(p: PurchaseItemDto) {
        this.purchaseItemsElement = {... p};
        this.activeTab = 0;
    }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



   public async openCreatePurchaseStatus(purchaseStatus: string) {
        const isPermistted = await this.roleService.isPermitted('PurchaseStatus', 'edit');
        if(isPermistted) {
             this.purchaseStatus = new PurchaseStatusDto();
             this.createPurchaseStatusDialog = true;
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
   get supplier(): SupplierDto {
       return this.supplierService.item;
   }
  set supplier(value: SupplierDto) {
        this.supplierService.item = value;
   }
   get suppliers(): Array<SupplierDto> {
        return this.supplierService.items;
   }
   set suppliers(value: Array<SupplierDto>) {
        this.supplierService.items = value;
   }
   get createSupplierDialog(): boolean {
       return this.supplierService.createDialog;
   }
  set createSupplierDialog(value: boolean) {
       this.supplierService.createDialog= value;
   }
   get store(): StoreDto {
       return this.storeService.item;
   }
  set store(value: StoreDto) {
        this.storeService.item = value;
   }
   get stores(): Array<StoreDto> {
        return this.storeService.items;
   }
   set stores(value: Array<StoreDto>) {
        this.storeService.items = value;
   }
   get createStoreDialog(): boolean {
       return this.storeService.createDialog;
   }
  set createStoreDialog(value: boolean) {
       this.storeService.createDialog= value;
   }
   get purchaseStatus(): PurchaseStatusDto {
       return this.purchaseStatusService.item;
   }
  set purchaseStatus(value: PurchaseStatusDto) {
        this.purchaseStatusService.item = value;
   }
   get purchaseStatuss(): Array<PurchaseStatusDto> {
        return this.purchaseStatusService.items;
   }
   set purchaseStatuss(value: Array<PurchaseStatusDto>) {
        this.purchaseStatusService.items = value;
   }
   get createPurchaseStatusDialog(): boolean {
       return this.purchaseStatusService.createDialog;
   }
  set createPurchaseStatusDialog(value: boolean) {
       this.purchaseStatusService.createDialog= value;
   }

    get purchaseItemsElement(): PurchaseItemDto {
        if( this._purchaseItemsElement == null )
            this._purchaseItemsElement = new PurchaseItemDto();
         return this._purchaseItemsElement;
    }

    set purchaseItemsElement(value: PurchaseItemDto) {
        this._purchaseItemsElement = value;
    }


}
