import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {AccountingOperationTypeDto} from '../model/AccountingOperationType.model';
import {AccountingOperationTypeCriteria} from '../criteria/AccountingOperationTypeCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class AccountingOperationTypeService extends AbstractService<AccountingOperationTypeDto, AccountingOperationTypeCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/accountingOperationType/');
    }

    public constrcutDto(): AccountingOperationTypeDto {
        return new AccountingOperationTypeDto();
    }

    public constrcutCriteria(): AccountingOperationTypeCriteria {
        return new AccountingOperationTypeCriteria();
    }
}
