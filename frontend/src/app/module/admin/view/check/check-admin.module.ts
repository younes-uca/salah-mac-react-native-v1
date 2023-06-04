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

import { CheckOwnerCreateAdminComponent } from './check-owner-admin/create-admin/check-owner-create-admin.component';
import { CheckOwnerEditAdminComponent } from './check-owner-admin/edit-admin/check-owner-edit-admin.component';
import { CheckOwnerViewAdminComponent } from './check-owner-admin/view-admin/check-owner-view-admin.component';
import { CheckOwnerListAdminComponent } from './check-owner-admin/list-admin/check-owner-list-admin.component';
import { BankCheckOwnerCreateAdminComponent } from './bank-check-owner-admin/create-admin/bank-check-owner-create-admin.component';
import { BankCheckOwnerEditAdminComponent } from './bank-check-owner-admin/edit-admin/bank-check-owner-edit-admin.component';
import { BankCheckOwnerViewAdminComponent } from './bank-check-owner-admin/view-admin/bank-check-owner-view-admin.component';
import { BankCheckOwnerListAdminComponent } from './bank-check-owner-admin/list-admin/bank-check-owner-list-admin.component';
import { BankCreateAdminComponent } from './bank-admin/create-admin/bank-create-admin.component';
import { BankEditAdminComponent } from './bank-admin/edit-admin/bank-edit-admin.component';
import { BankViewAdminComponent } from './bank-admin/view-admin/bank-view-admin.component';
import { BankListAdminComponent } from './bank-admin/list-admin/bank-list-admin.component';

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

    CheckOwnerCreateAdminComponent,
    CheckOwnerListAdminComponent,
    CheckOwnerViewAdminComponent,
    CheckOwnerEditAdminComponent,
    BankCheckOwnerCreateAdminComponent,
    BankCheckOwnerListAdminComponent,
    BankCheckOwnerViewAdminComponent,
    BankCheckOwnerEditAdminComponent,
    BankCreateAdminComponent,
    BankListAdminComponent,
    BankViewAdminComponent,
    BankEditAdminComponent,
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
  CheckOwnerCreateAdminComponent,
  CheckOwnerListAdminComponent,
  CheckOwnerViewAdminComponent,
  CheckOwnerEditAdminComponent,
  BankCheckOwnerCreateAdminComponent,
  BankCheckOwnerListAdminComponent,
  BankCheckOwnerViewAdminComponent,
  BankCheckOwnerEditAdminComponent,
  BankCreateAdminComponent,
  BankListAdminComponent,
  BankViewAdminComponent,
  BankEditAdminComponent,
  ],
  entryComponents: [],
})
export class CheckAdminModule { }