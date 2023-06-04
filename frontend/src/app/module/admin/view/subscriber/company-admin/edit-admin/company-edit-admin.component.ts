import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {CompanyService} from 'src/app/controller/service/Company.service';
import {CompanyDto} from 'src/app/controller/model/Company.model';
import {CompanyCriteria} from 'src/app/controller/criteria/CompanyCriteria.model';


import {StoreDto} from 'src/app/controller/model/Store.model';
import {StoreService} from 'src/app/controller/service/Store.service';
import {SubscriberDto} from 'src/app/controller/model/Subscriber.model';
import {SubscriberService} from 'src/app/controller/service/Subscriber.service';

@Component({
  selector: 'app-company-edit-admin',
  templateUrl: './company-edit-admin.component.html'
})
export class CompanyEditAdminComponent extends AbstractEditController<CompanyDto, CompanyCriteria, CompanyService>   implements OnInit {

    private _storesElement = new StoreDto();





    constructor( private companyService: CompanyService , private storeService: StoreService, private subscriberService: SubscriberService) {
        super(companyService);
    }

    ngOnInit(): void {

    this.subscriber = new SubscriberDto();
    this.subscriberService.findAll().subscribe((data) => this.subscribers = data);
}


    public validateStores(){
        this.errorMessages = new Array();
    }
    public setValidation(value : boolean){
        }
   public addStores() {
        if( this.item.stores == null )
            this.item.stores = new Array<StoreDto>();
       this.validateStores();
       if (this.errorMessages.length === 0) {
            if(this.storesElement.id == null){
                this.item.stores.push(this.storesElement);
            }else{
                const index = this.item.stores.findIndex(e => e.id == this.storesElement.id);
                this.item.stores[index] = this.storesElement;
            }
          this.storesElement = new StoreDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteStore(p: StoreDto) {
        this.item.stores.forEach((element, index) => {
            if (element === p) { this.item.stores.splice(index, 1); }
        });
    }

    public editStore(p: StoreDto) {
        this.storesElement = {... p};
        this.activeTab = 0;
    }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



   public async openCreateSubscriber(subscriber: string) {
        const isPermistted = await this.roleService.isPermitted('Subscriber', 'edit');
        if(isPermistted) {
             this.subscriber = new SubscriberDto();
             this.createSubscriberDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get subscriber(): SubscriberDto {
       return this.subscriberService.item;
   }
  set subscriber(value: SubscriberDto) {
        this.subscriberService.item = value;
   }
   get subscribers(): Array<SubscriberDto> {
        return this.subscriberService.items;
   }
   set subscribers(value: Array<SubscriberDto>) {
        this.subscriberService.items = value;
   }
   get createSubscriberDialog(): boolean {
       return this.subscriberService.createDialog;
   }
  set createSubscriberDialog(value: boolean) {
       this.subscriberService.createDialog= value;
   }

    get storesElement(): StoreDto {
        if( this._storesElement == null )
            this._storesElement = new StoreDto();
         return this._storesElement;
    }

    set storesElement(value: StoreDto) {
        this._storesElement = value;
    }


}
