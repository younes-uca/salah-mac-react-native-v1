
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { ReceptionStatusListAdminComponent } from './reception-status-admin/list-admin/reception-status-list-admin.component';
import { OrderListAdminComponent } from './order-admin/list-admin/order-list-admin.component';
import { ReceptionListAdminComponent } from './reception-admin/list-admin/reception-list-admin.component';
import { OrderStatusListAdminComponent } from './order-status-admin/list-admin/order-status-list-admin.component';
import { OrderStatusOrderListAdminComponent } from './order-status-order-admin/list-admin/order-status-order-list-admin.component';
import { OrderPaymentListAdminComponent } from './order-payment-admin/list-admin/order-payment-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'reception-status',
                            children: [
                                {
                                    path: 'list',
                                    component: ReceptionStatusListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'order',
                            children: [
                                {
                                    path: 'list',
                                    component: OrderListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'reception',
                            children: [
                                {
                                    path: 'list',
                                    component: ReceptionListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'order-status',
                            children: [
                                {
                                    path: 'list',
                                    component: OrderStatusListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'order-status-order',
                            children: [
                                {
                                    path: 'list',
                                    component: OrderStatusOrderListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'order-payment',
                            children: [
                                {
                                    path: 'list',
                                    component: OrderPaymentListAdminComponent ,
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
export class OrderAdminRoutingModule { }
