import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {OrderStatusOrderService} from 'src/app/controller/service/OrderStatusOrder.service';
import {OrderStatusOrderDto} from 'src/app/controller/model/OrderStatusOrder.model';
import {OrderStatusOrderCriteria} from 'src/app/controller/criteria/OrderStatusOrderCriteria.model';



@Component({
  selector: 'app-order-status-order-edit-admin',
  templateUrl: './order-status-order-edit-admin.component.html'
})
export class OrderStatusOrderEditAdminComponent extends AbstractEditController<OrderStatusOrderDto, OrderStatusOrderCriteria, OrderStatusOrderService>   implements OnInit {


    private _validOrderStatusOrderLibelle = true;
    private _validOrderStatusOrderCode = true;




    constructor( private orderStatusOrderService: OrderStatusOrderService ) {
        super(orderStatusOrderService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        this.validOrderStatusOrderLibelle = value;
        this.validOrderStatusOrderCode = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateOrderStatusOrderLibelle();
        this.validateOrderStatusOrderCode();
    }
    public validateOrderStatusOrderLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validOrderStatusOrderLibelle = false;
        } else {
            this.validOrderStatusOrderLibelle = true;
        }
    }
    public validateOrderStatusOrderCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validOrderStatusOrderCode = false;
        } else {
            this.validOrderStatusOrderCode = true;
        }
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
