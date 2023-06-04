import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {OrderPaymentDto} from '../model/OrderPayment.model';
import {OrderPaymentCriteria} from '../criteria/OrderPaymentCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {OrderDto} from '../model/Order.model';
import {OrderStatusOrderDto} from '../model/OrderStatusOrder.model';
import {PaymentModeDto} from '../model/PaymentMode.model';

@Injectable({
  providedIn: 'root'
})
export class OrderPaymentService extends AbstractService<OrderPaymentDto, OrderPaymentCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/orderPayment/');
    }

    public constrcutDto(): OrderPaymentDto {
        return new OrderPaymentDto();
    }

    public constrcutCriteria(): OrderPaymentCriteria {
        return new OrderPaymentCriteria();
    }
}
