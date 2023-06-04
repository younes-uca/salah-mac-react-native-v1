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

import { ReturnStatusCreateAdminComponent } from './return-status-admin/create-admin/return-status-create-admin.component';
import { ReturnStatusEditAdminComponent } from './return-status-admin/edit-admin/return-status-edit-admin.component';
import { ReturnStatusViewAdminComponent } from './return-status-admin/view-admin/return-status-view-admin.component';
import { ReturnStatusListAdminComponent } from './return-status-admin/list-admin/return-status-list-admin.component';
import { SaleStatusCreateAdminComponent } from './sale-status-admin/create-admin/sale-status-create-admin.component';
import { SaleStatusEditAdminComponent } from './sale-status-admin/edit-admin/sale-status-edit-admin.component';
import { SaleStatusViewAdminComponent } from './sale-status-admin/view-admin/sale-status-view-admin.component';
import { SaleStatusListAdminComponent } from './sale-status-admin/list-admin/sale-status-list-admin.component';
import { PaymentSaleCreateAdminComponent } from './payment-sale-admin/create-admin/payment-sale-create-admin.component';
import { PaymentSaleEditAdminComponent } from './payment-sale-admin/edit-admin/payment-sale-edit-admin.component';
import { PaymentSaleViewAdminComponent } from './payment-sale-admin/view-admin/payment-sale-view-admin.component';
import { PaymentSaleListAdminComponent } from './payment-sale-admin/list-admin/payment-sale-list-admin.component';
import { PaymentStatusCreateAdminComponent } from './payment-status-admin/create-admin/payment-status-create-admin.component';
import { PaymentStatusEditAdminComponent } from './payment-status-admin/edit-admin/payment-status-edit-admin.component';
import { PaymentStatusViewAdminComponent } from './payment-status-admin/view-admin/payment-status-view-admin.component';
import { PaymentStatusListAdminComponent } from './payment-status-admin/list-admin/payment-status-list-admin.component';
import { SaleCreateAdminComponent } from './sale-admin/create-admin/sale-create-admin.component';
import { SaleEditAdminComponent } from './sale-admin/edit-admin/sale-edit-admin.component';
import { SaleViewAdminComponent } from './sale-admin/view-admin/sale-view-admin.component';
import { SaleListAdminComponent } from './sale-admin/list-admin/sale-list-admin.component';
import { ReturnSaleCreateAdminComponent } from './return-sale-admin/create-admin/return-sale-create-admin.component';
import { ReturnSaleEditAdminComponent } from './return-sale-admin/edit-admin/return-sale-edit-admin.component';
import { ReturnSaleViewAdminComponent } from './return-sale-admin/view-admin/return-sale-view-admin.component';
import { ReturnSaleListAdminComponent } from './return-sale-admin/list-admin/return-sale-list-admin.component';

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

    ReturnStatusCreateAdminComponent,
    ReturnStatusListAdminComponent,
    ReturnStatusViewAdminComponent,
    ReturnStatusEditAdminComponent,
    SaleStatusCreateAdminComponent,
    SaleStatusListAdminComponent,
    SaleStatusViewAdminComponent,
    SaleStatusEditAdminComponent,
    PaymentSaleCreateAdminComponent,
    PaymentSaleListAdminComponent,
    PaymentSaleViewAdminComponent,
    PaymentSaleEditAdminComponent,
    PaymentStatusCreateAdminComponent,
    PaymentStatusListAdminComponent,
    PaymentStatusViewAdminComponent,
    PaymentStatusEditAdminComponent,
    SaleCreateAdminComponent,
    SaleListAdminComponent,
    SaleViewAdminComponent,
    SaleEditAdminComponent,
    ReturnSaleCreateAdminComponent,
    ReturnSaleListAdminComponent,
    ReturnSaleViewAdminComponent,
    ReturnSaleEditAdminComponent,
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
  ReturnStatusCreateAdminComponent,
  ReturnStatusListAdminComponent,
  ReturnStatusViewAdminComponent,
  ReturnStatusEditAdminComponent,
  SaleStatusCreateAdminComponent,
  SaleStatusListAdminComponent,
  SaleStatusViewAdminComponent,
  SaleStatusEditAdminComponent,
  PaymentSaleCreateAdminComponent,
  PaymentSaleListAdminComponent,
  PaymentSaleViewAdminComponent,
  PaymentSaleEditAdminComponent,
  PaymentStatusCreateAdminComponent,
  PaymentStatusListAdminComponent,
  PaymentStatusViewAdminComponent,
  PaymentStatusEditAdminComponent,
  SaleCreateAdminComponent,
  SaleListAdminComponent,
  SaleViewAdminComponent,
  SaleEditAdminComponent,
  ReturnSaleCreateAdminComponent,
  ReturnSaleListAdminComponent,
  ReturnSaleViewAdminComponent,
  ReturnSaleEditAdminComponent,
  ],
  entryComponents: [],
})
export class SaleAdminModule { }