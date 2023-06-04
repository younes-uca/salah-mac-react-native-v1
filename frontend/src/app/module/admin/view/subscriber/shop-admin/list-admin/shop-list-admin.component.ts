import {Component, OnInit} from '@angular/core';
import {ShopService} from 'src/app/controller/service/Shop.service';
import {ShopDto} from 'src/app/controller/model/Shop.model';
import {ShopCriteria} from 'src/app/controller/criteria/ShopCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { StoreService } from 'src/app/controller/service/Store.service';

import {StoreDto} from 'src/app/controller/model/Store.model';


@Component({
  selector: 'app-shop-list-admin',
  templateUrl: './shop-list-admin.component.html'
})
export class ShopListAdminComponent extends AbstractListController<ShopDto, ShopCriteria, ShopService>  implements OnInit {

    fileName = 'Shop';

    stores :Array<StoreDto>;
  
    constructor(shopService: ShopService, private storeService: StoreService) {
        super(shopService);
        this.pdfName='Shop.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadStore();
    }

    public async loadShops(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Shop', 'list');
        isPermistted ? this.service.findAll().subscribe(shops => this.items = shops,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'address', header: 'Address'},
            {field: 'store?.libelle', header: 'Store'},
        ];
    }


    public async loadStore(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Shop', 'list');
        isPermistted ? this.storeService.findAllOptimized().subscribe(stores => this.stores = stores,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: ShopDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                 'Address': e.address ,
                'Store': e.store?.libelle ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Address': this.criteria.address ? this.criteria.address : environment.emptyForExport ,
        //'Store': this.criteria.store?.libelle ? this.criteria.store?.libelle : environment.emptyForExport ,
        }];
      }
}
