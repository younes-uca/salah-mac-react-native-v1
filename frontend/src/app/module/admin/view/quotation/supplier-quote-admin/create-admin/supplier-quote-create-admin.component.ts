import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {SupplierQuoteService} from 'src/app/controller/service/SupplierQuote.service';
import {SupplierQuoteDto} from 'src/app/controller/model/SupplierQuote.model';
import {SupplierQuoteCriteria} from 'src/app/controller/criteria/SupplierQuoteCriteria.model';
import {SupplierQuoteItemDto} from 'src/app/controller/model/SupplierQuoteItem.model';
import {SupplierQuoteItemService} from 'src/app/controller/service/SupplierQuoteItem.service';
import {SupplierDto} from 'src/app/controller/model/Supplier.model';
import {SupplierService} from 'src/app/controller/service/Supplier.service';
import {ProductDto} from 'src/app/controller/model/Product.model';
import {ProductService} from 'src/app/controller/service/Product.service';
@Component({
  selector: 'app-supplier-quote-create-admin',
  templateUrl: './supplier-quote-create-admin.component.html'
})
export class SupplierQuoteCreateAdminComponent extends AbstractCreateController<SupplierQuoteDto, SupplierQuoteCriteria, SupplierQuoteService>  implements OnInit {

    private _supplierQuoteItemsElement = new SupplierQuoteItemDto();



    constructor( private supplierQuoteService: SupplierQuoteService , private supplierQuoteItemService: SupplierQuoteItemService, private supplierService: SupplierService, private productService: ProductService) {
        super(supplierQuoteService);
    }

    ngOnInit(): void {
        this.supplierQuoteItemsElement.product = new ProductDto();
        this.productService.findAll().subscribe((data) => this.products = data);
    this.supplier = new SupplierDto();
    this.supplierService.findAll().subscribe((data) => this.suppliers = data);
}



    validateSupplierQuoteItems(){
        this.errorMessages = new Array();
    }


    public setValidation(value: boolean){
    }

    public addSupplierQuoteItems() {
        if( this.item.supplierQuoteItems == null )
            this.item.supplierQuoteItems = new Array<SupplierQuoteItemDto>();
       this.validateSupplierQuoteItems();
       if (this.errorMessages.length === 0) {
              this.item.supplierQuoteItems.push({... this.supplierQuoteItemsElement});
              this.supplierQuoteItemsElement = new SupplierQuoteItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deleteSupplierQuoteItem(p: SupplierQuoteItemDto) {
        this.item.supplierQuoteItems.forEach((element, index) => {
            if (element === p) { this.item.supplierQuoteItems.splice(index, 1); }
        });
    }

    public editSupplierQuoteItem(p: SupplierQuoteItemDto) {
        this.supplierQuoteItemsElement = {... p};
        this.activeTab = 0;
    }


    public validateForm(): void{
        this.errorMessages = new Array<string>();
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
    get supplier(): SupplierDto {
        return this.supplierService.item;
    }
    set supplier(value: SupplierDto) {
        this.supplierService.item = value;
    }
    get suppliers(): Array<SupplierDto> {
        return this.supplierService.items;
    }
    set suppliers(value: Array<SupplierDto>) {
        this.supplierService.items = value;
    }
    get createSupplierDialog(): boolean {
       return this.supplierService.createDialog;
    }
    set createSupplierDialog(value: boolean) {
        this.supplierService.createDialog= value;
    }





    get supplierQuoteItemsElement(): SupplierQuoteItemDto {
        if( this._supplierQuoteItemsElement == null )
            this._supplierQuoteItemsElement = new SupplierQuoteItemDto();
        return this._supplierQuoteItemsElement;
    }

    set supplierQuoteItemsElement(value: SupplierQuoteItemDto) {
        this._supplierQuoteItemsElement = value;
    }

}
