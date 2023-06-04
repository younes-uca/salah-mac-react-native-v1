import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {DemandDto} from '../model/Demand.model';
import {DemandCriteria} from '../criteria/DemandCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {DemandItemDto} from '../model/DemandItem.model';
import {DemandStatusDto} from '../model/DemandStatus.model';
import {ClientDto} from '../model/Client.model';

@Injectable({
  providedIn: 'root'
})
export class DemandService extends AbstractService<DemandDto, DemandCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/demand/');
    }

    public constrcutDto(): DemandDto {
        return new DemandDto();
    }

    public constrcutCriteria(): DemandCriteria {
        return new DemandCriteria();
    }
}
