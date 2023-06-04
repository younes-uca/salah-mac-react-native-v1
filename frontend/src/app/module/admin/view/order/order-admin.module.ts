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

import { ReceptionStatusCreateAdminComponent } from './reception-status-admin/create-admin/reception-status-create-admin.component';
import { ReceptionStatusEditAdminComponent } from './reception-status-admin/edit-admin/reception-status-edit-admin.component';
import { ReceptionStatusViewAdminComponent } from './reception-status-admin/view-admin/reception-status-view-admin.component';
import { ReceptionStatusListAdminComponent } from './reception-status-admin/list-admin/reception-status-list-admin.component';
import { OrderCreateAdminComponent } from './order-admin/create-admin/order-create-admin.component';
import { OrderEditAdminComponent } from './order-admin/edit-admin/order-edit-admin.component';
import { OrderViewAdminComponent } from './order-admin/view-admin/order-view-admin.component';
import { OrderListAdminComponent } from './order-admin/list-admin/order-list-admin.component';
import { ReceptionCreateAdminComponent } from './reception-admin/create-admin/reception-create-admin.component';
import { ReceptionEditAdminComponent } from './reception-admin/edit-admin/reception-edit-admin.component';
import { ReceptionViewAdminComponent } from './reception-admin/view-admin/reception-view-admin.component';
import { ReceptionListAdminComponent } from './reception-admin/list-admin/reception-list-admin.component';
import { OrderStatusCreateAdminComponent } from './order-status-admin/create-admin/order-status-create-admin.component';
import { OrderStatusEditAdminComponent } from './order-status-admin/edit-admin/order-status-edit-admin.component';
import { OrderStatusViewAdminComponent } from './order-status-admin/view-admin/order-status-view-admin.component';
import { OrderStatusListAdminComponent } from './order-status-admin/list-admin/order-status-list-admin.component';
import { OrderStatusOrderCreateAdminComponent } from './order-status-order-admin/create-admin/order-status-order-create-admin.component';
import { OrderStatusOrderEditAdminComponent } from './order-status-order-admin/edit-admin/order-status-order-edit-admin.component';
import { OrderStatusOrderViewAdminComponent } from './order-status-order-admin/view-admin/order-status-order-view-admin.component';
import { OrderStatusOrderListAdminComponent } from './order-status-order-admin/list-admin/order-status-order-list-admin.component';
import { OrderPaymentCreateAdminComponent } from './order-payment-admin/create-admin/order-payment-create-admin.component';
import { OrderPaymentEditAdminComponent } from './order-payment-admin/edit-admin/order-payment-edit-admin.component';
import { OrderPaymentViewAdminComponent } from './order-payment-admin/view-admin/order-payment-view-admin.component';
import { OrderPaymentListAdminComponent } from './order-payment-admin/list-admin/order-payment-list-admin.component';

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

    ReceptionStatusCreateAdminComponent,
    ReceptionStatusListAdminComponent,
    ReceptionStatusViewAdminComponent,
    ReceptionStatusEditAdminComponent,
    OrderCreateAdminComponent,
    OrderListAdminComponent,
    OrderViewAdminComponent,
    OrderEditAdminComponent,
    ReceptionCreateAdminComponent,
    ReceptionListAdminComponent,
    ReceptionViewAdminComponent,
    ReceptionEditAdminComponent,
    OrderStatusCreateAdminComponent,
    OrderStatusListAdminComponent,
    OrderStatusViewAdminComponent,
    OrderStatusEditAdminComponent,
    OrderStatusOrderCreateAdminComponent,
    OrderStatusOrderListAdminComponent,
    OrderStatusOrderViewAdminComponent,
    OrderStatusOrderEditAdminComponent,
    OrderPaymentCreateAdminComponent,
    OrderPaymentListAdminComponent,
    OrderPaymentViewAdminComponent,
    OrderPaymentEditAdminComponent,
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
  ReceptionStatusCreateAdminComponent,
  ReceptionStatusListAdminComponent,
  ReceptionStatusViewAdminComponent,
  ReceptionStatusEditAdminComponent,
  OrderCreateAdminComponent,
  OrderListAdminComponent,
  OrderViewAdminComponent,
  OrderEditAdminComponent,
  ReceptionCreateAdminComponent,
  ReceptionListAdminComponent,
  ReceptionViewAdminComponent,
  ReceptionEditAdminComponent,
  OrderStatusCreateAdminComponent,
  OrderStatusListAdminComponent,
  OrderStatusViewAdminComponent,
  OrderStatusEditAdminComponent,
  OrderStatusOrderCreateAdminComponent,
  OrderStatusOrderListAdminComponent,
  OrderStatusOrderViewAdminComponent,
  OrderStatusOrderEditAdminComponent,
  OrderPaymentCreateAdminComponent,
  OrderPaymentListAdminComponent,
  OrderPaymentViewAdminComponent,
  OrderPaymentEditAdminComponent,
  ],
  entryComponents: [],
})
export class OrderAdminModule { }