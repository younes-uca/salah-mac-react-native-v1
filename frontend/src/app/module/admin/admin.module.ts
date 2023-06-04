import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {ToastModule} from 'primeng/toast';
import {ToolbarModule} from 'primeng/toolbar';
import {TableModule} from 'primeng/table';
import {DropdownModule} from 'primeng/dropdown';
import {InputSwitchModule} from 'primeng/inputswitch';
import {InputTextareaModule} from 'primeng/inputtextarea';

import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { DialogModule } from 'primeng/dialog';
import { LoginAdminComponent } from './login-admin/login-admin.component';
import { RegisterAdminComponent } from './register-admin/register-admin.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CalendarModule} from 'primeng/calendar';
import {PanelModule} from 'primeng/panel';
import {InputNumberModule} from 'primeng/inputnumber';
import {BadgeModule} from 'primeng/badge';
import { MultiSelectModule } from 'primeng/multiselect';
import { CheckAdminModule } from './view/check/check-admin.module';
import { CheckAdminRoutingModule } from './view/check/check-admin-routing.module';
import { CollaboraterAdminModule } from './view/collaborater/collaborater-admin.module';
import { CollaboraterAdminRoutingModule } from './view/collaborater/collaborater-admin-routing.module';
import { VatAdminModule } from './view/vat/vat-admin.module';
import { VatAdminRoutingModule } from './view/vat/vat-admin-routing.module';
import { PurchaseAdminModule } from './view/purchase/purchase-admin.module';
import { PurchaseAdminRoutingModule } from './view/purchase/purchase-admin-routing.module';
import { IsAdminModule } from './view/is/is-admin.module';
import { IsAdminRoutingModule } from './view/is/is-admin-routing.module';
import { SubscriberAdminModule } from './view/subscriber/subscriber-admin.module';
import { SubscriberAdminRoutingModule } from './view/subscriber/subscriber-admin-routing.module';
import { DemandAdminModule } from './view/demand/demand-admin.module';
import { DemandAdminRoutingModule } from './view/demand/demand-admin-routing.module';
import { DemandeAdminModule } from './view/demande/demande-admin.module';
import { DemandeAdminRoutingModule } from './view/demande/demande-admin-routing.module';
import { ReferenceAdminModule } from './view/reference/reference-admin.module';
import { ReferenceAdminRoutingModule } from './view/reference/reference-admin-routing.module';
import { SaleAdminModule } from './view/sale/sale-admin.module';
import { SaleAdminRoutingModule } from './view/sale/sale-admin-routing.module';
import { BalanceAdminModule } from './view/balance/balance-admin.module';
import { BalanceAdminRoutingModule } from './view/balance/balance-admin-routing.module';
import { ReferentialAdminModule } from './view/referential/referential-admin.module';
import { ReferentialAdminRoutingModule } from './view/referential/referential-admin-routing.module';
import { AccountingrefAdminModule } from './view/accountingref/accountingref-admin.module';
import { AccountingrefAdminRoutingModule } from './view/accountingref/accountingref-admin-routing.module';
import { QuotationAdminModule } from './view/quotation/quotation-admin.module';
import { QuotationAdminRoutingModule } from './view/quotation/quotation-admin-routing.module';
import { OrderAdminModule } from './view/order/order-admin.module';
import { OrderAdminRoutingModule } from './view/order/order-admin-routing.module';


import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {TabViewModule} from 'primeng/tabview';
import { SplitButtonModule } from 'primeng/splitbutton';
import { MessageModule } from 'primeng/message';
import {MessagesModule} from 'primeng/messages';


@NgModule({
  declarations: [
   LoginAdminComponent,
   RegisterAdminComponent
  ],
  imports: [
    CommonModule,
    ToastModule,
    ToolbarModule,
    TableModule,
    ConfirmDialogModule,
    DialogModule,
    PasswordModule,
    InputTextModule,
    ButtonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    SplitButtonModule,
    BrowserAnimationsModule,
    DropdownModule,
    TabViewModule,
    InputSwitchModule,
    InputTextareaModule,
    CalendarModule,
    PanelModule,
    MessageModule,
    MessagesModule,
    InputNumberModule,
    BadgeModule,
    MultiSelectModule,
  CheckAdminModule,
  CheckAdminRoutingModule,
  CollaboraterAdminModule,
  CollaboraterAdminRoutingModule,
  VatAdminModule,
  VatAdminRoutingModule,
  PurchaseAdminModule,
  PurchaseAdminRoutingModule,
  IsAdminModule,
  IsAdminRoutingModule,
  SubscriberAdminModule,
  SubscriberAdminRoutingModule,
  DemandAdminModule,
  DemandAdminRoutingModule,
  DemandeAdminModule,
  DemandeAdminRoutingModule,
  ReferenceAdminModule,
  ReferenceAdminRoutingModule,
  SaleAdminModule,
  SaleAdminRoutingModule,
  BalanceAdminModule,
  BalanceAdminRoutingModule,
  ReferentialAdminModule,
  ReferentialAdminRoutingModule,
  AccountingrefAdminModule,
  AccountingrefAdminRoutingModule,
  QuotationAdminModule,
  QuotationAdminRoutingModule,
  OrderAdminModule,
  OrderAdminRoutingModule,
  ],
  exports: [
  LoginAdminComponent,
  RegisterAdminComponent,

    CheckAdminModule,
    CollaboraterAdminModule,
    VatAdminModule,
    PurchaseAdminModule,
    IsAdminModule,
    SubscriberAdminModule,
    DemandAdminModule,
    DemandeAdminModule,
    ReferenceAdminModule,
    SaleAdminModule,
    BalanceAdminModule,
    ReferentialAdminModule,
    AccountingrefAdminModule,
    QuotationAdminModule,
    OrderAdminModule,
  ],
  entryComponents: [],
})
export class AdminModule { }
