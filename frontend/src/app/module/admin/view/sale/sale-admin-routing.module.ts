
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { ReturnStatusListAdminComponent } from './return-status-admin/list-admin/return-status-list-admin.component';
import { SaleStatusListAdminComponent } from './sale-status-admin/list-admin/sale-status-list-admin.component';
import { PaymentSaleListAdminComponent } from './payment-sale-admin/list-admin/payment-sale-list-admin.component';
import { PaymentStatusListAdminComponent } from './payment-status-admin/list-admin/payment-status-list-admin.component';
import { SaleListAdminComponent } from './sale-admin/list-admin/sale-list-admin.component';
import { ReturnSaleListAdminComponent } from './return-sale-admin/list-admin/return-sale-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'return-status',
                            children: [
                                {
                                    path: 'list',
                                    component: ReturnStatusListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'sale-status',
                            children: [
                                {
                                    path: 'list',
                                    component: SaleStatusListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'payment-sale',
                            children: [
                                {
                                    path: 'list',
                                    component: PaymentSaleListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'payment-status',
                            children: [
                                {
                                    path: 'list',
                                    component: PaymentStatusListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'sale',
                            children: [
                                {
                                    path: 'list',
                                    component: SaleListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'return-sale',
                            children: [
                                {
                                    path: 'list',
                                    component: ReturnSaleListAdminComponent ,
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
export class SaleAdminRoutingModule { }
