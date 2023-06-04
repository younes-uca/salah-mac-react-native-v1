import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {DeliveryDto} from '../model/Delivery.model';
import {DeliveryCriteria} from '../criteria/DeliveryCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {DemandDto} from '../model/Demand.model';
import {DeliveryItemDto} from '../model/DeliveryItem.model';
import {DeliveryStatusDto} from '../model/DeliveryStatus.model';
import {ClientDto} from '../model/Client.model';

@Injectable({
  providedIn: 'root'
})
export class DeliveryService extends AbstractService<DeliveryDto, DeliveryCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/delivery/');
    }

    public constrcutDto(): DeliveryDto {
        return new DeliveryDto();
    }

    public constrcutCriteria(): DeliveryCriteria {
        return new DeliveryCriteria();
    }
}
