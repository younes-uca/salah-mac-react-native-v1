import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {PaymentSaleDto} from '../model/PaymentSale.model';
import {PaymentSaleCriteria} from '../criteria/PaymentSaleCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {SaleDto} from '../model/Sale.model';
import {PaymentStatusDto} from '../model/PaymentStatus.model';
import {PaymentMethodDto} from '../model/PaymentMethod.model';

@Injectable({
  providedIn: 'root'
})
export class PaymentSaleService extends AbstractService<PaymentSaleDto, PaymentSaleCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/paymentSale/');
    }

    public constrcutDto(): PaymentSaleDto {
        return new PaymentSaleDto();
    }

    public constrcutCriteria(): PaymentSaleCriteria {
        return new PaymentSaleCriteria();
    }
}
