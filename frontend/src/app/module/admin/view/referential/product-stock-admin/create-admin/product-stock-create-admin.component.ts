import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {ProductStockService} from 'src/app/controller/service/ProductStock.service';
import {ProductStockDto} from 'src/app/controller/model/ProductStock.model';
import {ProductStockCriteria} from 'src/app/controller/criteria/ProductStockCriteria.model';
import {ProductDto} from 'src/app/controller/model/Product.model';
import {ProductService} from 'src/app/controller/service/Product.service';
import {ShopDto} from 'src/app/controller/model/Shop.model';
import {ShopService} from 'src/app/controller/service/Shop.service';
@Component({
  selector: 'app-product-stock-create-admin',
  templateUrl: './product-stock-create-admin.component.html'
})
export class ProductStockCreateAdminComponent extends AbstractCreateController<ProductStockDto, ProductStockCriteria, ProductStockService>  implements OnInit {




    constructor( private productStockService: ProductStockService , private productService: ProductService, private shopService: ShopService) {
        super(productStockService);
    }

    ngOnInit(): void {
    this.shop = new ShopDto();
    this.shopService.findAll().subscribe((data) => this.shops = data);
    this.product = new ProductDto();
    this.productService.findAll().subscribe((data) => this.products = data);
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



    public async openCreateProduct(product: string) {
    const isPermistted = await this.roleService.isPermitted('Product', 'add');
    if(isPermistted) {
         this.product = new ProductDto();
         this.createProductDialog = true;
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
    get shop(): ShopDto {
        return this.shopService.item;
    }
    set shop(value: ShopDto) {
        this.shopService.item = value;
    }
    get shops(): Array<ShopDto> {
        return this.shopService.items;
    }
    set shops(value: Array<ShopDto>) {
        this.shopService.items = value;
    }
    get createShopDialog(): boolean {
       return this.shopService.createDialog;
    }
    set createShopDialog(value: boolean) {
        this.shopService.createDialog= value;
    }






}
