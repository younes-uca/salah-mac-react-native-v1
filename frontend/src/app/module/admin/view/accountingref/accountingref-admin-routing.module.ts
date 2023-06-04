
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { ValidationAccountantListAdminComponent } from './validation-accountant-admin/list-admin/validation-accountant-list-admin.component';
import { HandlingAccountantListAdminComponent } from './handling-accountant-admin/list-admin/handling-accountant-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'validation-accountant',
                            children: [
                                {
                                    path: 'list',
                                    component: ValidationAccountantListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'handling-accountant',
                            children: [
                                {
                                    path: 'list',
                                    component: HandlingAccountantListAdminComponent ,
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
export class AccountingrefAdminRoutingModule { }
