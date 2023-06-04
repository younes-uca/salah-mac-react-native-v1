import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {StatusPaymentDemandService} from 'src/app/controller/service/StatusPaymentDemand.service';
import {StatusPaymentDemandDto} from 'src/app/controller/model/StatusPaymentDemand.model';
import {StatusPaymentDemandCriteria} from 'src/app/controller/criteria/StatusPaymentDemandCriteria.model';



@Component({
  selector: 'app-status-payment-demand-edit-admin',
  templateUrl: './status-payment-demand-edit-admin.component.html'
})
export class StatusPaymentDemandEditAdminComponent extends AbstractEditController<StatusPaymentDemandDto, StatusPaymentDemandCriteria, StatusPaymentDemandService>   implements OnInit {


    private _validStatusPaymentDemandLibelle = true;
    private _validStatusPaymentDemandCode = true;




    constructor( private statusPaymentDemandService: StatusPaymentDemandService ) {
        super(statusPaymentDemandService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        this.validStatusPaymentDemandLibelle = value;
        this.validStatusPaymentDemandCode = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateStatusPaymentDemandLibelle();
        this.validateStatusPaymentDemandCode();
    }
    public validateStatusPaymentDemandLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validStatusPaymentDemandLibelle = false;
        } else {
            this.validStatusPaymentDemandLibelle = true;
        }
    }
    public validateStatusPaymentDemandCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validStatusPaymentDemandCode = false;
        } else {
            this.validStatusPaymentDemandCode = true;
        }
    }






    get validStatusPaymentDemandLibelle(): boolean {
        return this._validStatusPaymentDemandLibelle;
    }
    set validStatusPaymentDemandLibelle(value: boolean) {
        this._validStatusPaymentDemandLibelle = value;
    }
    get validStatusPaymentDemandCode(): boolean {
        return this._validStatusPaymentDemandCode;
    }
    set validStatusPaymentDemandCode(value: boolean) {
        this._validStatusPaymentDemandCode = value;
    }

}
