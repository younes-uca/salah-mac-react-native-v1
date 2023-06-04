import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {AccountingClassDto} from '../model/AccountingClass.model';
import {AccountingClassCriteria} from '../criteria/AccountingClassCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class AccountingClassService extends AbstractService<AccountingClassDto, AccountingClassCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/accountingClass/');
    }

    public constrcutDto(): AccountingClassDto {
        return new AccountingClassDto();
    }

    public constrcutCriteria(): AccountingClassCriteria {
        return new AccountingClassCriteria();
    }
}
