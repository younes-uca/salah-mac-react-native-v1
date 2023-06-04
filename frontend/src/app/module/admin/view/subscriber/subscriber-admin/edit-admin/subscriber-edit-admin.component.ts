import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {SubscriberService} from 'src/app/controller/service/Subscriber.service';
import {SubscriberDto} from 'src/app/controller/model/Subscriber.model';
import {SubscriberCriteria} from 'src/app/controller/criteria/SubscriberCriteria.model';


import {CompanyDto} from 'src/app/controller/model/Company.model';
import {CompanyService} from 'src/app/controller/service/Company.service';
import {StoreDto} from 'src/app/controller/model/Store.model';
import {StoreService} from 'src/app/controller/service/Store.service';

@Component({
  selector: 'app-subscriber-edit-admin',
  templateUrl: './subscriber-edit-admin.component.html'
})
export class SubscriberEditAdminComponent extends AbstractEditController<SubscriberDto, SubscriberCriteria, SubscriberService>   implements OnInit {

    private _companysElement = new CompanyDto();





    constructor( private subscriberService: SubscriberService , private companyService: CompanyService) {
        super(subscriberService);
    }

    ngOnInit(): void {

}
    public prepareEdit() {
        this.item.creationDate = this.subscriberService.format(this.item.creationDate);
    }



    public validateCompanys(){
        this.errorMessages = new Array();
    }
    public setValidation(value : boolean){
        }
   public addCompanys() {
        if( this.item.companys == null )
            this.item.companys = new Array<CompanyDto>();
       this.validateCompanys();
       if (this.errorMessages.length === 0) {
            if(this.companysElement.id == null){
                this.item.companys.push(this.companysElement);
            }else{
                const index = this.item.companys.findIndex(e => e.id == this.companysElement.id);
                this.item.companys[index] = this.companysElement;
            }
          this.companysElement = new CompanyDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteCompany(p: CompanyDto) {
        this.item.companys.forEach((element, index) => {
            if (element === p) { this.item.companys.splice(index, 1); }
        });
    }

    public editCompany(p: CompanyDto) {
        this.companysElement = {... p};
        this.activeTab = 0;
    }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }





    get companysElement(): CompanyDto {
        if( this._companysElement == null )
            this._companysElement = new CompanyDto();
         return this._companysElement;
    }

    set companysElement(value: CompanyDto) {
        this._companysElement = value;
    }


}
