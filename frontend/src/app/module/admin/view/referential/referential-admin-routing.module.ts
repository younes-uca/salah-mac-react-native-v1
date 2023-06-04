
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { ProductListAdminComponent } from './product-admin/list-admin/product-list-admin.component';
import { ProductStockListAdminComponent } from './product-stock-admin/list-admin/product-stock-list-admin.component';
import { ProductCategoryListAdminComponent } from './product-category-admin/list-admin/product-category-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'product',
                            children: [
                                {
                                    path: 'list',
                                    component: ProductListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'product-stock',
                            children: [
                                {
                                    path: 'list',
                                    component: ProductStockListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'product-category',
                            children: [
                                {
                                    path: 'list',
                                    component: ProductCategoryListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                    ]
                },
            ]
        ),
    ],
    exports: [RouterModule],
})
export class ReferentialAdminRoutingModule { }
