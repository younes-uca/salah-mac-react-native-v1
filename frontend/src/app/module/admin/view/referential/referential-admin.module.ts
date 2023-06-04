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

import { ProductCreateAdminComponent } from './product-admin/create-admin/product-create-admin.component';
import { ProductEditAdminComponent } from './product-admin/edit-admin/product-edit-admin.component';
import { ProductViewAdminComponent } from './product-admin/view-admin/product-view-admin.component';
import { ProductListAdminComponent } from './product-admin/list-admin/product-list-admin.component';
import { ProductStockCreateAdminComponent } from './product-stock-admin/create-admin/product-stock-create-admin.component';
import { ProductStockEditAdminComponent } from './product-stock-admin/edit-admin/product-stock-edit-admin.component';
import { ProductStockViewAdminComponent } from './product-stock-admin/view-admin/product-stock-view-admin.component';
import { ProductStockListAdminComponent } from './product-stock-admin/list-admin/product-stock-list-admin.component';
import { ProductCategoryCreateAdminComponent } from './product-category-admin/create-admin/product-category-create-admin.component';
import { ProductCategoryEditAdminComponent } from './product-category-admin/edit-admin/product-category-edit-admin.component';
import { ProductCategoryViewAdminComponent } from './product-category-admin/view-admin/product-category-view-admin.component';
import { ProductCategoryListAdminComponent } from './product-category-admin/list-admin/product-category-list-admin.component';

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

    ProductCreateAdminComponent,
    ProductListAdminComponent,
    ProductViewAdminComponent,
    ProductEditAdminComponent,
    ProductStockCreateAdminComponent,
    ProductStockListAdminComponent,
    ProductStockViewAdminComponent,
    ProductStockEditAdminComponent,
    ProductCategoryCreateAdminComponent,
    ProductCategoryListAdminComponent,
    ProductCategoryViewAdminComponent,
    ProductCategoryEditAdminComponent,
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
  ProductCreateAdminComponent,
  ProductListAdminComponent,
  ProductViewAdminComponent,
  ProductEditAdminComponent,
  ProductStockCreateAdminComponent,
  ProductStockListAdminComponent,
  ProductStockViewAdminComponent,
  ProductStockEditAdminComponent,
  ProductCategoryCreateAdminComponent,
  ProductCategoryListAdminComponent,
  ProductCategoryViewAdminComponent,
  ProductCategoryEditAdminComponent,
  ],
  entryComponents: [],
})
export class ReferentialAdminModule { }