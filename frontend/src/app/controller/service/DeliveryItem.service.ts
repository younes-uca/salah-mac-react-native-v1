import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {DeliveryItemDto} from '../model/DeliveryItem.model';
import {DeliveryItemCriteria} from '../criteria/DeliveryItemCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {ProductDto} from '../model/Product.model';
import {StoreDto} from '../model/Store.model';
import {DeliveryDto} from '../model/Delivery.model';

@Injectable({
  providedIn: 'root'
})
export class DeliveryItemService extends AbstractService<DeliveryItemDto, DeliveryItemCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/deliveryItem/');
    }

    public constrcutDto(): DeliveryItemDto {
        return new DeliveryItemDto();
    }

    public constrcutCriteria(): DeliveryItemCriteria {
        return new DeliveryItemCriteria();
    }
}
