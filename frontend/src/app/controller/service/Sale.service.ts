import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {SaleDto} from '../model/Sale.model';
import {SaleCriteria} from '../criteria/SaleCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {SaleItemDto} from '../model/SaleItem.model';
import {StoreDto} from '../model/Store.model';
import {SaleStatusDto} from '../model/SaleStatus.model';
import {ClientDto} from '../model/Client.model';

@Injectable({
  providedIn: 'root'
})
export class SaleService extends AbstractService<SaleDto, SaleCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/sale/');
    }

    public constrcutDto(): SaleDto {
        return new SaleDto();
    }

    public constrcutCriteria(): SaleCriteria {
        return new SaleCriteria();
    }
}
