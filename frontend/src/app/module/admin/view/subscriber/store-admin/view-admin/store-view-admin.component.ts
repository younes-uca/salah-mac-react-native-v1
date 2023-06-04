import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {StoreService} from 'src/app/controller/service/Store.service';
import {StoreDto} from 'src/app/controller/model/Store.model';
import {StoreCriteria} from 'src/app/controller/criteria/StoreCriteria.model';

import {CompanyDto} from 'src/app/controller/model/Company.model';
import {CompanyService} from 'src/app/controller/service/Company.service';
@Component({
  selector: 'app-store-view-admin',
  templateUrl: './store-view-admin.component.html'
})
export class StoreViewAdminComponent extends AbstractViewController<StoreDto, StoreCriteria, StoreService> implements OnInit {


    constructor(private storeService: StoreService, private companyService: CompanyService){
        super(storeService);
    }

    ngOnInit(): void {
        this.company = new CompanyDto();
        this.companyService.findAll().subscribe((data) => this.companys = data);
    }


    get company(): CompanyDto {
       return this.companyService.item;
    }
    set company(value: CompanyDto) {
        this.companyService.item = value;
    }
    get companys():Array<CompanyDto> {
       return this.companyService.items;
    }
    set companys(value: Array<CompanyDto>) {
        this.companyService.items = value;
    }


}
