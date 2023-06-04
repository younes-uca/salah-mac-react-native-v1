import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {SaleService} from 'src/app/controller/service/Sale.service';
import {SaleDto} from 'src/app/controller/model/Sale.model';
import {SaleCriteria} from 'src/app/controller/criteria/SaleCriteria.model';


import {StoreDto} from 'src/app/controller/model/Store.model';
import {StoreService} from 'src/app/controller/service/Store.service';
import {SaleItemDto} from 'src/app/controller/model/SaleItem.model';
import {SaleItemService} from 'src/app/controller/service/SaleItem.service';
import {ClientDto} from 'src/app/controller/model/Client.model';
import {ClientService} from 'src/app/controller/service/Client.service';
import {ProductDto} from 'src/app/controller/model/Product.model';
import {ProductService} from 'src/app/controller/service/Product.service';
import {SaleStatusDto} from 'src/app/controller/model/SaleStatus.model';
import {SaleStatusService} from 'src/app/controller/service/SaleStatus.service';

@Component({
  selector: 'app-sale-edit-admin',
  templateUrl: './sale-edit-admin.component.html'
})
export class SaleEditAdminComponent extends AbstractEditController<SaleDto, SaleCriteria, SaleService>   implements OnInit {

    private _saleItemsElement = new SaleItemDto();





    constructor( private saleService: SaleService , private storeService: StoreService, private saleItemService: SaleItemService, private clientService: ClientService, private productService: ProductService, private saleStatusService: SaleStatusService) {
        super(saleService);
    }

    ngOnInit(): void {
        this.saleItemsElement.product = new ProductDto();
        this.productService.findAll().subscribe((data) => this.products = data);

    this.store = new StoreDto();
    this.storeService.findAll().subscribe((data) => this.stores = data);
    this.client = new ClientDto();
    this.clientService.findAll().subscribe((data) => this.clients = data);
    this.saleStatus = new SaleStatusDto();
    this.saleStatusService.findAll().subscribe((data) => this.saleStatuss = data);
}
    public prepareEdit() {
        this.item.saleDate = this.saleService.format(this.item.saleDate);
    }



    public validateSaleItems(){
        this.errorMessages = new Array();
    }
    public setValidation(value : boolean){
        }
   public addSaleItems() {
        if( this.item.saleItems == null )
            this.item.saleItems = new Array<SaleItemDto>();
       this.validateSaleItems();
       if (this.errorMessages.length === 0) {
            if(this.saleItemsElement.id == null){
                this.item.saleItems.push(this.saleItemsElement);
            }else{
                const index = this.item.saleItems.findIndex(e => e.id == this.saleItemsElement.id);
                this.item.saleItems[index] = this.saleItemsElement;
            }
          this.saleItemsElement = new SaleItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteSaleItem(p: SaleItemDto) {
        this.item.saleItems.forEach((element, index) => {
            if (element === p) { this.item.saleItems.splice(index, 1); }
        });
    }

    public editSaleItem(p: SaleItemDto) {
        this.saleItemsElement = {... p};
        this.activeTab = 0;
    }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



   public async openCreateSaleStatus(saleStatus: string) {
        const isPermistted = await this.roleService.isPermitted('SaleStatus', 'edit');
        if(isPermistted) {
             this.saleStatus = new SaleStatusDto();
             this.createSaleStatusDialog = true;
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
   get client(): ClientDto {
       return this.clientService.item;
   }
  set client(value: ClientDto) {
        this.clientService.item = value;
   }
   get clients(): Array<ClientDto> {
        return this.clientService.items;
   }
   set clients(value: Array<ClientDto>) {
        this.clientService.items = value;
   }
   get createClientDialog(): boolean {
       return this.clientService.createDialog;
   }
  set createClientDialog(value: boolean) {
       this.clientService.createDialog= value;
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
   get saleStatus(): SaleStatusDto {
       return this.saleStatusService.item;
   }
  set saleStatus(value: SaleStatusDto) {
        this.saleStatusService.item = value;
   }
   get saleStatuss(): Array<SaleStatusDto> {
        return this.saleStatusService.items;
   }
   set saleStatuss(value: Array<SaleStatusDto>) {
        this.saleStatusService.items = value;
   }
   get createSaleStatusDialog(): boolean {
       return this.saleStatusService.createDialog;
   }
  set createSaleStatusDialog(value: boolean) {
       this.saleStatusService.createDialog= value;
   }

    get saleItemsElement(): SaleItemDto {
        if( this._saleItemsElement == null )
            this._saleItemsElement = new SaleItemDto();
         return this._saleItemsElement;
    }

    set saleItemsElement(value: SaleItemDto) {
        this._saleItemsElement = value;
    }


}
