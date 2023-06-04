import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {ReceptionService} from 'src/app/controller/service/Reception.service';
import {ReceptionDto} from 'src/app/controller/model/Reception.model';
import {ReceptionCriteria} from 'src/app/controller/criteria/ReceptionCriteria.model';
import {ReceptionStatusDto} from 'src/app/controller/model/ReceptionStatus.model';
import {ReceptionStatusService} from 'src/app/controller/service/ReceptionStatus.service';
import {StoreDto} from 'src/app/controller/model/Store.model';
import {StoreService} from 'src/app/controller/service/Store.service';
import {OrderDto} from 'src/app/controller/model/Order.model';
import {OrderService} from 'src/app/controller/service/Order.service';
import {ProductDto} from 'src/app/controller/model/Product.model';
import {ProductService} from 'src/app/controller/service/Product.service';
import {ReceptionItemDto} from 'src/app/controller/model/ReceptionItem.model';
import {ReceptionItemService} from 'src/app/controller/service/ReceptionItem.service';
@Component({
  selector: 'app-reception-create-admin',
  templateUrl: './reception-create-admin.component.html'
})
export class ReceptionCreateAdminComponent extends AbstractCreateController<ReceptionDto, ReceptionCriteria, ReceptionService>  implements OnInit {

    private _receptionItemsElement = new ReceptionItemDto();



    constructor( private receptionService: ReceptionService , private receptionStatusService: ReceptionStatusService, private storeService: StoreService, private orderService: OrderService, private productService: ProductService, private receptionItemService: ReceptionItemService) {
        super(receptionService);
    }

    ngOnInit(): void {
        this.receptionItemsElement.product = new ProductDto();
        this.productService.findAll().subscribe((data) => this.products = data);
        this.receptionItemsElement.store = new StoreDto();
        this.storeService.findAll().subscribe((data) => this.stores = data);
    this.order = new OrderDto();
    this.orderService.findAll().subscribe((data) => this.orders = data);
    this.receptionStatus = new ReceptionStatusDto();
    this.receptionStatusService.findAll().subscribe((data) => this.receptionStatuss = data);
}



    validateReceptionItems(){
        this.errorMessages = new Array();
    }


    public setValidation(value: boolean){
    }

    public addReceptionItems() {
        if( this.item.receptionItems == null )
            this.item.receptionItems = new Array<ReceptionItemDto>();
       this.validateReceptionItems();
       if (this.errorMessages.length === 0) {
              this.item.receptionItems.push({... this.receptionItemsElement});
              this.receptionItemsElement = new ReceptionItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deleteReceptionItem(p: ReceptionItemDto) {
        this.item.receptionItems.forEach((element, index) => {
            if (element === p) { this.item.receptionItems.splice(index, 1); }
        });
    }

    public editReceptionItem(p: ReceptionItemDto) {
        this.receptionItemsElement = {... p};
        this.activeTab = 0;
    }


    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



    public async openCreateReceptionStatus(receptionStatus: string) {
    const isPermistted = await this.roleService.isPermitted('ReceptionStatus', 'add');
    if(isPermistted) {
         this.receptionStatus = new ReceptionStatusDto();
         this.createReceptionStatusDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }
    public async openCreateOrder(order: string) {
    const isPermistted = await this.roleService.isPermitted('Order', 'add');
    if(isPermistted) {
         this.order = new OrderDto();
         this.createOrderDialog = true;
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
    get receptionStatus(): ReceptionStatusDto {
        return this.receptionStatusService.item;
    }
    set receptionStatus(value: ReceptionStatusDto) {
        this.receptionStatusService.item = value;
    }
    get receptionStatuss(): Array<ReceptionStatusDto> {
        return this.receptionStatusService.items;
    }
    set receptionStatuss(value: Array<ReceptionStatusDto>) {
        this.receptionStatusService.items = value;
    }
    get createReceptionStatusDialog(): boolean {
       return this.receptionStatusService.createDialog;
    }
    set createReceptionStatusDialog(value: boolean) {
        this.receptionStatusService.createDialog= value;
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
    get order(): OrderDto {
        return this.orderService.item;
    }
    set order(value: OrderDto) {
        this.orderService.item = value;
    }
    get orders(): Array<OrderDto> {
        return this.orderService.items;
    }
    set orders(value: Array<OrderDto>) {
        this.orderService.items = value;
    }
    get createOrderDialog(): boolean {
       return this.orderService.createDialog;
    }
    set createOrderDialog(value: boolean) {
        this.orderService.createDialog= value;
    }





    get receptionItemsElement(): ReceptionItemDto {
        if( this._receptionItemsElement == null )
            this._receptionItemsElement = new ReceptionItemDto();
        return this._receptionItemsElement;
    }

    set receptionItemsElement(value: ReceptionItemDto) {
        this._receptionItemsElement = value;
    }

}
