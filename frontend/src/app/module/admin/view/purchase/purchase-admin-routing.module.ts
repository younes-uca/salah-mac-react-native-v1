
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { PurchaseListAdminComponent } from './purchase-admin/list-admin/purchase-list-admin.component';
import { PurchasePaymentStatusListAdminComponent } from './purchase-payment-status-admin/list-admin/purchase-payment-status-list-admin.component';
import { PurchaseStatusListAdminComponent } from './purchase-status-admin/list-admin/purchase-status-list-admin.component';
import { CreditNotePurchaseListAdminComponent } from './credit-note-purchase-admin/list-admin/credit-note-purchase-list-admin.component';
import { PaymentPurchaseListAdminComponent } from './payment-purchase-admin/list-admin/payment-purchase-list-admin.component';
import { CreditNotePurchaseStatusListAdminComponent } from './credit-note-purchase-status-admin/list-admin/credit-note-purchase-status-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'purchase',
                            children: [
                                {
                                    path: 'list',
                                    component: PurchaseListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'purchase-payment-status',
                            children: [
                                {
                                    path: 'list',
                                    component: PurchasePaymentStatusListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'purchase-status',
                            children: [
                                {
                                    path: 'list',
                                    component: PurchaseStatusListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'credit-note-purchase',
                            children: [
                                {
                                    path: 'list',
                                    component: CreditNotePurchaseListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'payment-purchase',
                            children: [
                                {
                                    path: 'list',
                                    component: PaymentPurchaseListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'credit-note-purchase-status',
                            children: [
                                {
                                    path: 'list',
                                    component: CreditNotePurchaseStatusListAdminComponent ,
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
export class PurchaseAdminRoutingModule { }
