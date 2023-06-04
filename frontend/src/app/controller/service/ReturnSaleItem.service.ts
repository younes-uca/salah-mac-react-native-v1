import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ReturnSaleItemDto} from '../model/ReturnSaleItem.model';
import {ReturnSaleItemCriteria} from '../criteria/ReturnSaleItemCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {ReturnSaleDto} from '../model/ReturnSale.model';
import {ProductDto} from '../model/Product.model';

@Injectable({
  providedIn: 'root'
})
export class ReturnSaleItemService extends AbstractService<ReturnSaleItemDto, ReturnSaleItemCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/returnSaleItem/');
    }

    public constrcutDto(): ReturnSaleItemDto {
        return new ReturnSaleItemDto();
    }

    public constrcutCriteria(): ReturnSaleItemCriteria {
        return new ReturnSaleItemCriteria();
    }
}
