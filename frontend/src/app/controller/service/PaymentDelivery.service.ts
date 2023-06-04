import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {PaymentDeliveryDto} from '../model/PaymentDelivery.model';
import {PaymentDeliveryCriteria} from '../criteria/PaymentDeliveryCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {SaleDto} from '../model/Sale.model';
import {PaymentMethodDto} from '../model/PaymentMethod.model';
import {PaymentDeliveryStatusDto} from '../model/PaymentDeliveryStatus.model';
import {DeliveryDto} from '../model/Delivery.model';

@Injectable({
  providedIn: 'root'
})
export class PaymentDeliveryService extends AbstractService<PaymentDeliveryDto, PaymentDeliveryCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/paymentDelivery/');
    }

    public constrcutDto(): PaymentDeliveryDto {
        return new PaymentDeliveryDto();
    }

    public constrcutCriteria(): PaymentDeliveryCriteria {
        return new PaymentDeliveryCriteria();
    }
}
