import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {BalanceSheetStatusDto} from '../model/BalanceSheetStatus.model';
import {BalanceSheetStatusCriteria} from '../criteria/BalanceSheetStatusCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class BalanceSheetStatusService extends AbstractService<BalanceSheetStatusDto, BalanceSheetStatusCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/balanceSheetStatus/');
    }

    public constrcutDto(): BalanceSheetStatusDto {
        return new BalanceSheetStatusDto();
    }

    public constrcutCriteria(): BalanceSheetStatusCriteria {
        return new BalanceSheetStatusCriteria();
    }
}
