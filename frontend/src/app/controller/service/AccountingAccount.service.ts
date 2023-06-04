import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {AccountingAccountDto} from '../model/AccountingAccount.model';
import {AccountingAccountCriteria} from '../criteria/AccountingAccountCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {SubAccountingClassDto} from '../model/SubAccountingClass.model';

@Injectable({
  providedIn: 'root'
})
export class AccountingAccountService extends AbstractService<AccountingAccountDto, AccountingAccountCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/accountingAccount/');
    }

    public constrcutDto(): AccountingAccountDto {
        return new AccountingAccountDto();
    }

    public constrcutCriteria(): AccountingAccountCriteria {
        return new AccountingAccountCriteria();
    }
}
