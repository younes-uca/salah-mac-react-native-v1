
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { SubscriberListAdminComponent } from './subscriber-admin/list-admin/subscriber-list-admin.component';
import { ShopListAdminComponent } from './shop-admin/list-admin/shop-list-admin.component';
import { CompanyListAdminComponent } from './company-admin/list-admin/company-list-admin.component';
import { StoreListAdminComponent } from './store-admin/list-admin/store-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'subscriber',
                            children: [
                                {
                                    path: 'list',
                                    component: SubscriberListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'shop',
                            children: [
                                {
                                    path: 'list',
                                    component: ShopListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'company',
                            children: [
                                {
                                    path: 'list',
                                    component: CompanyListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'store',
                            children: [
                                {
                                    path: 'list',
                                    component: StoreListAdminComponent ,
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
export class SubscriberAdminRoutingModule { }
