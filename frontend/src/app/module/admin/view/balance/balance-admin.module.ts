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

import { AccountingOperationCreateAdminComponent } from './accounting-operation-admin/create-admin/accounting-operation-create-admin.component';
import { AccountingOperationEditAdminComponent } from './accounting-operation-admin/edit-admin/accounting-operation-edit-admin.component';
import { AccountingOperationViewAdminComponent } from './accounting-operation-admin/view-admin/accounting-operation-view-admin.component';
import { AccountingOperationListAdminComponent } from './accounting-operation-admin/list-admin/accounting-operation-list-admin.component';
import { BalanceSheetStatusCreateAdminComponent } from './balance-sheet-status-admin/create-admin/balance-sheet-status-create-admin.component';
import { BalanceSheetStatusEditAdminComponent } from './balance-sheet-status-admin/edit-admin/balance-sheet-status-edit-admin.component';
import { BalanceSheetStatusViewAdminComponent } from './balance-sheet-status-admin/view-admin/balance-sheet-status-view-admin.component';
import { BalanceSheetStatusListAdminComponent } from './balance-sheet-status-admin/list-admin/balance-sheet-status-list-admin.component';
import { BalanceSheetCreateAdminComponent } from './balance-sheet-admin/create-admin/balance-sheet-create-admin.component';
import { BalanceSheetEditAdminComponent } from './balance-sheet-admin/edit-admin/balance-sheet-edit-admin.component';
import { BalanceSheetViewAdminComponent } from './balance-sheet-admin/view-admin/balance-sheet-view-admin.component';
import { BalanceSheetListAdminComponent } from './balance-sheet-admin/list-admin/balance-sheet-list-admin.component';
import { AccountingOperationStatusCreateAdminComponent } from './accounting-operation-status-admin/create-admin/accounting-operation-status-create-admin.component';
import { AccountingOperationStatusEditAdminComponent } from './accounting-operation-status-admin/edit-admin/accounting-operation-status-edit-admin.component';
import { AccountingOperationStatusViewAdminComponent } from './accounting-operation-status-admin/view-admin/accounting-operation-status-view-admin.component';
import { AccountingOperationStatusListAdminComponent } from './accounting-operation-status-admin/list-admin/accounting-operation-status-list-admin.component';
import { AccountingAccountCreateAdminComponent } from './accounting-account-admin/create-admin/accounting-account-create-admin.component';
import { AccountingAccountEditAdminComponent } from './accounting-account-admin/edit-admin/accounting-account-edit-admin.component';
import { AccountingAccountViewAdminComponent } from './accounting-account-admin/view-admin/accounting-account-view-admin.component';
import { AccountingAccountListAdminComponent } from './accounting-account-admin/list-admin/accounting-account-list-admin.component';
import { SubAccountingClassCreateAdminComponent } from './sub-accounting-class-admin/create-admin/sub-accounting-class-create-admin.component';
import { SubAccountingClassEditAdminComponent } from './sub-accounting-class-admin/edit-admin/sub-accounting-class-edit-admin.component';
import { SubAccountingClassViewAdminComponent } from './sub-accounting-class-admin/view-admin/sub-accounting-class-view-admin.component';
import { SubAccountingClassListAdminComponent } from './sub-accounting-class-admin/list-admin/sub-accounting-class-list-admin.component';
import { AccountingClassCreateAdminComponent } from './accounting-class-admin/create-admin/accounting-class-create-admin.component';
import { AccountingClassEditAdminComponent } from './accounting-class-admin/edit-admin/accounting-class-edit-admin.component';
import { AccountingClassViewAdminComponent } from './accounting-class-admin/view-admin/accounting-class-view-admin.component';
import { AccountingClassListAdminComponent } from './accounting-class-admin/list-admin/accounting-class-list-admin.component';
import { AccountingOperationTypeCreateAdminComponent } from './accounting-operation-type-admin/create-admin/accounting-operation-type-create-admin.component';
import { AccountingOperationTypeEditAdminComponent } from './accounting-operation-type-admin/edit-admin/accounting-operation-type-edit-admin.component';
import { AccountingOperationTypeViewAdminComponent } from './accounting-operation-type-admin/view-admin/accounting-operation-type-view-admin.component';
import { AccountingOperationTypeListAdminComponent } from './accounting-operation-type-admin/list-admin/accounting-operation-type-list-admin.component';

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

    AccountingOperationCreateAdminComponent,
    AccountingOperationListAdminComponent,
    AccountingOperationViewAdminComponent,
    AccountingOperationEditAdminComponent,
    BalanceSheetStatusCreateAdminComponent,
    BalanceSheetStatusListAdminComponent,
    BalanceSheetStatusViewAdminComponent,
    BalanceSheetStatusEditAdminComponent,
    BalanceSheetCreateAdminComponent,
    BalanceSheetListAdminComponent,
    BalanceSheetViewAdminComponent,
    BalanceSheetEditAdminComponent,
    AccountingOperationStatusCreateAdminComponent,
    AccountingOperationStatusListAdminComponent,
    AccountingOperationStatusViewAdminComponent,
    AccountingOperationStatusEditAdminComponent,
    AccountingAccountCreateAdminComponent,
    AccountingAccountListAdminComponent,
    AccountingAccountViewAdminComponent,
    AccountingAccountEditAdminComponent,
    SubAccountingClassCreateAdminComponent,
    SubAccountingClassListAdminComponent,
    SubAccountingClassViewAdminComponent,
    SubAccountingClassEditAdminComponent,
    AccountingClassCreateAdminComponent,
    AccountingClassListAdminComponent,
    AccountingClassViewAdminComponent,
    AccountingClassEditAdminComponent,
    AccountingOperationTypeCreateAdminComponent,
    AccountingOperationTypeListAdminComponent,
    AccountingOperationTypeViewAdminComponent,
    AccountingOperationTypeEditAdminComponent,
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
  AccountingOperationCreateAdminComponent,
  AccountingOperationListAdminComponent,
  AccountingOperationViewAdminComponent,
  AccountingOperationEditAdminComponent,
  BalanceSheetStatusCreateAdminComponent,
  BalanceSheetStatusListAdminComponent,
  BalanceSheetStatusViewAdminComponent,
  BalanceSheetStatusEditAdminComponent,
  BalanceSheetCreateAdminComponent,
  BalanceSheetListAdminComponent,
  BalanceSheetViewAdminComponent,
  BalanceSheetEditAdminComponent,
  AccountingOperationStatusCreateAdminComponent,
  AccountingOperationStatusListAdminComponent,
  AccountingOperationStatusViewAdminComponent,
  AccountingOperationStatusEditAdminComponent,
  AccountingAccountCreateAdminComponent,
  AccountingAccountListAdminComponent,
  AccountingAccountViewAdminComponent,
  AccountingAccountEditAdminComponent,
  SubAccountingClassCreateAdminComponent,
  SubAccountingClassListAdminComponent,
  SubAccountingClassViewAdminComponent,
  SubAccountingClassEditAdminComponent,
  AccountingClassCreateAdminComponent,
  AccountingClassListAdminComponent,
  AccountingClassViewAdminComponent,
  AccountingClassEditAdminComponent,
  AccountingOperationTypeCreateAdminComponent,
  AccountingOperationTypeListAdminComponent,
  AccountingOperationTypeViewAdminComponent,
  AccountingOperationTypeEditAdminComponent,
  ],
  entryComponents: [],
})
export class BalanceAdminModule { }