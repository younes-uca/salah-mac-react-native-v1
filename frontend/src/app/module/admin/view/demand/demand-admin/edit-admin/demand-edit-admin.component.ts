import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {DemandService} from 'src/app/controller/service/Demand.service';
import {DemandDto} from 'src/app/controller/model/Demand.model';
import {DemandCriteria} from 'src/app/controller/criteria/DemandCriteria.model';


import {ClientDto} from 'src/app/controller/model/Client.model';
import {ClientService} from 'src/app/controller/service/Client.service';
import {DemandStatusDto} from 'src/app/controller/model/DemandStatus.model';
import {DemandStatusService} from 'src/app/controller/service/DemandStatus.service';
import {ProductDto} from 'src/app/controller/model/Product.model';
import {ProductService} from 'src/app/controller/service/Product.service';
import {DemandItemDto} from 'src/app/controller/model/DemandItem.model';
import {DemandItemService} from 'src/app/controller/service/DemandItem.service';

@Component({
  selector: 'app-demand-edit-admin',
  templateUrl: './demand-edit-admin.component.html'
})
export class DemandEditAdminComponent extends AbstractEditController<DemandDto, DemandCriteria, DemandService>   implements OnInit {

    private _demandItemsElement = new DemandItemDto();





    constructor( private demandService: DemandService , private clientService: ClientService, private demandStatusService: DemandStatusService, private productService: ProductService, private demandItemService: DemandItemService) {
        super(demandService);
    }

    ngOnInit(): void {
        this.demandItemsElement.product = new ProductDto();
        this.productService.findAll().subscribe((data) => this.products = data);

    this.client = new ClientDto();
    this.clientService.findAll().subscribe((data) => this.clients = data);
    this.demandStatus = new DemandStatusDto();
    this.demandStatusService.findAll().subscribe((data) => this.demandStatuss = data);
}
    public prepareEdit() {
        this.item.demandDate = this.demandService.format(this.item.demandDate);
    }



    public validateDemandItems(){
        this.errorMessages = new Array();
    }
    public setValidation(value : boolean){
        }
   public addDemandItems() {
        if( this.item.demandItems == null )
            this.item.demandItems = new Array<DemandItemDto>();
       this.validateDemandItems();
       if (this.errorMessages.length === 0) {
            if(this.demandItemsElement.id == null){
                this.item.demandItems.push(this.demandItemsElement);
            }else{
                const index = this.item.demandItems.findIndex(e => e.id == this.demandItemsElement.id);
                this.item.demandItems[index] = this.demandItemsElement;
            }
          this.demandItemsElement = new DemandItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteDemandItem(p: DemandItemDto) {
        this.item.demandItems.forEach((element, index) => {
            if (element === p) { this.item.demandItems.splice(index, 1); }
        });
    }

    public editDemandItem(p: DemandItemDto) {
        this.demandItemsElement = {... p};
        this.activeTab = 0;
    }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



   public async openCreateDemandStatus(demandStatus: string) {
        const isPermistted = await this.roleService.isPermitted('DemandStatus', 'edit');
        if(isPermistted) {
             this.demandStatus = new DemandStatusDto();
             this.createDemandStatusDialog = true;
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
   get client(): ClientDto {
       return this.clientService.item;
   }
  set client(value: ClientDto) {
        this.clientService.item = value;
   }
   get clients(): Array<ClientDto> {
        return this.clientService.items;
   }
   set clients(value: Array<ClientDto>) {
        this.clientService.items = value;
   }
   get createClientDialog(): boolean {
       return this.clientService.createDialog;
   }
  set createClientDialog(value: boolean) {
       this.clientService.createDialog= value;
   }
   get demandStatus(): DemandStatusDto {
       return this.demandStatusService.item;
   }
  set demandStatus(value: DemandStatusDto) {
        this.demandStatusService.item = value;
   }
   get demandStatuss(): Array<DemandStatusDto> {
        return this.demandStatusService.items;
   }
   set demandStatuss(value: Array<DemandStatusDto>) {
        this.demandStatusService.items = value;
   }
   get createDemandStatusDialog(): boolean {
       return this.demandStatusService.createDialog;
   }
  set createDemandStatusDialog(value: boolean) {
       this.demandStatusService.createDialog= value;
   }

    get demandItemsElement(): DemandItemDto {
        if( this._demandItemsElement == null )
            this._demandItemsElement = new DemandItemDto();
         return this._demandItemsElement;
    }

    set demandItemsElement(value: DemandItemDto) {
        this._demandItemsElement = value;
    }


}
