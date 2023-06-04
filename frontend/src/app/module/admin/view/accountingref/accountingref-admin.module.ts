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

import { ValidationAccountantCreateAdminComponent } from './validation-accountant-admin/create-admin/validation-accountant-create-admin.component';
import { ValidationAccountantEditAdminComponent } from './validation-accountant-admin/edit-admin/validation-accountant-edit-admin.component';
import { ValidationAccountantViewAdminComponent } from './validation-accountant-admin/view-admin/validation-accountant-view-admin.component';
import { ValidationAccountantListAdminComponent } from './validation-accountant-admin/list-admin/validation-accountant-list-admin.component';
import { HandlingAccountantCreateAdminComponent } from './handling-accountant-admin/create-admin/handling-accountant-create-admin.component';
import { HandlingAccountantEditAdminComponent } from './handling-accountant-admin/edit-admin/handling-accountant-edit-admin.component';
import { HandlingAccountantViewAdminComponent } from './handling-accountant-admin/view-admin/handling-accountant-view-admin.component';
import { HandlingAccountantListAdminComponent } from './handling-accountant-admin/list-admin/handling-accountant-list-admin.component';

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

    ValidationAccountantCreateAdminComponent,
    ValidationAccountantListAdminComponent,
    ValidationAccountantViewAdminComponent,
    ValidationAccountantEditAdminComponent,
    HandlingAccountantCreateAdminComponent,
    HandlingAccountantListAdminComponent,
    HandlingAccountantViewAdminComponent,
    HandlingAccountantEditAdminComponent,
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
  ValidationAccountantCreateAdminComponent,
  ValidationAccountantListAdminComponent,
  ValidationAccountantViewAdminComponent,
  ValidationAccountantEditAdminComponent,
  HandlingAccountantCreateAdminComponent,
  HandlingAccountantListAdminComponent,
  HandlingAccountantViewAdminComponent,
  HandlingAccountantEditAdminComponent,
  ],
  entryComponents: [],
})
export class AccountingrefAdminModule { }