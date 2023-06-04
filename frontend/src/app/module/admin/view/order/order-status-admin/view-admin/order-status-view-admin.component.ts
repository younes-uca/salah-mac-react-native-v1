import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {OrderStatusService} from 'src/app/controller/service/OrderStatus.service';
import {OrderStatusDto} from 'src/app/controller/model/OrderStatus.model';
import {OrderStatusCriteria} from 'src/app/controller/criteria/OrderStatusCriteria.model';

@Component({
  selector: 'app-order-status-view-admin',
  templateUrl: './order-status-view-admin.component.html'
})
export class OrderStatusViewAdminComponent extends AbstractViewController<OrderStatusDto, OrderStatusCriteria, OrderStatusService> implements OnInit {


    constructor(private orderStatusService: OrderStatusService){
        super(orderStatusService);
    }

    ngOnInit(): void {
    }




}
