import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {CompanyDto} from '../model/Company.model';
import {CompanyCriteria} from '../criteria/CompanyCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {StoreDto} from '../model/Store.model';
import {SubscriberDto} from '../model/Subscriber.model';

@Injectable({
  providedIn: 'root'
})
export class CompanyService extends AbstractService<CompanyDto, CompanyCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/company/');
    }

    public constrcutDto(): CompanyDto {
        return new CompanyDto();
    }

    public constrcutCriteria(): CompanyCriteria {
        return new CompanyCriteria();
    }
}
