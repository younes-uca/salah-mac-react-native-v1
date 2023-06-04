import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ShopDto} from '../model/Shop.model';
import {ShopCriteria} from '../criteria/ShopCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {StoreDto} from '../model/Store.model';

@Injectable({
  providedIn: 'root'
})
export class ShopService extends AbstractService<ShopDto, ShopCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/shop/');
    }

    public constrcutDto(): ShopDto {
        return new ShopDto();
    }

    public constrcutCriteria(): ShopCriteria {
        return new ShopCriteria();
    }
}
