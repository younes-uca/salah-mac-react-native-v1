import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import {
  trigger,
  state,
  style,
  transition,
  animate,
} from '@angular/animations';
import { AppComponent } from './app.component';
import { AppMainComponent } from './app.main.component';

import { AuthService } from 'src/app/zynerator/security/Auth.service';
import { RoleService } from 'src/app/zynerator/security/Role.service';

@Component({
  selector: 'app-menu',
  templateUrl: './app.menu.component.html',
  animations: [
    trigger('inline', [
      state(
        'hidden',
        style({
          height: '0px',
          overflow: 'hidden',
        })
      ),
      state(
        'visible',
        style({
          height: '*',
        })
      ),
      state(
        'hiddenAnimated',
        style({
          height: '0px',
          overflow: 'hidden',
        })
      ),
      state(
        'visibleAnimated',
        style({
          height: '*',
        })
      ),
      transition(
        'visibleAnimated => hiddenAnimated',
        animate('400ms cubic-bezier(0.86, 0, 0.07, 1)')
      ),
      transition(
        'hiddenAnimated => visibleAnimated',
        animate('400ms cubic-bezier(0.86, 0, 0.07, 1)')
      ),
    ]),
  ],
})
export class AppMenuComponent implements OnInit {
  model: any[];
  modelsuperadmin:any[];
  modelanonymous: any[];
    modeladmin : any[];
  constructor(public app: AppComponent,
   public appMain: AppMainComponent,
   private roleService: RoleService,
   private authService:AuthService,
  private router: Router) {}

  ngOnInit() {


    this.modeladmin =
      [
              {
                label: 'Check Management',
                icon: 'pi pi-wallet',
                items:[
                    {
                      label: 'Liste check owner',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/check/check-owner/list']
                    },
                    {
                      label: 'Liste bank check owner',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/check/bank-check-owner/list']
                    },
                    {
                      label: 'Liste bank',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/check/bank/list']
                    },
                ]
              },
              {
                label: 'Product Management',
                icon: 'pi pi-wallet',
                items:[
                    {
                      label: 'Liste product',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/referential/product/list']
                    },
                    {
                      label: 'Liste product stock',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/referential/product-stock/list']
                    },
                    {
                      label: 'Liste product category',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/referential/product-category/list']
                    },
                ]
              },
              {
                label: 'Collaborater Management',
                icon: 'pi pi-wallet',
                items:[
                    {
                      label: 'Liste supplier',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/collaborater/supplier/list']
                    },
                    {
                      label: 'Liste client',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/collaborater/client/list']
                    },
                ]
              },
              {
                label: 'Configuration',
                icon: 'pi pi-wallet',
                items:[
                    {
                      label: 'Liste brand',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/reference/brand/list']
                    },
                    {
                      label: 'Liste measurement unit',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/reference/measurement-unit/list']
                    },
                    {
                      label: 'Liste payment mode',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/reference/payment-mode/list']
                    },
                    {
                      label: 'Liste payment method',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/reference/payment-method/list']
                    },
                ]
              },
              {
                label: 'Demand Management',
                icon: 'pi pi-wallet',
                items:[
                    {
                      label: 'Liste payment delivery status',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/demand/payment-delivery-status/list']
                    },
                    {
                      label: 'Liste demand status',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/demand/demand-status/list']
                    },
                    {
                      label: 'Liste delivery status',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/demand/delivery-status/list']
                    },
                    {
                      label: 'Liste demand payment',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/demand/demand-payment/list']
                    },
                    {
                      label: 'Liste demand',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/demand/demand/list']
                    },
                    {
                      label: 'Liste delivery',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/demand/delivery/list']
                    },
                    {
                      label: 'Liste payment delivery',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/demand/payment-delivery/list']
                    },
                ]
              },
              {
                label: 'Sales Management',
                icon: 'pi pi-wallet',
                items:[
                    {
                      label: 'Liste supplier quote',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/quotation/supplier-quote/list']
                    },
                ]
              },
              {
                label: 'IS Management',
                icon: 'pi pi-wallet',
                items:[
                    {
                      label: 'Liste corporate tax rate',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/is/corporate-tax-rate/list']
                    },
                    {
                      label: 'Liste income statement declaration',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/is/income-statement-declaration/list']
                    },
                ]
              },
              {
                label: 'Balance Sheet Management',
                icon: 'pi pi-wallet',
                items:[
                    {
                      label: 'Liste accounting operation',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/balance/accounting-operation/list']
                    },
                    {
                      label: 'Liste balance sheet',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/balance/balance-sheet/list']
                    },
                ]
              },
              {
                label: 'Accounting Reference',
                icon: 'pi pi-wallet',
                items:[
                    {
                      label: 'Liste validation accountant',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/accountingref/validation-accountant/list']
                    },
                    {
                      label: 'Liste handling accountant',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/accountingref/handling-accountant/list']
                    },
                ]
              },
              {
                label: 'Order Management',
                icon: 'pi pi-wallet',
                items:[
                    {
                      label: 'Liste reception status',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/order/reception-status/list']
                    },
                    {
                      label: 'Liste order',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/order/order/list']
                    },
                    {
                      label: 'Liste reception',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/order/reception/list']
                    },
                    {
                      label: 'Liste order status',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/order/order-status/list']
                    },
                    {
                      label: 'Liste order status order',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/order/order-status-order/list']
                    },
                    {
                      label: 'Liste order payment',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/order/order-payment/list']
                    },
                ]
              },
              {
                label: 'Gestion Demande',
                icon: 'pi pi-wallet',
                items:[
                    {
                      label: 'Liste status payment demand',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/demande/status-payment-demand/list']
                    },
                ]
              },
              {
                label: 'Sale Management',
                icon: 'pi pi-wallet',
                items:[
                    {
                      label: 'Liste return status',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/sale/return-status/list']
                    },
                    {
                      label: 'Liste sale status',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/sale/sale-status/list']
                    },
                    {
                      label: 'Liste payment sale',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/sale/payment-sale/list']
                    },
                    {
                      label: 'Liste payment status',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/sale/payment-status/list']
                    },
                    {
                      label: 'Liste sale',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/sale/sale/list']
                    },
                    {
                      label: 'Liste return sale',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/sale/return-sale/list']
                    },
                ]
              },
              {
                label: 'VAT Management',
                icon: 'pi pi-wallet',
                items:[
                    {
                      label: 'Liste late payment rate',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/vat/late-payment-rate/list']
                    },
                    {
                      label: 'Liste vat declaration',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/vat/vat-declaration/list']
                    },
                ]
              },
              {
                label: 'Purchase Management',
                icon: 'pi pi-wallet',
                items:[
                    {
                      label: 'Liste purchase',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/purchase/purchase/list']
                    },
                    {
                      label: 'Liste purchase payment status',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/purchase/purchase-payment-status/list']
                    },
                    {
                      label: 'Liste purchase status',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/purchase/purchase-status/list']
                    },
                    {
                      label: 'Liste credit note purchase',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/purchase/credit-note-purchase/list']
                    },
                    {
                      label: 'Liste payment purchase',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/purchase/payment-purchase/list']
                    },
                    {
                      label: 'Liste credit note purchase status',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/purchase/credit-note-purchase-status/list']
                    },
                ]
              },
              {
                label: 'Subscriber Management',
                icon: 'pi pi-wallet',
                items:[
                    {
                      label: 'Liste subscriber',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/subscriber/subscriber/list']
                    },
                    {
                      label: 'Liste shop',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/subscriber/shop/list']
                    },
                    {
                      label: 'Liste company',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/subscriber/company/list']
                    },
                    {
                      label: 'Liste store',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/subscriber/store/list']
                    },
                ]
              },
              {
                label: 'Balance Sheet Referential',
                icon: 'pi pi-wallet',
                items:[
                    {
                      label: 'Liste balance sheet status',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/balance/balance-sheet-status/list']
                    },
                    {
                      label: 'Liste accounting operation status',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/balance/accounting-operation-status/list']
                    },
                    {
                      label: 'Liste accounting account',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/balance/accounting-account/list']
                    },
                    {
                      label: 'Liste sub accounting class',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/balance/sub-accounting-class/list']
                    },
                    {
                      label: 'Liste accounting class',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/balance/accounting-class/list']
                    },
                    {
                      label: 'Liste accounting operation type',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/balance/accounting-operation-type/list']
                    },
                ]
              },
    ]
        if (this.authService.authenticated) {
      if (this.authService.authenticatedUser.roles) {

        this.authService.authenticatedUser.roles.forEach(role => {
          const roleName: string = this.getRole(role);
          this.roleService._role.next(roleName.toUpperCase());
          eval('this.model = this.model' + this.getRole(role));
        })
      }

    }
  }
  getRole(text){
  const [role, ...rest] = text.split('_');
  return rest.join('').toLowerCase();
}
  onMenuClick(event) {
    this.appMain.onMenuClick(event);
  }
}
