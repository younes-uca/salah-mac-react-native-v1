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

import { LatePaymentRateCreateAdminComponent } from './late-payment-rate-admin/create-admin/late-payment-rate-create-admin.component';
import { LatePaymentRateEditAdminComponent } from './late-payment-rate-admin/edit-admin/late-payment-rate-edit-admin.component';
import { LatePaymentRateViewAdminComponent } from './late-payment-rate-admin/view-admin/late-payment-rate-view-admin.component';
import { LatePaymentRateListAdminComponent } from './late-payment-rate-admin/list-admin/late-payment-rate-list-admin.component';
import { VatDeclarationCreateAdminComponent } from './vat-declaration-admin/create-admin/vat-declaration-create-admin.component';
import { VatDeclarationEditAdminComponent } from './vat-declaration-admin/edit-admin/vat-declaration-edit-admin.component';
import { VatDeclarationViewAdminComponent } from './vat-declaration-admin/view-admin/vat-declaration-view-admin.component';
import { VatDeclarationListAdminComponent } from './vat-declaration-admin/list-admin/vat-declaration-list-admin.component';

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

    LatePaymentRateCreateAdminComponent,
    LatePaymentRateListAdminComponent,
    LatePaymentRateViewAdminComponent,
    LatePaymentRateEditAdminComponent,
    VatDeclarationCreateAdminComponent,
    VatDeclarationListAdminComponent,
    VatDeclarationViewAdminComponent,
    VatDeclarationEditAdminComponent,
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
  LatePaymentRateCreateAdminComponent,
  LatePaymentRateListAdminComponent,
  LatePaymentRateViewAdminComponent,
  LatePaymentRateEditAdminComponent,
  VatDeclarationCreateAdminComponent,
  VatDeclarationListAdminComponent,
  VatDeclarationViewAdminComponent,
  VatDeclarationEditAdminComponent,
  ],
  entryComponents: [],
})
export class VatAdminModule { }