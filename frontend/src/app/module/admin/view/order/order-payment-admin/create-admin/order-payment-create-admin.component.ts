import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

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
  selector: 'app-order-payment-create-admin',
  templateUrl: './order-payment-create-admin.component.html'
})
export class OrderPaymentCreateAdminComponent extends AbstractCreateController<OrderPaymentDto, OrderPaymentCriteria, OrderPaymentService>  implements OnInit {



    private _validOrderStatusOrderLibelle = true;
    private _validOrderStatusOrderCode = true;

    constructor( private orderPaymentService: OrderPaymentService , private orderService: OrderService, private paymentModeService: PaymentModeService, private orderStatusOrderService: OrderStatusOrderService) {
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





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



    public async openCreateOrderStatusOrder(orderStatusOrder: string) {
    const isPermistted = await this.roleService.isPermitted('OrderStatusOrder', 'add');
    if(isPermistted) {
         this.orderStatusOrder = new OrderStatusOrderDto();
         this.createOrderStatusOrderDialog = true;
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

    get orderStatusOrder(): OrderStatusOrderDto {
        return this.orderStatusOrderService.item;
    }
    set orderStatusOrder(value: OrderStatusOrderDto) {
        this.orderStatusOrderService.item = value;
    }
    get orderStatusOrders(): Array<OrderStatusOrderDto> {
        return this.orderStatusOrderService.items;
    }
    set orderStatusOrders(value: Array<OrderStatusOrderDto>) {
        this.orderStatusOrderService.items = value;
    }
    get createOrderStatusOrderDialog(): boolean {
       return this.orderStatusOrderService.createDialog;
    }
    set createOrderStatusOrderDialog(value: boolean) {
        this.orderStatusOrderService.createDialog= value;
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




    get validOrderStatusOrderLibelle(): boolean {
        return this._validOrderStatusOrderLibelle;
    }
    set validOrderStatusOrderLibelle(value: boolean) {
        this._validOrderStatusOrderLibelle = value;
    }
    get validOrderStatusOrderCode(): boolean {
        return this._validOrderStatusOrderCode;
    }
    set validOrderStatusOrderCode(value: boolean) {
        this._validOrderStatusOrderCode = value;
    }


}
