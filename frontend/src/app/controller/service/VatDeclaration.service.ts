import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {VatDeclarationDto} from '../model/VatDeclaration.model';
import {VatDeclarationCriteria} from '../criteria/VatDeclarationCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {HandlingAccountantDto} from '../model/HandlingAccountant.model';
import {CompanyDto} from '../model/Company.model';
import {LatePaymentRateDto} from '../model/LatePaymentRate.model';
import {ValidationAccountantDto} from '../model/ValidationAccountant.model';

@Injectable({
  providedIn: 'root'
})
export class VatDeclarationService extends AbstractService<VatDeclarationDto, VatDeclarationCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/vatDeclaration/');
    }

    public constrcutDto(): VatDeclarationDto {
        return new VatDeclarationDto();
    }

    public constrcutCriteria(): VatDeclarationCriteria {
        return new VatDeclarationCriteria();
    }
}
