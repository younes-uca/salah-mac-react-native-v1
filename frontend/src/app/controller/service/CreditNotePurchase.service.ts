import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {CreditNotePurchaseDto} from '../model/CreditNotePurchase.model';
import {CreditNotePurchaseCriteria} from '../criteria/CreditNotePurchaseCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {PurchaseDto} from '../model/Purchase.model';
import {CreditNotePurchaseStatusDto} from '../model/CreditNotePurchaseStatus.model';
import {CreditNotePurchaseItemDto} from '../model/CreditNotePurchaseItem.model';

@Injectable({
  providedIn: 'root'
})
export class CreditNotePurchaseService extends AbstractService<CreditNotePurchaseDto, CreditNotePurchaseCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/creditNotePurchase/');
    }

    public constrcutDto(): CreditNotePurchaseDto {
        return new CreditNotePurchaseDto();
    }

    public constrcutCriteria(): CreditNotePurchaseCriteria {
        return new CreditNotePurchaseCriteria();
    }
}
