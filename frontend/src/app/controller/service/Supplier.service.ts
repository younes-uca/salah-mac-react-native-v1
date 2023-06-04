import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {SupplierDto} from '../model/Supplier.model';
import {SupplierCriteria} from '../criteria/SupplierCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class SupplierService extends AbstractService<SupplierDto, SupplierCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/supplier/');
    }

    public constrcutDto(): SupplierDto {
        return new SupplierDto();
    }

    public constrcutCriteria(): SupplierCriteria {
        return new SupplierCriteria();
    }
}
