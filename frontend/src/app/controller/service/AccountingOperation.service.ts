import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {AccountingOperationDto} from '../model/AccountingOperation.model';
import {AccountingOperationCriteria} from '../criteria/AccountingOperationCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {AccountingOperationTypeDto} from '../model/AccountingOperationType.model';
import {CompanyDto} from '../model/Company.model';
import {AccountingOperationStatusDto} from '../model/AccountingOperationStatus.model';
import {AccountingAccountDto} from '../model/AccountingAccount.model';

@Injectable({
  providedIn: 'root'
})
export class AccountingOperationService extends AbstractService<AccountingOperationDto, AccountingOperationCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/accountingOperation/');
    }

    public constrcutDto(): AccountingOperationDto {
        return new AccountingOperationDto();
    }

    public constrcutCriteria(): AccountingOperationCriteria {
        return new AccountingOperationCriteria();
    }
}
