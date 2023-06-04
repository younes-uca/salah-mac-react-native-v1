import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {OrderStatusOrderService} from 'src/app/controller/service/OrderStatusOrder.service';
import {OrderStatusOrderDto} from 'src/app/controller/model/OrderStatusOrder.model';
import {OrderStatusOrderCriteria} from 'src/app/controller/criteria/OrderStatusOrderCriteria.model';

@Component({
  selector: 'app-order-status-order-view-admin',
  templateUrl: './order-status-order-view-admin.component.html'
})
export class OrderStatusOrderViewAdminComponent extends AbstractViewController<OrderStatusOrderDto, OrderStatusOrderCriteria, OrderStatusOrderService> implements OnInit {


    constructor(private orderStatusOrderService: OrderStatusOrderService){
        super(orderStatusOrderService);
    }

    ngOnInit(): void {
    }




}
