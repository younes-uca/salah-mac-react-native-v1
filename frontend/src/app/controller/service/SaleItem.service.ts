import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {SaleItemDto} from '../model/SaleItem.model';
import {SaleItemCriteria} from '../criteria/SaleItemCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {SaleDto} from '../model/Sale.model';
import {ProductDto} from '../model/Product.model';

@Injectable({
  providedIn: 'root'
})
export class SaleItemService extends AbstractService<SaleItemDto, SaleItemCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/saleItem/');
    }

    public constrcutDto(): SaleItemDto {
        return new SaleItemDto();
    }

    public constrcutCriteria(): SaleItemCriteria {
        return new SaleItemCriteria();
    }
}
