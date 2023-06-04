import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {OrderPaymentService} from 'src/app/controller/service/OrderPayment.service';
import {OrderPaymentDto} from 'src/app/controller/model/OrderPayment.model';
import {OrderPaymentCriteria} from 'src/app/controller/criteria/OrderPaymentCriteria.model';

import {OrderDto} from 'src/app/controller/model/Order.model';
import {OrderService} from 'src/app/controller/service/Order.service';
import {PaymentModeDto} from 'src/app/controller/model/PaymentMode.model';
import {PaymentModeService} from 'src/app/controller/service/PaymentMode.service';
import {OrderStatusOrderDto} from 'src/app/controller/model/OrderStatusOrder.model';
import {OrderStatusOrderService} from 'src/app/controller/service/OrderStatusOrder.service';
@Component({
  selector: 'app-order-payment-view-admin',
  templateUrl: './order-payment-view-admin.component.html'
})
export class OrderPaymentViewAdminComponent extends AbstractViewController<OrderPaymentDto, OrderPaymentCriteria, OrderPaymentService> implements OnInit {


    constructor(private orderPaymentService: OrderPaymentService, private orderService: OrderService, private paymentModeService: PaymentModeService, private orderStatusOrderService: OrderStatusOrderService){
        super(orderPaymentService);
    }

    ngOnInit(): void {
        this.order = new OrderDto();
        this.orderService.findAll().subscribe((data) => this.orders = data);
        this.paymentMode = new PaymentModeDto();
        this.paymentModeService.findAll().subscribe((data) => this.paymentModes = data);
        this.orderStatusOrder = new OrderStatusOrderDto();
        this.orderStatusOrderService.findAll().subscribe((data) => this.orderStatusOrders = data);
    }


    get orderStatusOrder(): OrderStatusOrderDto {
       return this.orderStatusOrderService.item;
    }
    set orderStatusOrder(value: OrderStatusOrderDto) {
        this.orderStatusOrderService.item = value;
    }
    get orderStatusOrders():Array<OrderStatusOrderDto> {
       return this.orderStatusOrderService.items;
    }
    set orderStatusOrders(value: Array<OrderStatusOrderDto>) {
        this.orderStatusOrderService.items = value;
    }
    get paymentMode(): PaymentModeDto {
       return this.paymentModeService.item;
    }
    set paymentMode(value: PaymentModeDto) {
        this.paymentModeService.item = value;
    }
    get paymentModes():Array<PaymentModeDto> {
       return this.paymentModeService.items;
    }
    set paymentModes(value: Array<PaymentModeDto>) {
        this.paymentModeService.items = value;
    }
    get order(): OrderDto {
       return this.orderService.item;
    }
    set order(value: OrderDto) {
        this.orderService.item = value;
    }
    get orders():Array<OrderDto> {
       return this.orderService.items;
    }
    set orders(value: Array<OrderDto>) {
        this.orderService.items = value;
    }


}
