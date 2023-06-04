
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { LatePaymentRateListAdminComponent } from './late-payment-rate-admin/list-admin/late-payment-rate-list-admin.component';
import { VatDeclarationListAdminComponent } from './vat-declaration-admin/list-admin/vat-declaration-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'late-payment-rate',
                            children: [
                                {
                                    path: 'list',
                                    component: LatePaymentRateListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'vat-declaration',
                            children: [
                                {
                                    path: 'list',
                                    component: VatDeclarationListAdminComponent ,
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
export class VatAdminRoutingModule { }
