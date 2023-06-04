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
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CalendarModule} from 'primeng/calendar';
import {PanelModule} from 'primeng/panel';
import {InputNumberModule} from 'primeng/inputnumber';
import {BadgeModule} from 'primeng/badge';
import { MultiSelectModule } from 'primeng/multiselect';
import {TranslateModule} from '@ngx-translate/core';
import {FileUploadModule} from "primeng/fileupload";

import { PurchaseCreateAdminComponent } from './purchase-admin/create-admin/purchase-create-admin.component';
import { PurchaseEditAdminComponent } from './purchase-admin/edit-admin/purchase-edit-admin.component';
import { PurchaseViewAdminComponent } from './purchase-admin/view-admin/purchase-view-admin.component';
import { PurchaseListAdminComponent } from './purchase-admin/list-admin/purchase-list-admin.component';
import { PurchasePaymentStatusCreateAdminComponent } from './purchase-payment-status-admin/create-admin/purchase-payment-status-create-admin.component';
import { PurchasePaymentStatusEditAdminComponent } from './purchase-payment-status-admin/edit-admin/purchase-payment-status-edit-admin.component';
import { PurchasePaymentStatusViewAdminComponent } from './purchase-payment-status-admin/view-admin/purchase-payment-status-view-admin.component';
import { PurchasePaymentStatusListAdminComponent } from './purchase-payment-status-admin/list-admin/purchase-payment-status-list-admin.component';
import { PurchaseStatusCreateAdminComponent } from './purchase-status-admin/create-admin/purchase-status-create-admin.component';
import { PurchaseStatusEditAdminComponent } from './purchase-status-admin/edit-admin/purchase-status-edit-admin.component';
import { PurchaseStatusViewAdminComponent } from './purchase-status-admin/view-admin/purchase-status-view-admin.component';
import { PurchaseStatusListAdminComponent } from './purchase-status-admin/list-admin/purchase-status-list-admin.component';
import { CreditNotePurchaseCreateAdminComponent } from './credit-note-purchase-admin/create-admin/credit-note-purchase-create-admin.component';
import { CreditNotePurchaseEditAdminComponent } from './credit-note-purchase-admin/edit-admin/credit-note-purchase-edit-admin.component';
import { CreditNotePurchaseViewAdminComponent } from './credit-note-purchase-admin/view-admin/credit-note-purchase-view-admin.component';
import { CreditNotePurchaseListAdminComponent } from './credit-note-purchase-admin/list-admin/credit-note-purchase-list-admin.component';
import { PaymentPurchaseCreateAdminComponent } from './payment-purchase-admin/create-admin/payment-purchase-create-admin.component';
import { PaymentPurchaseEditAdminComponent } from './payment-purchase-admin/edit-admin/payment-purchase-edit-admin.component';
import { PaymentPurchaseViewAdminComponent } from './payment-purchase-admin/view-admin/payment-purchase-view-admin.component';
import { PaymentPurchaseListAdminComponent } from './payment-purchase-admin/list-admin/payment-purchase-list-admin.component';
import { CreditNotePurchaseStatusCreateAdminComponent } from './credit-note-purchase-status-admin/create-admin/credit-note-purchase-status-create-admin.component';
import { CreditNotePurchaseStatusEditAdminComponent } from './credit-note-purchase-status-admin/edit-admin/credit-note-purchase-status-edit-admin.component';
import { CreditNotePurchaseStatusViewAdminComponent } from './credit-note-purchase-status-admin/view-admin/credit-note-purchase-status-view-admin.component';
import { CreditNotePurchaseStatusListAdminComponent } from './credit-note-purchase-status-admin/list-admin/credit-note-purchase-status-list-admin.component';

import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {TabViewModule} from 'primeng/tabview';
import { SplitButtonModule } from 'primeng/splitbutton';
import { MessageModule } from 'primeng/message';
import {MessagesModule} from 'primeng/messages';
import {PaginatorModule} from 'primeng/paginator';



@NgModule({
  declarations: [

    PurchaseCreateAdminComponent,
    PurchaseListAdminComponent,
    PurchaseViewAdminComponent,
    PurchaseEditAdminComponent,
    PurchasePaymentStatusCreateAdminComponent,
    PurchasePaymentStatusListAdminComponent,
    PurchasePaymentStatusViewAdminComponent,
    PurchasePaymentStatusEditAdminComponent,
    PurchaseStatusCreateAdminComponent,
    PurchaseStatusListAdminComponent,
    PurchaseStatusViewAdminComponent,
    PurchaseStatusEditAdminComponent,
    CreditNotePurchaseCreateAdminComponent,
    CreditNotePurchaseListAdminComponent,
    CreditNotePurchaseViewAdminComponent,
    CreditNotePurchaseEditAdminComponent,
    PaymentPurchaseCreateAdminComponent,
    PaymentPurchaseListAdminComponent,
    PaymentPurchaseViewAdminComponent,
    PaymentPurchaseEditAdminComponent,
    CreditNotePurchaseStatusCreateAdminComponent,
    CreditNotePurchaseStatusListAdminComponent,
    CreditNotePurchaseStatusViewAdminComponent,
    CreditNotePurchaseStatusEditAdminComponent,
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
    PaginatorModule,
    TranslateModule,
    FileUploadModule,
  ],
  exports: [
  PurchaseCreateAdminComponent,
  PurchaseListAdminComponent,
  PurchaseViewAdminComponent,
  PurchaseEditAdminComponent,
  PurchasePaymentStatusCreateAdminComponent,
  PurchasePaymentStatusListAdminComponent,
  PurchasePaymentStatusViewAdminComponent,
  PurchasePaymentStatusEditAdminComponent,
  PurchaseStatusCreateAdminComponent,
  PurchaseStatusListAdminComponent,
  PurchaseStatusViewAdminComponent,
  PurchaseStatusEditAdminComponent,
  CreditNotePurchaseCreateAdminComponent,
  CreditNotePurchaseListAdminComponent,
  CreditNotePurchaseViewAdminComponent,
  CreditNotePurchaseEditAdminComponent,
  PaymentPurchaseCreateAdminComponent,
  PaymentPurchaseListAdminComponent,
  PaymentPurchaseViewAdminComponent,
  PaymentPurchaseEditAdminComponent,
  CreditNotePurchaseStatusCreateAdminComponent,
  CreditNotePurchaseStatusListAdminComponent,
  CreditNotePurchaseStatusViewAdminComponent,
  CreditNotePurchaseStatusEditAdminComponent,
  ],
  entryComponents: [],
})
export class PurchaseAdminModule { }