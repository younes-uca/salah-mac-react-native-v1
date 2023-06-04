import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

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
  selector: 'app-order-view-admin',
  templateUrl: './order-view-admin.component.html'
})
export class OrderViewAdminComponent extends AbstractViewController<OrderDto, OrderCriteria, OrderService> implements OnInit {

    orderItems = new OrderItemDto();
    orderItemss: Array<OrderItemDto> = [];

    constructor(private orderService: OrderService, private orderItemService: OrderItemService, private clientService: ClientService, private orderStatusService: OrderStatusService, private productService: ProductService){
        super(orderService);
    }

    ngOnInit(): void {
        this.orderItems.product = new ProductDto();
        this.productService.findAll().subscribe((data) => this.products = data);
        this.client = new ClientDto();
        this.clientService.findAll().subscribe((data) => this.clients = data);
        this.orderStatus = new OrderStatusDto();
        this.orderStatusService.findAll().subscribe((data) => this.orderStatuss = data);
    }


    get product(): ProductDto {
       return this.productService.item;
    }
    set product(value: ProductDto) {
        this.productService.item = value;
    }
    get products():Array<ProductDto> {
       return this.productService.items;
    }
    set products(value: Array<ProductDto>) {
        this.productService.items = value;
    }
    get client(): ClientDto {
       return this.clientService.item;
    }
    set client(value: ClientDto) {
        this.clientService.item = value;
    }
    get clients():Array<ClientDto> {
       return this.clientService.items;
    }
    set clients(value: Array<ClientDto>) {
        this.clientService.items = value;
    }
    get orderStatus(): OrderStatusDto {
       return this.orderStatusService.item;
    }
    set orderStatus(value: OrderStatusDto) {
        this.orderStatusService.item = value;
    }
    get orderStatuss():Array<OrderStatusDto> {
       return this.orderStatusService.items;
    }
    set orderStatuss(value: Array<OrderStatusDto>) {
        this.orderStatusService.items = value;
    }


}
