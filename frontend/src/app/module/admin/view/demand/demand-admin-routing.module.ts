
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { PaymentDeliveryStatusListAdminComponent } from './payment-delivery-status-admin/list-admin/payment-delivery-status-list-admin.component';
import { DemandStatusListAdminComponent } from './demand-status-admin/list-admin/demand-status-list-admin.component';
import { DeliveryStatusListAdminComponent } from './delivery-status-admin/list-admin/delivery-status-list-admin.component';
import { DemandPaymentListAdminComponent } from './demand-payment-admin/list-admin/demand-payment-list-admin.component';
import { DemandListAdminComponent } from './demand-admin/list-admin/demand-list-admin.component';
import { DeliveryListAdminComponent } from './delivery-admin/list-admin/delivery-list-admin.component';
import { PaymentDeliveryListAdminComponent } from './payment-delivery-admin/list-admin/payment-delivery-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'payment-delivery-status',
                            children: [
                                {
                                    path: 'list',
                                    component: PaymentDeliveryStatusListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'demand-status',
                            children: [
                                {
                                    path: 'list',
                                    component: DemandStatusListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'delivery-status',
                            children: [
                                {
                                    path: 'list',
                                    component: DeliveryStatusListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'demand-payment',
                            children: [
                                {
                                    path: 'list',
                                    component: DemandPaymentListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'demand',
                            children: [
                                {
                                    path: 'list',
                                    component: DemandListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'delivery',
                            children: [
                                {
                                    path: 'list',
                                    component: DeliveryListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'payment-delivery',
                            children: [
                                {
                                    path: 'list',
                                    component: PaymentDeliveryListAdminComponent ,
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
export class DemandAdminRoutingModule { }
