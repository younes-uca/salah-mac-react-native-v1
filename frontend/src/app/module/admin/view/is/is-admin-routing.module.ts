
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { CorporateTaxRateListAdminComponent } from './corporate-tax-rate-admin/list-admin/corporate-tax-rate-list-admin.component';
import { IncomeStatementDeclarationListAdminComponent } from './income-statement-declaration-admin/list-admin/income-statement-declaration-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'corporate-tax-rate',
                            children: [
                                {
                                    path: 'list',
                                    component: CorporateTaxRateListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'income-statement-declaration',
                            children: [
                                {
                                    path: 'list',
                                    component: IncomeStatementDeclarationListAdminComponent ,
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
export class IsAdminRoutingModule { }
