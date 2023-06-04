import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {SaleStatusDto} from '../model/SaleStatus.model';
import {SaleStatusCriteria} from '../criteria/SaleStatusCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class SaleStatusService extends AbstractService<SaleStatusDto, SaleStatusCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/saleStatus/');
    }

    public constrcutDto(): SaleStatusDto {
        return new SaleStatusDto();
    }

    public constrcutCriteria(): SaleStatusCriteria {
        return new SaleStatusCriteria();
    }
}
