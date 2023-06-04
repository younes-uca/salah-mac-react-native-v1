import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {SubscriberDto} from '../model/Subscriber.model';
import {SubscriberCriteria} from '../criteria/SubscriberCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {CompanyDto} from '../model/Company.model';

@Injectable({
  providedIn: 'root'
})
export class SubscriberService extends AbstractService<SubscriberDto, SubscriberCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/subscriber/');
    }

    public constrcutDto(): SubscriberDto {
        return new SubscriberDto();
    }

    public constrcutCriteria(): SubscriberCriteria {
        return new SubscriberCriteria();
    }
}
