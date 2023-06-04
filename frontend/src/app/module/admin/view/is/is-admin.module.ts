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

import { CorporateTaxRateCreateAdminComponent } from './corporate-tax-rate-admin/create-admin/corporate-tax-rate-create-admin.component';
import { CorporateTaxRateEditAdminComponent } from './corporate-tax-rate-admin/edit-admin/corporate-tax-rate-edit-admin.component';
import { CorporateTaxRateViewAdminComponent } from './corporate-tax-rate-admin/view-admin/corporate-tax-rate-view-admin.component';
import { CorporateTaxRateListAdminComponent } from './corporate-tax-rate-admin/list-admin/corporate-tax-rate-list-admin.component';
import { IncomeStatementDeclarationCreateAdminComponent } from './income-statement-declaration-admin/create-admin/income-statement-declaration-create-admin.component';
import { IncomeStatementDeclarationEditAdminComponent } from './income-statement-declaration-admin/edit-admin/income-statement-declaration-edit-admin.component';
import { IncomeStatementDeclarationViewAdminComponent } from './income-statement-declaration-admin/view-admin/income-statement-declaration-view-admin.component';
import { IncomeStatementDeclarationListAdminComponent } from './income-statement-declaration-admin/list-admin/income-statement-declaration-list-admin.component';

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

    CorporateTaxRateCreateAdminComponent,
    CorporateTaxRateListAdminComponent,
    CorporateTaxRateViewAdminComponent,
    CorporateTaxRateEditAdminComponent,
    IncomeStatementDeclarationCreateAdminComponent,
    IncomeStatementDeclarationListAdminComponent,
    IncomeStatementDeclarationViewAdminComponent,
    IncomeStatementDeclarationEditAdminComponent,
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
  CorporateTaxRateCreateAdminComponent,
  CorporateTaxRateListAdminComponent,
  CorporateTaxRateViewAdminComponent,
  CorporateTaxRateEditAdminComponent,
  IncomeStatementDeclarationCreateAdminComponent,
  IncomeStatementDeclarationListAdminComponent,
  IncomeStatementDeclarationViewAdminComponent,
  IncomeStatementDeclarationEditAdminComponent,
  ],
  entryComponents: [],
})
export class IsAdminModule { }