import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ProductStockDto} from '../model/ProductStock.model';
import {ProductStockCriteria} from '../criteria/ProductStockCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {ShopDto} from '../model/Shop.model';
import {ProductDto} from '../model/Product.model';

@Injectable({
  providedIn: 'root'
})
export class ProductStockService extends AbstractService<ProductStockDto, ProductStockCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/productStock/');
    }

    public constrcutDto(): ProductStockDto {
        return new ProductStockDto();
    }

    public constrcutCriteria(): ProductStockCriteria {
        return new ProductStockCriteria();
    }
}
