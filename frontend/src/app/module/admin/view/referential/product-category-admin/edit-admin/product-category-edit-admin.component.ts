import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {ProductCategoryService} from 'src/app/controller/service/ProductCategory.service';
import {ProductCategoryDto} from 'src/app/controller/model/ProductCategory.model';
import {ProductCategoryCriteria} from 'src/app/controller/criteria/ProductCategoryCriteria.model';



@Component({
  selector: 'app-product-category-edit-admin',
  templateUrl: './product-category-edit-admin.component.html'
})
export class ProductCategoryEditAdminComponent extends AbstractEditController<ProductCategoryDto, ProductCategoryCriteria, ProductCategoryService>   implements OnInit {






    constructor( private productCategoryService: ProductCategoryService ) {
        super(productCategoryService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }







}
