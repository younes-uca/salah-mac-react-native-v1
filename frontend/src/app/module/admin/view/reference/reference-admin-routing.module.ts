
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { BrandListAdminComponent } from './brand-admin/list-admin/brand-list-admin.component';
import { MeasurementUnitListAdminComponent } from './measurement-unit-admin/list-admin/measurement-unit-list-admin.component';
import { PaymentModeListAdminComponent } from './payment-mode-admin/list-admin/payment-mode-list-admin.component';
import { PaymentMethodListAdminComponent } from './payment-method-admin/list-admin/payment-method-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'brand',
                            children: [
                                {
                                    path: 'list',
                                    component: BrandListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'measurement-unit',
                            children: [
                                {
                                    path: 'list',
                                    component: MeasurementUnitListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'payment-mode',
                            children: [
                                {
                                    path: 'list',
                                    component: PaymentModeListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'payment-method',
                            children: [
                                {
                                    path: 'list',
                                    component: PaymentMethodListAdminComponent ,
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
export class ReferenceAdminRoutingModule { }
