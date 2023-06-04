import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {BalanceSheetDto} from '../model/BalanceSheet.model';
import {BalanceSheetCriteria} from '../criteria/BalanceSheetCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {CompanyDto} from '../model/Company.model';
import {BalanceSheetStatusDto} from '../model/BalanceSheetStatus.model';

@Injectable({
  providedIn: 'root'
})
export class BalanceSheetService extends AbstractService<BalanceSheetDto, BalanceSheetCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/balanceSheet/');
    }

    public constrcutDto(): BalanceSheetDto {
        return new BalanceSheetDto();
    }

    public constrcutCriteria(): BalanceSheetCriteria {
        return new BalanceSheetCriteria();
    }
}
