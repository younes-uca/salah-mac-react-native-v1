
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { CheckOwnerListAdminComponent } from './check-owner-admin/list-admin/check-owner-list-admin.component';
import { BankCheckOwnerListAdminComponent } from './bank-check-owner-admin/list-admin/bank-check-owner-list-admin.component';
import { BankListAdminComponent } from './bank-admin/list-admin/bank-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'check-owner',
                            children: [
                                {
                                    path: 'list',
                                    component: CheckOwnerListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'bank-check-owner',
                            children: [
                                {
                                    path: 'list',
                                    component: BankCheckOwnerListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'bank',
                            children: [
                                {
                                    path: 'list',
                                    component: BankListAdminComponent ,
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
export class CheckAdminRoutingModule { }
