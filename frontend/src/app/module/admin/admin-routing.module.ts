
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';

import { LoginAdminComponent } from './login-admin/login-admin.component';
import { RegisterAdminComponent } from './register-admin/register-admin.component';

@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [
                        {
                            path: 'login',
                            children: [
                                {
                                    path: '',
                                    component: LoginAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                              ]
                        },
                        {
                            path: 'register',
                            children: [
                                {
                                    path: '',
                                    component: RegisterAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                              ]
                        },
                        {

                            path: 'check',
                            loadChildren: () => import('./view/check/check-admin-routing.module').then(x=>x.CheckAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'collaborater',
                            loadChildren: () => import('./view/collaborater/collaborater-admin-routing.module').then(x=>x.CollaboraterAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'vat',
                            loadChildren: () => import('./view/vat/vat-admin-routing.module').then(x=>x.VatAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'purchase',
                            loadChildren: () => import('./view/purchase/purchase-admin-routing.module').then(x=>x.PurchaseAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'is',
                            loadChildren: () => import('./view/is/is-admin-routing.module').then(x=>x.IsAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'subscriber',
                            loadChildren: () => import('./view/subscriber/subscriber-admin-routing.module').then(x=>x.SubscriberAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'demand',
                            loadChildren: () => import('./view/demand/demand-admin-routing.module').then(x=>x.DemandAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'demande',
                            loadChildren: () => import('./view/demande/demande-admin-routing.module').then(x=>x.DemandeAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'reference',
                            loadChildren: () => import('./view/reference/reference-admin-routing.module').then(x=>x.ReferenceAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'sale',
                            loadChildren: () => import('./view/sale/sale-admin-routing.module').then(x=>x.SaleAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'balance',
                            loadChildren: () => import('./view/balance/balance-admin-routing.module').then(x=>x.BalanceAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'referential',
                            loadChildren: () => import('./view/referential/referential-admin-routing.module').then(x=>x.ReferentialAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'accountingref',
                            loadChildren: () => import('./view/accountingref/accountingref-admin-routing.module').then(x=>x.AccountingrefAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'quotation',
                            loadChildren: () => import('./view/quotation/quotation-admin-routing.module').then(x=>x.QuotationAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'order',
                            loadChildren: () => import('./view/order/order-admin-routing.module').then(x=>x.OrderAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                    ]
                },
            ]
        ),
    ],
    exports: [RouterModule],
})
export class AdminRoutingModule { }
