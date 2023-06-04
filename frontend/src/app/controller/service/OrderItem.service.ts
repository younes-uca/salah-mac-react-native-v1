import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {OrderItemDto} from '../model/OrderItem.model';
import {OrderItemCriteria} from '../criteria/OrderItemCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {OrderDto} from '../model/Order.model';
import {ProductDto} from '../model/Product.model';

@Injectable({
  providedIn: 'root'
})
export class OrderItemService extends AbstractService<OrderItemDto, OrderItemCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/orderItem/');
    }

    public constrcutDto(): OrderItemDto {
        return new OrderItemDto();
    }

    public constrcutCriteria(): OrderItemCriteria {
        return new OrderItemCriteria();
    }
}
