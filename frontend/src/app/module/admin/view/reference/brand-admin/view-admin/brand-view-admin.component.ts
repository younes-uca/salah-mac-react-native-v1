import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {BrandService} from 'src/app/controller/service/Brand.service';
import {BrandDto} from 'src/app/controller/model/Brand.model';
import {BrandCriteria} from 'src/app/controller/criteria/BrandCriteria.model';

@Component({
  selector: 'app-brand-view-admin',
  templateUrl: './brand-view-admin.component.html'
})
export class BrandViewAdminComponent extends AbstractViewController<BrandDto, BrandCriteria, BrandService> implements OnInit {


    constructor(private brandService: BrandService){
        super(brandService);
    }

    ngOnInit(): void {
    }




}
