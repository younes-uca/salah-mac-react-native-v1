import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {PaymentModeDto} from '../model/PaymentMode.model';
import {PaymentModeCriteria} from '../criteria/PaymentModeCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class PaymentModeService extends AbstractService<PaymentModeDto, PaymentModeCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/paymentMode/');
    }

    public constrcutDto(): PaymentModeDto {
        return new PaymentModeDto();
    }

    public constrcutCriteria(): PaymentModeCriteria {
        return new PaymentModeCriteria();
    }
}
