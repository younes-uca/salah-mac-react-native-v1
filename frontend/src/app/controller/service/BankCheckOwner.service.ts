import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {BankCheckOwnerDto} from '../model/BankCheckOwner.model';
import {BankCheckOwnerCriteria} from '../criteria/BankCheckOwnerCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {BankDto} from '../model/Bank.model';
import {CheckOwnerDto} from '../model/CheckOwner.model';

@Injectable({
  providedIn: 'root'
})
export class BankCheckOwnerService extends AbstractService<BankCheckOwnerDto, BankCheckOwnerCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/bankCheckOwner/');
    }

    public constrcutDto(): BankCheckOwnerDto {
        return new BankCheckOwnerDto();
    }

    public constrcutCriteria(): BankCheckOwnerCriteria {
        return new BankCheckOwnerCriteria();
    }
}
