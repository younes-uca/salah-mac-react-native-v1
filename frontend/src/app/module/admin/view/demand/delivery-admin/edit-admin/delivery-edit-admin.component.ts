import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {DeliveryService} from 'src/app/controller/service/Delivery.service';
import {DeliveryDto} from 'src/app/controller/model/Delivery.model';
import {DeliveryCriteria} from 'src/app/controller/criteria/DeliveryCriteria.model';


import {StoreDto} from 'src/app/controller/model/Store.model';
import {StoreService} from 'src/app/controller/service/Store.service';
import {DeliveryStatusDto} from 'src/app/controller/model/DeliveryStatus.model';
import {DeliveryStatusService} from 'src/app/controller/service/DeliveryStatus.service';
import {ClientDto} from 'src/app/controller/model/Client.model';
import {ClientService} from 'src/app/controller/service/Client.service';
import {ProductDto} from 'src/app/controller/model/Product.model';
import {ProductService} from 'src/app/controller/service/Product.service';
import {DeliveryItemDto} from 'src/app/controller/model/DeliveryItem.model';
import {DeliveryItemService} from 'src/app/controller/service/DeliveryItem.service';
import {DemandDto} from 'src/app/controller/model/Demand.model';
import {DemandService} from 'src/app/controller/service/Demand.service';

@Component({
  selector: 'app-delivery-edit-admin',
  templateUrl: './delivery-edit-admin.component.html'
})
export class DeliveryEditAdminComponent extends AbstractEditController<DeliveryDto, DeliveryCriteria, DeliveryService>   implements OnInit {

    private _deliveryItemsElement = new DeliveryItemDto();





    constructor( private deliveryService: DeliveryService , private storeService: StoreService, private deliveryStatusService: DeliveryStatusService, private clientService: ClientService, private productService: ProductService, private deliveryItemService: DeliveryItemService, private demandService: DemandService) {
        super(deliveryService);
    }

    ngOnInit(): void {
        this.deliveryItemsElement.product = new ProductDto();
        this.productService.findAll().subscribe((data) => this.products = data);
        this.deliveryItemsElement.store = new StoreDto();
        this.storeService.findAll().subscribe((data) => this.stores = data);

    this.demand = new DemandDto();
    this.demandService.findAll().subscribe((data) => this.demands = data);
    this.deliveryStatus = new DeliveryStatusDto();
    this.deliveryStatusService.findAll().subscribe((data) => this.deliveryStatuss = data);
    this.client = new ClientDto();
    this.clientService.findAll().subscribe((data) => this.clients = data);
}
    public prepareEdit() {
        this.item.deliveryDate = this.deliveryService.format(this.item.deliveryDate);
    }



    public validateDeliveryItems(){
        this.errorMessages = new Array();
    }
    public setValidation(value : boolean){
        }
   public addDeliveryItems() {
        if( this.item.deliveryItems == null )
            this.item.deliveryItems = new Array<DeliveryItemDto>();
       this.validateDeliveryItems();
       if (this.errorMessages.length === 0) {
            if(this.deliveryItemsElement.id == null){
                this.item.deliveryItems.push(this.deliveryItemsElement);
            }else{
                const index = this.item.deliveryItems.findIndex(e => e.id == this.deliveryItemsElement.id);
                this.item.deliveryItems[index] = this.deliveryItemsElement;
            }
          this.deliveryItemsElement = new DeliveryItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteDeliveryItem(p: DeliveryItemDto) {
        this.item.deliveryItems.forEach((element, index) => {
            if (element === p) { this.item.deliveryItems.splice(index, 1); }
        });
    }

    public editDeliveryItem(p: DeliveryItemDto) {
        this.deliveryItemsElement = {... p};
        this.activeTab = 0;
    }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



   public async openCreateDemand(demand: string) {
        const isPermistted = await this.roleService.isPermitted('Demand', 'edit');
        if(isPermistted) {
             this.demand = new DemandDto();
             this.createDemandDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }
   public async openCreateDeliveryStatus(deliveryStatus: string) {
        const isPermistted = await this.roleService.isPermitted('DeliveryStatus', 'edit');
        if(isPermistted) {
             this.deliveryStatus = new DeliveryStatusDto();
             this.createDeliveryStatusDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get demand(): DemandDto {
       return this.demandService.item;
   }
  set demand(value: DemandDto) {
        this.demandService.item = value;
   }
   get demands(): Array<DemandDto> {
        return this.demandService.items;
   }
   set demands(value: Array<DemandDto>) {
        this.demandService.items = value;
   }
   get createDemandDialog(): boolean {
       return this.demandService.createDialog;
   }
  set createDemandDialog(value: boolean) {
       this.demandService.createDialog= value;
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
   get deliveryStatus(): DeliveryStatusDto {
       return this.deliveryStatusService.item;
   }
  set deliveryStatus(value: DeliveryStatusDto) {
        this.deliveryStatusService.item = value;
   }
   get deliveryStatuss(): Array<DeliveryStatusDto> {
        return this.deliveryStatusService.items;
   }
   set deliveryStatuss(value: Array<DeliveryStatusDto>) {
        this.deliveryStatusService.items = value;
   }
   get createDeliveryStatusDialog(): boolean {
       return this.deliveryStatusService.createDialog;
   }
  set createDeliveryStatusDialog(value: boolean) {
       this.deliveryStatusService.createDialog= value;
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

    get deliveryItemsElement(): DeliveryItemDto {
        if( this._deliveryItemsElement == null )
            this._deliveryItemsElement = new DeliveryItemDto();
         return this._deliveryItemsElement;
    }

    set deliveryItemsElement(value: DeliveryItemDto) {
        this._deliveryItemsElement = value;
    }


}
