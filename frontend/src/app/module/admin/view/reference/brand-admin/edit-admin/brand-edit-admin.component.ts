import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {BrandService} from 'src/app/controller/service/Brand.service';
import {BrandDto} from 'src/app/controller/model/Brand.model';
import {BrandCriteria} from 'src/app/controller/criteria/BrandCriteria.model';



@Component({
  selector: 'app-brand-edit-admin',
  templateUrl: './brand-edit-admin.component.html'
})
export class BrandEditAdminComponent extends AbstractEditController<BrandDto, BrandCriteria, BrandService>   implements OnInit {






    constructor( private brandService: BrandService ) {
        super(brandService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }







}
