import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {CreditNotePurchaseItemDto} from '../model/CreditNotePurchaseItem.model';
import {CreditNotePurchaseItemCriteria} from '../criteria/CreditNotePurchaseItemCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {ProductDto} from '../model/Product.model';
import {CreditNotePurchaseDto} from '../model/CreditNotePurchase.model';

@Injectable({
  providedIn: 'root'
})
export class CreditNotePurchaseItemService extends AbstractService<CreditNotePurchaseItemDto, CreditNotePurchaseItemCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/creditNotePurchaseItem/');
    }

    public constrcutDto(): CreditNotePurchaseItemDto {
        return new CreditNotePurchaseItemDto();
    }

    public constrcutCriteria(): CreditNotePurchaseItemCriteria {
        return new CreditNotePurchaseItemCriteria();
    }
}
