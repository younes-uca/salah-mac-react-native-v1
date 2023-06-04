import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {ProductCategoryService} from 'src/app/controller/service/ProductCategory.service';
import {ProductCategoryDto} from 'src/app/controller/model/ProductCategory.model';
import {ProductCategoryCriteria} from 'src/app/controller/criteria/ProductCategoryCriteria.model';
@Component({
  selector: 'app-product-category-create-admin',
  templateUrl: './product-category-create-admin.component.html'
})
export class ProductCategoryCreateAdminComponent extends AbstractCreateController<ProductCategoryDto, ProductCategoryCriteria, ProductCategoryService>  implements OnInit {




    constructor( private productCategoryService: ProductCategoryService ) {
        super(productCategoryService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }










}
