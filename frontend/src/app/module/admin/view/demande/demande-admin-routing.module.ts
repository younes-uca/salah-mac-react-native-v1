
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { StatusPaymentDemandListAdminComponent } from './status-payment-demand-admin/list-admin/status-payment-demand-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'status-payment-demand',
                            children: [
                                {
                                    path: 'list',
                                    component: StatusPaymentDemandListAdminComponent ,
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
export class DemandeAdminRoutingModule { }
