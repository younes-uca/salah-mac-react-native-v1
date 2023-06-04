import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {PaymentPurchaseDto} from '../model/PaymentPurchase.model';
import {PaymentPurchaseCriteria} from '../criteria/PaymentPurchaseCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {PurchaseDto} from '../model/Purchase.model';
import {PurchasePaymentStatusDto} from '../model/PurchasePaymentStatus.model';
import {PaymentModeDto} from '../model/PaymentMode.model';

@Injectable({
  providedIn: 'root'
})
export class PaymentPurchaseService extends AbstractService<PaymentPurchaseDto, PaymentPurchaseCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/paymentPurchase/');
    }

    public constrcutDto(): PaymentPurchaseDto {
        return new PaymentPurchaseDto();
    }

    public constrcutCriteria(): PaymentPurchaseCriteria {
        return new PaymentPurchaseCriteria();
    }
}
