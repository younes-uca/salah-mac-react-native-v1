import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {OrderService} from 'src/app/controller/service/Order.service';
import {OrderDto} from 'src/app/controller/model/Order.model';
import {OrderCriteria} from 'src/app/controller/criteria/OrderCriteria.model';


import {OrderItemDto} from 'src/app/controller/model/OrderItem.model';
import {OrderItemService} from 'src/app/controller/service/OrderItem.service';
import {ClientDto} from 'src/app/controller/model/Client.model';
import {ClientService} from 'src/app/controller/service/Client.service';
import {OrderStatusDto} from 'src/app/controller/model/OrderStatus.model';
import {OrderStatusService} from 'src/app/controller/service/OrderStatus.service';
import {ProductDto} from 'src/app/controller/model/Product.model';
import {ProductService} from 'src/app/controller/service/Product.service';

@Component({
  selector: 'app-order-edit-admin',
  templateUrl: './order-edit-admin.component.html'
})
export class OrderEditAdminComponent extends AbstractEditController<OrderDto, OrderCriteria, OrderService>   implements OnInit {

    private _orderItemsElement = new OrderItemDto();





    constructor( private orderService: OrderService , private orderItemService: OrderItemService, private clientService: ClientService, private orderStatusService: OrderStatusService, private productService: ProductService) {
        super(orderService);
    }

    ngOnInit(): void {
        this.orderItemsElement.product = new ProductDto();
        this.productService.findAll().subscribe((data) => this.products = data);

    this.client = new ClientDto();
    this.clientService.findAll().subscribe((data) => this.clients = data);
    this.orderStatus = new OrderStatusDto();
    this.orderStatusService.findAll().subscribe((data) => this.orderStatuss = data);
}
    public prepareEdit() {
        this.item.orderDate = this.orderService.format(this.item.orderDate);
    }



    public validateOrderItems(){
        this.errorMessages = new Array();
    }
    public setValidation(value : boolean){
        }
   public addOrderItems() {
        if( this.item.orderItems == null )
            this.item.orderItems = new Array<OrderItemDto>();
       this.validateOrderItems();
       if (this.errorMessages.length === 0) {
            if(this.orderItemsElement.id == null){
                this.item.orderItems.push(this.orderItemsElement);
            }else{
                const index = this.item.orderItems.findIndex(e => e.id == this.orderItemsElement.id);
                this.item.orderItems[index] = this.orderItemsElement;
            }
          this.orderItemsElement = new OrderItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteOrderItem(p: OrderItemDto) {
        this.item.orderItems.forEach((element, index) => {
            if (element === p) { this.item.orderItems.splice(index, 1); }
        });
    }

    public editOrderItem(p: OrderItemDto) {
        this.orderItemsElement = {... p};
        this.activeTab = 0;
    }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



   public async openCreateOrderStatus(orderStatus: string) {
        const isPermistted = await this.roleService.isPermitted('OrderStatus', 'edit');
        if(isPermistted) {
             this.orderStatus = new OrderStatusDto();
             this.createOrderStatusDialog = true;
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
   get orderStatus(): OrderStatusDto {
       return this.orderStatusService.item;
   }
  set orderStatus(value: OrderStatusDto) {
        this.orderStatusService.item = value;
   }
   get orderStatuss(): Array<OrderStatusDto> {
        return this.orderStatusService.items;
   }
   set orderStatuss(value: Array<OrderStatusDto>) {
        this.orderStatusService.items = value;
   }
   get createOrderStatusDialog(): boolean {
       return this.orderStatusService.createDialog;
   }
  set createOrderStatusDialog(value: boolean) {
       this.orderStatusService.createDialog= value;
   }

    get orderItemsElement(): OrderItemDto {
        if( this._orderItemsElement == null )
            this._orderItemsElement = new OrderItemDto();
         return this._orderItemsElement;
    }

    set orderItemsElement(value: OrderItemDto) {
        this._orderItemsElement = value;
    }


}
