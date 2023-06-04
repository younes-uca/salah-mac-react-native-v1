import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {LatePaymentRateDto} from '../model/LatePaymentRate.model';
import {LatePaymentRateCriteria} from '../criteria/LatePaymentRateCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class LatePaymentRateService extends AbstractService<LatePaymentRateDto, LatePaymentRateCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/latePaymentRate/');
    }

    public constrcutDto(): LatePaymentRateDto {
        return new LatePaymentRateDto();
    }

    public constrcutCriteria(): LatePaymentRateCriteria {
        return new LatePaymentRateCriteria();
    }
}
