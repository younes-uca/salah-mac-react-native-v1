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

import { SubscriberCreateAdminComponent } from './subscriber-admin/create-admin/subscriber-create-admin.component';
import { SubscriberEditAdminComponent } from './subscriber-admin/edit-admin/subscriber-edit-admin.component';
import { SubscriberViewAdminComponent } from './subscriber-admin/view-admin/subscriber-view-admin.component';
import { SubscriberListAdminComponent } from './subscriber-admin/list-admin/subscriber-list-admin.component';
import { ShopCreateAdminComponent } from './shop-admin/create-admin/shop-create-admin.component';
import { ShopEditAdminComponent } from './shop-admin/edit-admin/shop-edit-admin.component';
import { ShopViewAdminComponent } from './shop-admin/view-admin/shop-view-admin.component';
import { ShopListAdminComponent } from './shop-admin/list-admin/shop-list-admin.component';
import { CompanyCreateAdminComponent } from './company-admin/create-admin/company-create-admin.component';
import { CompanyEditAdminComponent } from './company-admin/edit-admin/company-edit-admin.component';
import { CompanyViewAdminComponent } from './company-admin/view-admin/company-view-admin.component';
import { CompanyListAdminComponent } from './company-admin/list-admin/company-list-admin.component';
import { StoreCreateAdminComponent } from './store-admin/create-admin/store-create-admin.component';
import { StoreEditAdminComponent } from './store-admin/edit-admin/store-edit-admin.component';
import { StoreViewAdminComponent } from './store-admin/view-admin/store-view-admin.component';
import { StoreListAdminComponent } from './store-admin/list-admin/store-list-admin.component';

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

    SubscriberCreateAdminComponent,
    SubscriberListAdminComponent,
    SubscriberViewAdminComponent,
    SubscriberEditAdminComponent,
    ShopCreateAdminComponent,
    ShopListAdminComponent,
    ShopViewAdminComponent,
    ShopEditAdminComponent,
    CompanyCreateAdminComponent,
    CompanyListAdminComponent,
    CompanyViewAdminComponent,
    CompanyEditAdminComponent,
    StoreCreateAdminComponent,
    StoreListAdminComponent,
    StoreViewAdminComponent,
    StoreEditAdminComponent,
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
  SubscriberCreateAdminComponent,
  SubscriberListAdminComponent,
  SubscriberViewAdminComponent,
  SubscriberEditAdminComponent,
  ShopCreateAdminComponent,
  ShopListAdminComponent,
  ShopViewAdminComponent,
  ShopEditAdminComponent,
  CompanyCreateAdminComponent,
  CompanyListAdminComponent,
  CompanyViewAdminComponent,
  CompanyEditAdminComponent,
  StoreCreateAdminComponent,
  StoreListAdminComponent,
  StoreViewAdminComponent,
  StoreEditAdminComponent,
  ],
  entryComponents: [],
})
export class SubscriberAdminModule { }