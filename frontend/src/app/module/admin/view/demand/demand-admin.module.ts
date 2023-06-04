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

import { PaymentDeliveryStatusCreateAdminComponent } from './payment-delivery-status-admin/create-admin/payment-delivery-status-create-admin.component';
import { PaymentDeliveryStatusEditAdminComponent } from './payment-delivery-status-admin/edit-admin/payment-delivery-status-edit-admin.component';
import { PaymentDeliveryStatusViewAdminComponent } from './payment-delivery-status-admin/view-admin/payment-delivery-status-view-admin.component';
import { PaymentDeliveryStatusListAdminComponent } from './payment-delivery-status-admin/list-admin/payment-delivery-status-list-admin.component';
import { DemandStatusCreateAdminComponent } from './demand-status-admin/create-admin/demand-status-create-admin.component';
import { DemandStatusEditAdminComponent } from './demand-status-admin/edit-admin/demand-status-edit-admin.component';
import { DemandStatusViewAdminComponent } from './demand-status-admin/view-admin/demand-status-view-admin.component';
import { DemandStatusListAdminComponent } from './demand-status-admin/list-admin/demand-status-list-admin.component';
import { DeliveryStatusCreateAdminComponent } from './delivery-status-admin/create-admin/delivery-status-create-admin.component';
import { DeliveryStatusEditAdminComponent } from './delivery-status-admin/edit-admin/delivery-status-edit-admin.component';
import { DeliveryStatusViewAdminComponent } from './delivery-status-admin/view-admin/delivery-status-view-admin.component';
import { DeliveryStatusListAdminComponent } from './delivery-status-admin/list-admin/delivery-status-list-admin.component';
import { DemandPaymentCreateAdminComponent } from './demand-payment-admin/create-admin/demand-payment-create-admin.component';
import { DemandPaymentEditAdminComponent } from './demand-payment-admin/edit-admin/demand-payment-edit-admin.component';
import { DemandPaymentViewAdminComponent } from './demand-payment-admin/view-admin/demand-payment-view-admin.component';
import { DemandPaymentListAdminComponent } from './demand-payment-admin/list-admin/demand-payment-list-admin.component';
import { DemandCreateAdminComponent } from './demand-admin/create-admin/demand-create-admin.component';
import { DemandEditAdminComponent } from './demand-admin/edit-admin/demand-edit-admin.component';
import { DemandViewAdminComponent } from './demand-admin/view-admin/demand-view-admin.component';
import { DemandListAdminComponent } from './demand-admin/list-admin/demand-list-admin.component';
import { DeliveryCreateAdminComponent } from './delivery-admin/create-admin/delivery-create-admin.component';
import { DeliveryEditAdminComponent } from './delivery-admin/edit-admin/delivery-edit-admin.component';
import { DeliveryViewAdminComponent } from './delivery-admin/view-admin/delivery-view-admin.component';
import { DeliveryListAdminComponent } from './delivery-admin/list-admin/delivery-list-admin.component';
import { PaymentDeliveryCreateAdminComponent } from './payment-delivery-admin/create-admin/payment-delivery-create-admin.component';
import { PaymentDeliveryEditAdminComponent } from './payment-delivery-admin/edit-admin/payment-delivery-edit-admin.component';
import { PaymentDeliveryViewAdminComponent } from './payment-delivery-admin/view-admin/payment-delivery-view-admin.component';
import { PaymentDeliveryListAdminComponent } from './payment-delivery-admin/list-admin/payment-delivery-list-admin.component';

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

    PaymentDeliveryStatusCreateAdminComponent,
    PaymentDeliveryStatusListAdminComponent,
    PaymentDeliveryStatusViewAdminComponent,
    PaymentDeliveryStatusEditAdminComponent,
    DemandStatusCreateAdminComponent,
    DemandStatusListAdminComponent,
    DemandStatusViewAdminComponent,
    DemandStatusEditAdminComponent,
    DeliveryStatusCreateAdminComponent,
    DeliveryStatusListAdminComponent,
    DeliveryStatusViewAdminComponent,
    DeliveryStatusEditAdminComponent,
    DemandPaymentCreateAdminComponent,
    DemandPaymentListAdminComponent,
    DemandPaymentViewAdminComponent,
    DemandPaymentEditAdminComponent,
    DemandCreateAdminComponent,
    DemandListAdminComponent,
    DemandViewAdminComponent,
    DemandEditAdminComponent,
    DeliveryCreateAdminComponent,
    DeliveryListAdminComponent,
    DeliveryViewAdminComponent,
    DeliveryEditAdminComponent,
    PaymentDeliveryCreateAdminComponent,
    PaymentDeliveryListAdminComponent,
    PaymentDeliveryViewAdminComponent,
    PaymentDeliveryEditAdminComponent,
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
  PaymentDeliveryStatusCreateAdminComponent,
  PaymentDeliveryStatusListAdminComponent,
  PaymentDeliveryStatusViewAdminComponent,
  PaymentDeliveryStatusEditAdminComponent,
  DemandStatusCreateAdminComponent,
  DemandStatusListAdminComponent,
  DemandStatusViewAdminComponent,
  DemandStatusEditAdminComponent,
  DeliveryStatusCreateAdminComponent,
  DeliveryStatusListAdminComponent,
  DeliveryStatusViewAdminComponent,
  DeliveryStatusEditAdminComponent,
  DemandPaymentCreateAdminComponent,
  DemandPaymentListAdminComponent,
  DemandPaymentViewAdminComponent,
  DemandPaymentEditAdminComponent,
  DemandCreateAdminComponent,
  DemandListAdminComponent,
  DemandViewAdminComponent,
  DemandEditAdminComponent,
  DeliveryCreateAdminComponent,
  DeliveryListAdminComponent,
  DeliveryViewAdminComponent,
  DeliveryEditAdminComponent,
  PaymentDeliveryCreateAdminComponent,
  PaymentDeliveryListAdminComponent,
  PaymentDeliveryViewAdminComponent,
  PaymentDeliveryEditAdminComponent,
  ],
  entryComponents: [],
})
export class DemandAdminModule { }