import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {BrandService} from 'src/app/controller/service/Brand.service';
import {BrandDto} from 'src/app/controller/model/Brand.model';
import {BrandCriteria} from 'src/app/controller/criteria/BrandCriteria.model';
@Component({
  selector: 'app-brand-create-admin',
  templateUrl: './brand-create-admin.component.html'
})
export class BrandCreateAdminComponent extends AbstractCreateController<BrandDto, BrandCriteria, BrandService>  implements OnInit {




    constructor( private brandService: BrandService ) {
        super(brandService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }










}
