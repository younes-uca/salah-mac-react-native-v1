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

import { BrandCreateAdminComponent } from './brand-admin/create-admin/brand-create-admin.component';
import { BrandEditAdminComponent } from './brand-admin/edit-admin/brand-edit-admin.component';
import { BrandViewAdminComponent } from './brand-admin/view-admin/brand-view-admin.component';
import { BrandListAdminComponent } from './brand-admin/list-admin/brand-list-admin.component';
import { MeasurementUnitCreateAdminComponent } from './measurement-unit-admin/create-admin/measurement-unit-create-admin.component';
import { MeasurementUnitEditAdminComponent } from './measurement-unit-admin/edit-admin/measurement-unit-edit-admin.component';
import { MeasurementUnitViewAdminComponent } from './measurement-unit-admin/view-admin/measurement-unit-view-admin.component';
import { MeasurementUnitListAdminComponent } from './measurement-unit-admin/list-admin/measurement-unit-list-admin.component';
import { PaymentModeCreateAdminComponent } from './payment-mode-admin/create-admin/payment-mode-create-admin.component';
import { PaymentModeEditAdminComponent } from './payment-mode-admin/edit-admin/payment-mode-edit-admin.component';
import { PaymentModeViewAdminComponent } from './payment-mode-admin/view-admin/payment-mode-view-admin.component';
import { PaymentModeListAdminComponent } from './payment-mode-admin/list-admin/payment-mode-list-admin.component';
import { PaymentMethodCreateAdminComponent } from './payment-method-admin/create-admin/payment-method-create-admin.component';
import { PaymentMethodEditAdminComponent } from './payment-method-admin/edit-admin/payment-method-edit-admin.component';
import { PaymentMethodViewAdminComponent } from './payment-method-admin/view-admin/payment-method-view-admin.component';
import { PaymentMethodListAdminComponent } from './payment-method-admin/list-admin/payment-method-list-admin.component';

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

    BrandCreateAdminComponent,
    BrandListAdminComponent,
    BrandViewAdminComponent,
    BrandEditAdminComponent,
    MeasurementUnitCreateAdminComponent,
    MeasurementUnitListAdminComponent,
    MeasurementUnitViewAdminComponent,
    MeasurementUnitEditAdminComponent,
    PaymentModeCreateAdminComponent,
    PaymentModeListAdminComponent,
    PaymentModeViewAdminComponent,
    PaymentModeEditAdminComponent,
    PaymentMethodCreateAdminComponent,
    PaymentMethodListAdminComponent,
    PaymentMethodViewAdminComponent,
    PaymentMethodEditAdminComponent,
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
  BrandCreateAdminComponent,
  BrandListAdminComponent,
  BrandViewAdminComponent,
  BrandEditAdminComponent,
  MeasurementUnitCreateAdminComponent,
  MeasurementUnitListAdminComponent,
  MeasurementUnitViewAdminComponent,
  MeasurementUnitEditAdminComponent,
  PaymentModeCreateAdminComponent,
  PaymentModeListAdminComponent,
  PaymentModeViewAdminComponent,
  PaymentModeEditAdminComponent,
  PaymentMethodCreateAdminComponent,
  PaymentMethodListAdminComponent,
  PaymentMethodViewAdminComponent,
  PaymentMethodEditAdminComponent,
  ],
  entryComponents: [],
})
export class ReferenceAdminModule { }