import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {SupplierQuoteDto} from '../model/SupplierQuote.model';
import {SupplierQuoteCriteria} from '../criteria/SupplierQuoteCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {SupplierDto} from '../model/Supplier.model';
import {SupplierQuoteItemDto} from '../model/SupplierQuoteItem.model';

@Injectable({
  providedIn: 'root'
})
export class SupplierQuoteService extends AbstractService<SupplierQuoteDto, SupplierQuoteCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/supplierQuote/');
    }

    public constrcutDto(): SupplierQuoteDto {
        return new SupplierQuoteDto();
    }

    public constrcutCriteria(): SupplierQuoteCriteria {
        return new SupplierQuoteCriteria();
    }
}
