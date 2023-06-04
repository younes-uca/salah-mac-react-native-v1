import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {ReturnSaleService} from 'src/app/controller/service/ReturnSale.service';
import {ReturnSaleDto} from 'src/app/controller/model/ReturnSale.model';
import {ReturnSaleCriteria} from 'src/app/controller/criteria/ReturnSaleCriteria.model';
import {SaleDto} from 'src/app/controller/model/Sale.model';
import {SaleService} from 'src/app/controller/service/Sale.service';
import {ReturnSaleItemDto} from 'src/app/controller/model/ReturnSaleItem.model';
import {ReturnSaleItemService} from 'src/app/controller/service/ReturnSaleItem.service';
import {ReturnStatusDto} from 'src/app/controller/model/ReturnStatus.model';
import {ReturnStatusService} from 'src/app/controller/service/ReturnStatus.service';
import {ProductDto} from 'src/app/controller/model/Product.model';
import {ProductService} from 'src/app/controller/service/Product.service';
@Component({
  selector: 'app-return-sale-create-admin',
  templateUrl: './return-sale-create-admin.component.html'
})
export class ReturnSaleCreateAdminComponent extends AbstractCreateController<ReturnSaleDto, ReturnSaleCriteria, ReturnSaleService>  implements OnInit {

    private _returnSaleItemsElement = new ReturnSaleItemDto();



    constructor( private returnSaleService: ReturnSaleService , private saleService: SaleService, private returnSaleItemService: ReturnSaleItemService, private returnStatusService: ReturnStatusService, private productService: ProductService) {
        super(returnSaleService);
    }

    ngOnInit(): void {
        this.returnSaleItemsElement.product = new ProductDto();
        this.productService.findAll().subscribe((data) => this.products = data);
    this.sale = new SaleDto();
    this.saleService.findAll().subscribe((data) => this.sales = data);
    this.returnStatus = new ReturnStatusDto();
    this.returnStatusService.findAll().subscribe((data) => this.returnStatuss = data);
}



    validateReturnSaleItems(){
        this.errorMessages = new Array();
    }


    public setValidation(value: boolean){
    }

    public addReturnSaleItems() {
        if( this.item.returnSaleItems == null )
            this.item.returnSaleItems = new Array<ReturnSaleItemDto>();
       this.validateReturnSaleItems();
       if (this.errorMessages.length === 0) {
              this.item.returnSaleItems.push({... this.returnSaleItemsElement});
              this.returnSaleItemsElement = new ReturnSaleItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deleteReturnSaleItem(p: ReturnSaleItemDto) {
        this.item.returnSaleItems.forEach((element, index) => {
            if (element === p) { this.item.returnSaleItems.splice(index, 1); }
        });
    }

    public editReturnSaleItem(p: ReturnSaleItemDto) {
        this.returnSaleItemsElement = {... p};
        this.activeTab = 0;
    }


    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



    public async openCreateReturnStatus(returnStatus: string) {
    const isPermistted = await this.roleService.isPermitted('ReturnStatus', 'add');
    if(isPermistted) {
         this.returnStatus = new ReturnStatusDto();
         this.createReturnStatusDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }
    public async openCreateSale(sale: string) {
    const isPermistted = await this.roleService.isPermitted('Sale', 'add');
    if(isPermistted) {
         this.sale = new SaleDto();
         this.createSaleDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }

    get product(): ProductDto {
        return this.productService.item;
    }
    set product(value: ProductDto) {
        this.productService.item = value;
    }
    get products(): Array<ProductDto> {
        return this.productService.items;
    }
    set products(value: Array<ProductDto>) {
        this.productService.items = value;
    }
    get createProductDialog(): boolean {
       return this.productService.createDialog;
    }
    set createProductDialog(value: boolean) {
        this.productService.createDialog= value;
    }
    get returnStatus(): ReturnStatusDto {
        return this.returnStatusService.item;
    }
    set returnStatus(value: ReturnStatusDto) {
        this.returnStatusService.item = value;
    }
    get returnStatuss(): Array<ReturnStatusDto> {
        return this.returnStatusService.items;
    }
    set returnStatuss(value: Array<ReturnStatusDto>) {
        this.returnStatusService.items = value;
    }
    get createReturnStatusDialog(): boolean {
       return this.returnStatusService.createDialog;
    }
    set createReturnStatusDialog(value: boolean) {
        this.returnStatusService.createDialog= value;
    }
    get sale(): SaleDto {
        return this.saleService.item;
    }
    set sale(value: SaleDto) {
        this.saleService.item = value;
    }
    get sales(): Array<SaleDto> {
        return this.saleService.items;
    }
    set sales(value: Array<SaleDto>) {
        this.saleService.items = value;
    }
    get createSaleDialog(): boolean {
       return this.saleService.createDialog;
    }
    set createSaleDialog(value: boolean) {
        this.saleService.createDialog= value;
    }





    get returnSaleItemsElement(): ReturnSaleItemDto {
        if( this._returnSaleItemsElement == null )
            this._returnSaleItemsElement = new ReturnSaleItemDto();
        return this._returnSaleItemsElement;
    }

    set returnSaleItemsElement(value: ReturnSaleItemDto) {
        this._returnSaleItemsElement = value;
    }

}
