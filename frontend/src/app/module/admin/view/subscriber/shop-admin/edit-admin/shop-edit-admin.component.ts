import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {ShopService} from 'src/app/controller/service/Shop.service';
import {ShopDto} from 'src/app/controller/model/Shop.model';
import {ShopCriteria} from 'src/app/controller/criteria/ShopCriteria.model';


import {StoreDto} from 'src/app/controller/model/Store.model';
import {StoreService} from 'src/app/controller/service/Store.service';

@Component({
  selector: 'app-shop-edit-admin',
  templateUrl: './shop-edit-admin.component.html'
})
export class ShopEditAdminComponent extends AbstractEditController<ShopDto, ShopCriteria, ShopService>   implements OnInit {






    constructor( private shopService: ShopService , private storeService: StoreService) {
        super(shopService);
    }

    ngOnInit(): void {
    this.store = new StoreDto();
    this.storeService.findAll().subscribe((data) => this.stores = data);
}


    public setValidation(value : boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



   public async openCreateStore(store: string) {
        const isPermistted = await this.roleService.isPermitted('Store', 'edit');
        if(isPermistted) {
             this.store = new StoreDto();
             this.createStoreDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get store(): StoreDto {
       return this.storeService.item;
   }
  set store(value: StoreDto) {
        this.storeService.item = value;
   }
   get stores(): Array<StoreDto> {
        return this.storeService.items;
   }
   set stores(value: Array<StoreDto>) {
        this.storeService.items = value;
   }
   get createStoreDialog(): boolean {
       return this.storeService.createDialog;
   }
  set createStoreDialog(value: boolean) {
       this.storeService.createDialog= value;
   }



}
