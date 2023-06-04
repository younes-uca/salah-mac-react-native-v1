
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { AccountingOperationListAdminComponent } from './accounting-operation-admin/list-admin/accounting-operation-list-admin.component';
import { BalanceSheetStatusListAdminComponent } from './balance-sheet-status-admin/list-admin/balance-sheet-status-list-admin.component';
import { BalanceSheetListAdminComponent } from './balance-sheet-admin/list-admin/balance-sheet-list-admin.component';
import { AccountingOperationStatusListAdminComponent } from './accounting-operation-status-admin/list-admin/accounting-operation-status-list-admin.component';
import { AccountingAccountListAdminComponent } from './accounting-account-admin/list-admin/accounting-account-list-admin.component';
import { SubAccountingClassListAdminComponent } from './sub-accounting-class-admin/list-admin/sub-accounting-class-list-admin.component';
import { AccountingClassListAdminComponent } from './accounting-class-admin/list-admin/accounting-class-list-admin.component';
import { AccountingOperationTypeListAdminComponent } from './accounting-operation-type-admin/list-admin/accounting-operation-type-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'accounting-operation',
                            children: [
                                {
                                    path: 'list',
                                    component: AccountingOperationListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'balance-sheet-status',
                            children: [
                                {
                                    path: 'list',
                                    component: BalanceSheetStatusListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'balance-sheet',
                            children: [
                                {
                                    path: 'list',
                                    component: BalanceSheetListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'accounting-operation-status',
                            children: [
                                {
                                    path: 'list',
                                    component: AccountingOperationStatusListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'accounting-account',
                            children: [
                                {
                                    path: 'list',
                                    component: AccountingAccountListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'sub-accounting-class',
                            children: [
                                {
                                    path: 'list',
                                    component: SubAccountingClassListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'accounting-class',
                            children: [
                                {
                                    path: 'list',
                                    component: AccountingClassListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'accounting-operation-type',
                            children: [
                                {
                                    path: 'list',
                                    component: AccountingOperationTypeListAdminComponent ,
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
export class BalanceAdminRoutingModule { }
