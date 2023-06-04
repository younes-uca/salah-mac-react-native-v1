import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ValidationAccountantDto} from '../model/ValidationAccountant.model';
import {ValidationAccountantCriteria} from '../criteria/ValidationAccountantCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class ValidationAccountantService extends AbstractService<ValidationAccountantDto, ValidationAccountantCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/validationAccountant/');
    }

    public constrcutDto(): ValidationAccountantDto {
        return new ValidationAccountantDto();
    }

    public constrcutCriteria(): ValidationAccountantCriteria {
        return new ValidationAccountantCriteria();
    }
}
