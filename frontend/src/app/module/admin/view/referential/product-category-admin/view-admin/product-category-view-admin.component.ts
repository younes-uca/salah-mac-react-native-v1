import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ProductCategoryService} from 'src/app/controller/service/ProductCategory.service';
import {ProductCategoryDto} from 'src/app/controller/model/ProductCategory.model';
import {ProductCategoryCriteria} from 'src/app/controller/criteria/ProductCategoryCriteria.model';

@Component({
  selector: 'app-product-category-view-admin',
  templateUrl: './product-category-view-admin.component.html'
})
export class ProductCategoryViewAdminComponent extends AbstractViewController<ProductCategoryDto, ProductCategoryCriteria, ProductCategoryService> implements OnInit {


    constructor(private productCategoryService: ProductCategoryService){
        super(productCategoryService);
    }

    ngOnInit(): void {
    }




}
