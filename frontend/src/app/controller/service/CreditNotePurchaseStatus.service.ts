import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {CreditNotePurchaseStatusDto} from '../model/CreditNotePurchaseStatus.model';
import {CreditNotePurchaseStatusCriteria} from '../criteria/CreditNotePurchaseStatusCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class CreditNotePurchaseStatusService extends AbstractService<CreditNotePurchaseStatusDto, CreditNotePurchaseStatusCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/creditNotePurchaseStatus/');
    }

    public constrcutDto(): CreditNotePurchaseStatusDto {
        return new CreditNotePurchaseStatusDto();
    }

    public constrcutCriteria(): CreditNotePurchaseStatusCriteria {
        return new CreditNotePurchaseStatusCriteria();
    }
}
