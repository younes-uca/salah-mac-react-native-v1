import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {OrderStatusDto} from '../model/OrderStatus.model';
import {OrderStatusCriteria} from '../criteria/OrderStatusCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class OrderStatusService extends AbstractService<OrderStatusDto, OrderStatusCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/orderStatus/');
    }

    public constrcutDto(): OrderStatusDto {
        return new OrderStatusDto();
    }

    public constrcutCriteria(): OrderStatusCriteria {
        return new OrderStatusCriteria();
    }
}
