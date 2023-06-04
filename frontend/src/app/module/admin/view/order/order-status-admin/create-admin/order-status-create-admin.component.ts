import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {OrderStatusService} from 'src/app/controller/service/OrderStatus.service';
import {OrderStatusDto} from 'src/app/controller/model/OrderStatus.model';
import {OrderStatusCriteria} from 'src/app/controller/criteria/OrderStatusCriteria.model';
@Component({
  selector: 'app-order-status-create-admin',
  templateUrl: './order-status-create-admin.component.html'
})
export class OrderStatusCreateAdminComponent extends AbstractCreateController<OrderStatusDto, OrderStatusCriteria, OrderStatusService>  implements OnInit {




    constructor( private orderStatusService: OrderStatusService ) {
        super(orderStatusService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }










}
