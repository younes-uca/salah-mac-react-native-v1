import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {HandlingAccountantDto} from '../model/HandlingAccountant.model';
import {HandlingAccountantCriteria} from '../criteria/HandlingAccountantCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class HandlingAccountantService extends AbstractService<HandlingAccountantDto, HandlingAccountantCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/handlingAccountant/');
    }

    public constrcutDto(): HandlingAccountantDto {
        return new HandlingAccountantDto();
    }

    public constrcutCriteria(): HandlingAccountantCriteria {
        return new HandlingAccountantCriteria();
    }
}
