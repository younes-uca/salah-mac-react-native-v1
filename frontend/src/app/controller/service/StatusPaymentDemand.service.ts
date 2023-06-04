import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {StatusPaymentDemandDto} from '../model/StatusPaymentDemand.model';
import {StatusPaymentDemandCriteria} from '../criteria/StatusPaymentDemandCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class StatusPaymentDemandService extends AbstractService<StatusPaymentDemandDto, StatusPaymentDemandCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/statusPaymentDemand/');
    }

    public constrcutDto(): StatusPaymentDemandDto {
        return new StatusPaymentDemandDto();
    }

    public constrcutCriteria(): StatusPaymentDemandCriteria {
        return new StatusPaymentDemandCriteria();
    }
}
