import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ReturnSaleDto} from '../model/ReturnSale.model';
import {ReturnSaleCriteria} from '../criteria/ReturnSaleCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {SaleDto} from '../model/Sale.model';
import {ReturnSaleItemDto} from '../model/ReturnSaleItem.model';
import {ReturnStatusDto} from '../model/ReturnStatus.model';

@Injectable({
  providedIn: 'root'
})
export class ReturnSaleService extends AbstractService<ReturnSaleDto, ReturnSaleCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/returnSale/');
    }

    public constrcutDto(): ReturnSaleDto {
        return new ReturnSaleDto();
    }

    public constrcutCriteria(): ReturnSaleCriteria {
        return new ReturnSaleCriteria();
    }
}
