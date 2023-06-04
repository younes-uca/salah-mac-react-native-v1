import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ReceptionStatusDto} from '../model/ReceptionStatus.model';
import {ReceptionStatusCriteria} from '../criteria/ReceptionStatusCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class ReceptionStatusService extends AbstractService<ReceptionStatusDto, ReceptionStatusCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/receptionStatus/');
    }

    public constrcutDto(): ReceptionStatusDto {
        return new ReceptionStatusDto();
    }

    public constrcutCriteria(): ReceptionStatusCriteria {
        return new ReceptionStatusCriteria();
    }
}
